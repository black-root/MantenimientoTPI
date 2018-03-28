#!/bin/bash
docker rm conpayaratpi
docker rm conmdbtpi

docker rmi -f payaratpi
docker rmi -f mariadbtpi

mvn clean install
#rm Payarafull/MantenimientoTPI-ear-1.0-SNAPSHOT.ear
#mv MantenimientoTPI-ear/target/MantenimientoTPI-ear-1.0-SNAPSHOT.ear Payarafull/
rm  Payarafull/MantenimientoTPI-web.war
mv  MantenimientoTPI-web/target/MantenimientoTPI-web-1.0-SNAPSHOT.war Payarafull/MantenimientoTPI-web.war


docker build -t mariadbtpi ./MariaDB
docker build -t payaratpi ./Payarafull

docker-compose up

