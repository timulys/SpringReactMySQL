# 1단계: Gradle로 build
FROM gradle:8.4.0-jdk17 AS builder
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle build --no-daemon

# 2단계: 실행용 이미지 생성
FROM openjdk:17-jdk-alpine
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
