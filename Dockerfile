FROM cimg/openjdk:11.0

ADD target /usr/target

EXPOSE ${PORT}

CMD [ "java", "-jar", "/usr/target/game-news-crawler-0.0.1-SNAPSHOT.jar" ] 

