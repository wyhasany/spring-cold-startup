#!/usr/bin/env bash
set -e

case $(uname -m) in
    arm64)   url="https://cdn.azul.com/zulu/bin/zulu21.30.23-ca-crac-jdk21.0.1-linux_aarch64.tar.gz" ;;
    *)       url="https://cdn.azul.com/zulu/bin/zulu21.30.23-ca-crac-jdk21.0.1-linux_x64.tar.gz" ;;
esac

echo "Using CRaC enabled JDK $url"

./gradlew clean build -x test
docker build -t crac-container:builder -f Dockerfile-cracdeploy --build-arg CRAC_JDK_URL=$url .
docker run -d --privileged --rm --name=crac-container crac-container:builder
echo "Please wait during creating the checkpoint..."
sleep 20
docker commit --change='ENTRYPOINT ["/opt/app/entrypoint.sh"]' \
       $(docker ps -qf "name=crac-container") \
       crac-container:checkpoint
docker kill $(docker ps -qf "name=crac-container")
