FROM openjdk:11
VOLUME /tmp
EXPOSE 8084
ADD target/*.jar pension-disbursement-service.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /pension-disbursement-service.jar" ]