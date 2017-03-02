FROM ubuntu:15.04

# Install Java.

RUN apt-get -y update

RUN apt-get -y install software-properties-common

RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer

# Create app directory
RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

COPY ./target/helloworld-impl-1.0-SNAPSHOT /usr/src/app

CMD bash -C 'bin/helloworld-impl';'bash'