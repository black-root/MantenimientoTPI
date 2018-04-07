#!/bin/bash
docker rm conpayaratpi
docker rm conmdbtpi

mvn clean install

rm  Payaramicro/MantenimientoTPI-web.war
mv  MantenimientoTPI-web/target/MantenimientoTPI-web-1.0-SNAPSHOT.war Payaramicro/MantenimientoTPI-web.war

#google-chrome  http://localhost:8080/MantenimientoTPI-web/
docker-compose up

