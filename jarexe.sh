#!/usr/bin/env bash
set -e

if [ ! -f build/libs/spring-cold-startup-0.0.1-SNAPSHOT.jar ]; then
  ./gradlew build -x test
fi
if [[ $1 != "-b" ]]; then
  java -jar build/libs/spring-cold-startup-0.0.1-SNAPSHOT.jar
fi
