#######################
#   Build   #
FROM docker.io/library/maven:3.8.5-openjdk-17 AS builder
WORKDIR /usr/local/backend
COPY . ./
RUN mvn clean generate-sources package -DskipTests

#######################
#   Runner  #
FROM --platform=linux/amd64 azul/zulu-openjdk-alpine:17 AS runner
COPY --from=builder /usr/local/backend/target/*.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract
WORKDIR /usr/local/backend

FROM azul/zulu-openjdk-alpine:17
COPY --from=runner dependencies/ ./
COPY --from=runner snapshot-dependencies/ ./
COPY --from=runner spring-boot-loader/ ./
COPY --from=runner application/ ./

EXPOSE 8082
