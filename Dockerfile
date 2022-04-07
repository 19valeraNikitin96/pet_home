FROM ubuntu:20.04
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get update && apt-get install -y init default-jre iproute2 maven vim curl
WORKDIR /app
RUN touch pet_home.mv.db
COPY . .
RUN mvn clean compile
CMD ["mvn", "spring-boot:run"]