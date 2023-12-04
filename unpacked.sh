#!/usr/bin/env bash
set -e

if [ ! -f build/libs/spring-cold-startup-0.0.1-SNAPSHOT.jar ]; then
  ./gradlew build -x test
fi
./unpack-executable-jar.sh -d build/unpacked build/libs/spring-cold-startup-0.0.1-SNAPSHOT.jar
if [[ $1 != "-b" ]]; then
  java -jar build/unpacked/run-app.jar
fi
