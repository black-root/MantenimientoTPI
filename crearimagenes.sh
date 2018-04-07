#!/bin/bash

docker rm conpayaratpi
docker rm conmdbtpi
docker rm paymicro

docker rmi -f payaratpi
docker rmi -f mariadbtpi
docker rmi -f sergiopa

docker build -t mariadbtpi ./MariaDB
docker build -t payaratpi ./Payarafull
docker build -t sergiopa ./Payaramicro

