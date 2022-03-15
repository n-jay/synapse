FROM gitpod/workspace-base

RUN sudo apt-get update \
    && sudo apt-get install -y \
    && sudo apt-get install -y openjdk-8-jdk \
    && sudo apt-get -y install maven