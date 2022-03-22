FROM openjdk:17-alpine
COPY ./src/ /src
WORKDIR /src
RUN javac ./academy/mindswap/WebServer.java
COPY /out/production/web-server-diogo/ /app
COPY ./www/ /app/www
WORKDIR /app
ENTRYPOINT ["java","academy.mindswap.WebServer"]