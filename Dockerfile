FROM adoptopenjdk/openjdk12-openj9:alpine-slim
COPY build/libs/*.jar seek.jar
EXPOSE 8080
CMD java  -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar seek.jar