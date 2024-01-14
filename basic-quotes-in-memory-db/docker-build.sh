#!/bin/bash
set -x
../mvnw clean package
docker build . -t basic-quotes-in-memory-db:1
docker images *quotes*