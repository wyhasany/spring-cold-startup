#!/usr/bin/env bash
set -e

java -XX:CRaCCheckpointTo=$CRAC_FILES_DIR \
     -jar /tmp/gradle-build/libs/spring-cold-startup-0.0.1-SNAPSHOT.jar&
sleep 5
echo "Load testing of vets.html"
hey -z 10s http://localhost:8080/vets.html
jcmd /tmp/gradle-build/libs/spring-cold-startup-0.0.1-SNAPSHOT.jar JDK.checkpoint
