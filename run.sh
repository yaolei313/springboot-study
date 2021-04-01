#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true

cp target/*.jar springboot-study.jar

echo `java -version`

# -XX:+UseContainerSupport \ only in docker
# -XX:+IgnoreUnrecognizedVMOptions \
# https://docs.oracle.com/en/java/javase/14/docs/specs/man/java.html#xlog-usage-examples

java -XX:+UnlockExperimentalVMOptions \
  -Xms2g \
  -Xmx2g \
  -XX:MetaspaceSize=128M \
  -XX:MaxMetaspaceSize=256M \
  -XX:MaxDirectMemorySize=128M \
  -XX:ParallelGCThreads=4 \
  -XX:ConcGCThreads=1 \
  -XX:+UseG1GC \
  -XX:MaxGCPauseMillis=100 \
  -XX:+ParallelRefProcEnabled  \
  -Xlog:all=info:file=/tmp/gc-%p.log,filesize=100M,filecount=5:time,level,tags \
  -XX:+PrintCommandLineFlags \
  -XX:+HeapDumpOnOutOfMemoryError \
  -XX:HeapDumpPath=/tmp/dumps \
  -XX:ErrorFile=/tmp/piderrors.log \
  -XX:+UseCompressedOops \
  -XX:+AlwaysPreTouch \
  -XX:AutoBoxCacheMax=10000 \
  -jar springboot-study.jar \
  --spring.profiles.active=prod
  

