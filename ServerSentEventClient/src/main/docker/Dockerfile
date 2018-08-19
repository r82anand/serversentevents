FROM java:8
VOLUME /tmp
ADD ServerSentEventClient-0.0.1-SNAPSHOT.jar /opt/ServerSentEventClient-1.0-RELEASE.jar
RUN bash -c 'touch /opt/ServerSentEventClient-1.0-RELEASE.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/ServerSentEventClient-1.0-RELEASE.jar"]
