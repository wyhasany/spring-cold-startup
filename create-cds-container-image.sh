#!/usr/bin/env bash
set -e

docker build -t spring-cold-startup:cds -f Dockerfile.cds .
