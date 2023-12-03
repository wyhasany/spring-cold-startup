#!/usr/bin/env bash
set -e

#https://docs.azul.com/core/crac/crac-guidelines
docker run  \
       --cap-add CHECKPOINT_RESTORE --cap-add=SYS_PTRACE --cap-add SYS_ADMIN --cap-add=NET_ADMIN \
       --rm -p 8080:8080 --name crac-container  \
       crac-container:checkpoint
