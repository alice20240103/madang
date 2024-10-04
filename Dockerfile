# 1단계: Maven을 사용하여 스프링부트 프로젝트 빌드
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . . 
RUN mvn clean package -DskipTests

# 2단계: 빌드된 JAR파일을 실행할 OPENJDK 이미지를 이용하여 Docker 이미지 생성
FROM openjdk:17-jdk
VOLUME /uploadtest
WORKDIR /app


# JAR 파일을 복사합니다
COPY --from=build /app/target/*.jar app.jar

# 컨테이너 실행 시 JAVA_OPTS 환경 변수를 사용하여 SSL 설정을 전달합니다
ENTRYPOINT ["java", "-jar", "app.jar"]
