#!/bin/bash
docker rmi -f payaratpi
docker rmi -f mariadbtpi:IR13002

mvn clean install

mv /MantenimientoTPI-ear/target/MantenimientoTPI-ear-1.0-SNAPSHOT.ear /Payarafull/MantenimientoTPI-ear-1.0-SNAPSHOT.ear

docker build -t mariadbtpi:IR13002 ./MariaDB
docker build -t payaratpi ./Payarafull

docker-compose up

