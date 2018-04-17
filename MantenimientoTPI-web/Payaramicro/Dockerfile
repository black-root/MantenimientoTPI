FROM payara/micro:5.181
MAINTAINER sergio9508 <gm13006@ues.edu.sv>
EXPOSE 4848 8009 8080 8181
ADD  MantenimientoTPI-web.war $PAYARA_PATH/deployments/
COPY domain.xml ./
COPY dockerize /usr/local/bin
ADD mysql-connector-java-5.0.8-bin.jar $PAYARA_PATH/deployments
CMD dockerize -wait http://172.18.0.1:3300/mantenimientoPC -timeout 50s
ENTRYPOINT java -jar /opt/payara/payara-micro.jar --autoBindHttp --domainConfig domain.xml --addJars /opt/payara/deployments/mysql-connector-java-5.0.8-bin.jar --port 8181 --deploy /opt/payara/deployments/MantenimientoTPI-web.war
#CMD ["/bin/bash"]
