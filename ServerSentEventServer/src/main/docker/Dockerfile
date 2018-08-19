FROM java:8
VOLUME /tmp
ADD ServerSentEventServer-0.0.1-SNAPSHOT.jar /opt/ServerSentEventServer-1.0-RELEASE.jar
RUN bash -c 'touch /opt/ServerSentEventServer-1.0-RELEASE.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/ServerSentEventServer-1.0-RELEASE.jar"]
