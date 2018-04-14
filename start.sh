#!/bin/bash
#docker rm conpayaratpi
#docker rm conmdbtpi
docker rm mariamicro
docker rm paymicro

#docker rmi -f payaratpi
docker rmi -f mariadbtpi
docker rmi -f sergiopa

chmod 777 Payaramicro/domain.xml

mvn clean install

rm  Payaramicro/MantenimientoTPI-web.war
cp  MantenimientoTPI-web/target/MantenimientoTPI-web-1.0-SNAPSHOT.war Payaramicro/MantenimientoTPI-web.war

docker build -t mariadbtpi ./MariaDB
#docker build -t payaratpi ./Payarafull
docker build -t sergiopa ./Payaramicro
#google-chrome  http://localhost:8080/MantenimientoTPI-web/
docker-compose up


