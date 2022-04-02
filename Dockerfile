FROM ubuntu:20.04
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get update && apt-get install -y init default-jre iproute2 maven vim
WORKDIR /app
RUN touch pet_home.mv.db
COPY . .
CMD ["mvn", "clean", "compile", "spring-boot:run"]