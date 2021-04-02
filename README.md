### JDK8
* docker
-XX:+UseCGroupMemoryLimitForHeap

```
CMD ["java", \
  "-XX:+UnlockExperimentalVMOptions", \
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
  "-XX:G1LogLevel=finest", \
  "-Xloggc:/data/log/gc.log", \
  "-XX:+PrintCommandLineFlags", \
  "-XX:+PrintGCDetails", \
  "-XX:+PrintGCDateStamps", \
  "-XX:+PrintTenuringDistribution", \
  "-XX:+PrintReferenceGC", \
  "-XX:+PrintAdaptiveSizePolicy", \
  "-XX:+HeapDumpOnOutOfMemoryError", \
  "-XX:HeapDumpPath=/data/log/dumps", \
  "-XX:ErrorFile=/data/log/piderrors.log", \
  "-XX:+UseCompressedOops", \
  "-XX:+AlwaysPreTouch", \
  "-XX:AutoBoxCacheMax=10000", \
  "org.springframework.boot.loader.JarLauncher", \
  "--spring.profiles.active=prod"]
```

### OpenJDK11
* docker
-XX:+UseContainerSupport

```
java -XX:+UnlockExperimentalVMOptions \
  -XX:+UnlockDiagnosticVMOptions \
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
  -Xlog:gc*=info,gc+age*=debug,gc+ref*=debug,gc+ergo*=debug:file=/tmp/gc.log:time,level,tags \
  -XX:+PrintCommandLineFlags \
  -XX:+HeapDumpOnOutOfMemoryError \
  -XX:HeapDumpPath=/tmp/dumps \
  -XX:ErrorFile=/tmp/piderrors.log \
  -XX:+UseCompressedOops \
  -XX:+AlwaysPreTouch \
  -XX:AutoBoxCacheMax=10000 \
  -jar springboot-study-0.0.1-SNAPSHOT.jar \
  --spring.profiles.active=prod
```