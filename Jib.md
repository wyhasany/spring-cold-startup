# Jib

Build a Docker image for a Spring Boot application using Jib CLI with jar:
```shell
jib jar --target=docker://jib-cli-jlink spring-cold-startup-0.0.1-SNAPSHOT.jar\
 --from=bellsoft/liberica-openjre-alpine:21.0.1-cds\
 --expose=8080\
 --entrypoint='java -cp /app org.springframework.boot.loader.launch.JarLauncher'
 
docker run -p 8080:8080 jib-cli-jlink
```
lack of platform in CLI `jib jar` command. So we need to use `jib build`.
```shell
cd build/libs
java -Djarmode=layertools -jar spring-cold-startup-0.0.1-SNAPSHOT.jar extract
cd ../..
jib build --target=docker://jib-cli-jlink
docker run -p 8080:8080 jib-cli-jlink
```

To build with gradle run:
```shell
./gradlew jibDockerBuild -Djib.dockerClient.executable=/opt/homebrew/bin/docker
dive spring-boot-jib
```
