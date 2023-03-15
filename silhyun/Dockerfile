FROM openjdk:11-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY wallet/* /home/ubuntu/Wallet_db3jo2023
ENV TZ=Asia/Seoul
ENTRYPOINT ["java","-jar", "/app.jar"]

