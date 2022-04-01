FROM adoptopenjdk/openjdk11 as builder
MAINTAINER yaolei03 "yaolei03@gmail.com"

ARG WORK_DIR=/root
ARG JAR_FILE=target/*.jar
WORKDIR ${WORK_DIR}
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract
RUN echo 'after extract'
RUN /bin/bash -c "ls -al ${WORK_DIR}"

FROM adoptopenjdk/openjdk11
ARG WORK_DIR=/root
WORKDIR ${WORK_DIR}
COPY --from=builder ${WORK_DIR}/dependencies/ .
COPY --from=builder ${WORK_DIR}/spring-boot-loader/ .
COPY --from=builder ${WORK_DIR}/my-dependencies/ .
COPY --from=builder ${WORK_DIR}/application/ .

RUN mkdir -p /data/log

# CMD和ENTRYPOINT区别，都支持exec模式和shell模式,exec模式pid=1就是任务进程
CMD ["java", \
  "-XX:+UnlockExperimentalVMOptions", \
  "-XX:+UseContainerSupport", \
  "-XX:NativeMemoryTracking=summary", \
  "-Xms2g", \
  "-Xmx2g", \
  "-XX:MetaspaceSize=128M", \
  "-XX:MaxMetaspaceSize=256M", \
  "-XX:MaxDirectMemorySize=128M", \
  "-XX:ParallelGCThreads=4", \
  "-XX:ConcGCThreads=1", \
  "-XX:+UseG1GC", \
  "-XX:MaxGCPauseMillis=100", \
  "-XX:+ParallelRefProcEnabled",  \
  "-Xlog:gc*=info,gc+age*=debug,gc+ref*=debug,gc+ergo*=debug:file=/data/log/gc.log:time,level,tags", \
  "-XX:+PrintCommandLineFlags", \
  "-XX:+HeapDumpOnOutOfMemoryError", \
  "-XX:HeapDumpPath=/data/log/dumps", \
  "-XX:ErrorFile=/data/log/piderrors.log", \
  "-XX:+UseCompressedOops", \
  "-XX:+AlwaysPreTouch", \
  "-XX:AutoBoxCacheMax=10000", \
  "org.springframework.boot.loader.JarLauncher", \
  "--spring.profiles.active=prod"]


