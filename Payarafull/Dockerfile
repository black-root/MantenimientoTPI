FROM payara/server-full:4.181 


MAINTAINER Ronald Ibanez <ronadl_reir21@hotmail.com>

ENV PATH $PATH:$PAYARA_PATH/bin

ADD customization/mysql-connector-java-5.0.8-bin.jar  /opt/payara41/glassfish/domains/domain1/lib/ext/

ADD clave.txt /clave.txt

RUN asadmin start-domain && asadmin create-jdbc-connection-pool --user admin --passwordfile /clave.txt \
--datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype javax.sql.DataSource --steadypoolsize=2 --maxpoolsize=2 \
--property user=root:password=1234:DataBaseName=mantenimientoPC:ServerName=172.18.0.1:port=3300:driverClass=com.mysql.jdbc.Driver mantenimientopool && \
asadmin create-jdbc-resource --user admin --passwordfile /opt/pwdfile \
--connectionpoolid mantenimientopool --enabled=true jdni_Mantenimiento

COPY ./wait-for-mariadb.sh ./

ADD MantenimientoTPI-web.war  /opt/payara41/glassfish/domains/domain1/autodeploy/
#COPY  /opt/payara41/glassfish/domains/domain1/autodeploy 

EXPOSE 4848 8080

CMD ["asadmin", "start-domain", "-v"]




