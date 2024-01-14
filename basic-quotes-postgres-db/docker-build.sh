#!/bin/bash
set -x
../mvnw clean package
docker build . -t basic-quotes-postgres-db:1
docker images *quotes*