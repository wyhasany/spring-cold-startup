#!/usr/bin/env bash
set -e

docker build -t spring-cold-startup:jarexe -f Dockerfile.jarexe .
