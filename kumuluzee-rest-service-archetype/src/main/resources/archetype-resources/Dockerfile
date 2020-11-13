FROM openjdk:11-jre-slim

ENV JAVA_ENV=DEVELOPMENT
ENV KUMULUZEE_ENV_NAME=dev
ENV KUMULUZEE_ENV_PROD=false
ENV KUMULUZEE_DATASOURCES0_CONNECTIONURL=jdbc:postgresql://localhost:5432/${artifactId}
ENV KUMULUZEE_DATASOURCES0_USERNAME=postgres
ENV KUMULUZEE_DATASOURCES0_PASSWORD=postgres

RUN mkdir /app
WORKDIR /app

ADD ./api/target/${artifactId}.jar /app

EXPOSE 8080

CMD ["java", "-jar", "${artifactId}.jar", "com.kumuluz.ee.EeApplication"]