#!/usr/bin/env bash
set -e

if [ ! -f build/libs/spring-cold-startup-0.0.1-SNAPSHOT.jar ]; then
  ./gradlew build -x test
fi

cd build/libs

java -jar  -Djarmode=layertools spring-cold-startup-0.0.1-SNAPSHOT.jar extract

cp -R dependencies/* .
cp -R spring-boot-loader/* .
cp -R application/* .

java -Dspring.context.exit=onRefresh -XX:ArchiveClassesAtExit=application.jsa org.springframework.boot.loader.launch.JarLauncher
if [[ $1 != "-b" ]]; then
  java -XX:SharedArchiveFile=application.jsa org.springframework.boot.loader.launch.JarLauncher
fi
