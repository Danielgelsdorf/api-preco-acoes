from openjdk:17
COPY ./target/ /usr/src/myapp
WORKDIR /usr/src/myapp
EXPOSE 8080
CMD java -jar api-acoes-0.0.1-SNAPSHOT.jar