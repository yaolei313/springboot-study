FROM adoptopenjdk/openjdk11 as builder
MAINTAINER allen "allen@xiaohongshu.com"

ARG WORK_DIR=/root
ARG JAR_FILE=target/*.jar
WORKDIR ${WORK_DIR}
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk/openjdk11
ARG WORK_DIR=/root
WORKDIR ${WORK_DIR}
COPY --from=builder ${WORK_DIR}/dependencies/ .
COPY --from=builder ${WORK_DIR}/spring-boot-loader/ .
COPY --from=builder ${WORK_DIR}/red-dependencies/ .
COPY --from=builder ${WORK_DIR}/application/ .

CMD ["java ",
  "-XX:+UnlockExperimentalVMOptions",
  "-XX:+UseCGroupMemoryLimitForHeap",
  "-Xms2g",
  "-Xmx2g",
  "-XX:MetaspaceSize=128M",
  "-XX:MaxMetaspaceSize=256M",
  "-XX:MaxDirectMemorySize=128M",
  "-XX:ParallelGCThreads=4",
  "-XX:ConcGCThreads=1",
  "-XX:+UseG1GC",
  "-XX:MaxGCPauseMillis=100",
  "-XX:+ParallelRefProcEnabled",
  "-XX:G1LogLevel=finest",
  "-Xloggc:/data/log/gc.log",
  "-XX:+PrintCommandLineFlags",
  "-XX:+PrintGCDetails",
  "-XX:+PrintGCDateStamps",
  "-XX:+PrintTenuringDistribution",
  "-XX:+PrintReferenceGC",
  "-XX:+PrintAdaptiveSizePolicy",
  "-XX:+HeapDumpOnOutOfMemoryError",
  "-XX:HeapDumpPath=/data/log/dumps",
  "-XX:ErrorFile=/tmp/log/piderrors.log",
  "-XX:+UseCompressedOops",
  "-XX:+AlwaysPreTouch",
  "-XX:AutoBoxCacheMax=10000",
  "org.springframework.boot.loader.JarLauncher",
  "--spring.profiles.active=prod"]


