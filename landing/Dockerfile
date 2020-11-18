FROM openjdk:13-alpine
VOLUME /tmp
ENV TZ=Europe/Madrid
RUN ln -snf "/usr/share/zoneinfo/$TZ/" "etc/localtime" && echo "$TZ" > "/etc/timezone"
ADD landing/target/infomedia-landing.jar infomedia-landing.jar
EXPOSE 8080
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.profiles.active=pro","infomedia-landing.jar"]