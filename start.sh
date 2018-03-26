#!/bin/bash
docker rm conpayaratpi
docker rm conmdbtpi

docker rmi -f payaratpi
docker rmi -f mariadbtpi:IR13002

mvn clean install
rm Payarafull/MantenimientoTPI-ear-1.0-SNAPSHOT.ear
mv MantenimientoTPI-ear/target/MantenimientoTPI-ear-1.0-SNAPSHOT.ear Payarafull/

docker build -t mariadbtpi:IR13002 ./MariaDB
docker build -t payaratpi ./Payarafull

docker-compose up

