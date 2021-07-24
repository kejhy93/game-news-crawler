FROM cimg/openjdk:11.0

ADD . /usr/game-news-crawler

EXPOSE 8080

RUN mvn package
RUN mvn spring-boot:run

