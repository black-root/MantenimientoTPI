FROM openjdk:8-jdk-alpine

ENV PAYARA_PATH /opt/payara

RUN   apk update \                                                                                                                                                                                                                        
 &&   apk add ca-certificates wget bash \                                                                                                                                                                                                      
 &&   update-ca-certificates && \
 mkdir -p $PAYARA_PATH/deployments && \
 adduser -D -h $PAYARA_PATH payara && echo payara:payara | chpasswd && \
 chown -R payara:payara /opt

ENV PAYARA_VERSION 181
ENV PKG_FILE_NAME payara-micro.jar

ADD payara-micro-5.181.jar $PAYARA_PATH/$PKG_FILE_NAME 

ENV DEPLOY_DIR $PAYARA_PATH/deployments
ENV AUTODEPLOY_DIR $PAYARA_PATH/deployments
ENV PAYARA_MICRO_JAR=$PAYARA_PATH/$PKG_FILE_NAME

#RUN wget -O /opt/payara/deployments/mysql-connector-java-6.0.6.jar http://central.maven.org/maven2/mysql/mysql-connector-java/6.0.6/mysql-connector-java-6.0.6.jar

# Default payara ports to expose
EXPOSE 4848 8009 8080 8181
ADD  MantenimientoTPI-web.war $PAYARA_PATH/deployments/
ADD domain.xml $PAYARA_PATH
COPY ./wait-for-mariadb.sh ./
ADD mysql-connector-java-5.0.8-bin.jar $PAYARA_PATH/deployments
ENTRYPOINT java -jar /opt/payara/payara-micro.jar --autoBindHttp --domainConfig /opt/payara/domain.xml --addJars /opt/payara/deployments/mysql-connector-java-5.0.8-bin.jar --port 8181 --deploy /opt/payara/deployments/MantenimientoTPI-web.war
#CMD ["/bin/bash"]
