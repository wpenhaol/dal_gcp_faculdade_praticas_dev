FROM openjdk

WORKDIR /api

COPY ./build/libs/*.jar /api/pos-eng-app.jar

ENTRYPOINT ["java", "-jar", "pos-eng-app.jar"]
