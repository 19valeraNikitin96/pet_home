FROM ubuntu:20.04
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get update && apt-get install -y init vim python3 python3-pip
RUN pip3 install pytest==7.1.0 requests
WORKDIR /app
COPY . .
CMD ["/sbin/init"]