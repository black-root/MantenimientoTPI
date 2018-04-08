#!/bin/bash
#docker rm conpayaratpi
#docker rm conmdbtpi


docker rm mariamicro
docker rm paymicro

docker rmi -f mariadbtpi
docker rmi -f sergiopa

docker build -t mariadbtpi ./MariaDB
docker build -t sergiopa ./Payaramicro


mvn clean install

rm  Payaramicro/MantenimientoTPI-web.war
cp  MantenimientoTPI-web/target/MantenimientoTPI-web-1.0-SNAPSHOT.war Payaramicro/MantenimientoTPI-web.war

#google-chrome  http://localhost:8080/MantenimientoTPI-web/
docker-compose up

