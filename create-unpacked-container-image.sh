#!/usr/bin/env bash
set -e

docker build -t spring-cold-startup:unpacked -f Dockerfile.unpacked .
