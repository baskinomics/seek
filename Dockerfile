# Use AdoptOpenJDK OpenJ9 image
FROM adoptopenjdk/openjdk12-openj9:alpine-slim

# Maintainer information.
LABEL maintainer="Sean Baskin <seanbaskin@gmail.com>"

# Copy our build artifact to the image
COPY build/libs/*.jar seek.jar

# Expose HTTP port
EXPOSE 8080

# todo
CMD java  -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar seek.jar