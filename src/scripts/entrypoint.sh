#!/bin/bash

CRAC_FILES_DIR=`eval echo ${CRAC_FILES_DIR}`
mkdir -p $CRAC_FILES_DIR

if [ -z "$(ls -A $CRAC_FILES_DIR)" ]; then
  echo 128 > /proc/sys/kernel/ns_last_pid; java -Dspring.context.checkpoint=onRefresh -XX:CRaCCheckpointTo=$CRAC_FILES_DIR -jar /opt/app/app.jar
#  sleep 5
#  hey -z 10s http://localhost:8080/vets.html
#  jcmd /opt/app/app.jar JDK.checkpoint
  sleep infinity
else
  java -XX:CRaCRestoreFrom=$CRAC_FILES_DIR&
  PID=$!
  trap "kill $PID" SIGINT SIGTERM
  wait $PID
fi
