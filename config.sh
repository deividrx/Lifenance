#!/bin/bash
trap exit 0

if [[ -z $(command -v podman) ]] ; then
    echo 'Podman not installed!'
    sudo apt-get -y update
    sudo apt-get -y install podman
fi

echo 'Pulling images...'

podman pull postgres
podman pull tomcat
podman pull dpage/pgadmin4

echo 'Creating pod...'

podman pod create --name lifenance -p 8080:80 -p 8888:8080

echo 'Creating containers...'

podman run --pod lifenance \
--name db_postgres -d \
-e POSTGRES_USER=admin \
-e POSTGRES_PASSWORD=admin \
docker.io/library/postgres

podman run --pod lifenance -d --name pgadmin \
-e PGADMIN_DEFAULT_EMAIL=admin@admin.com \
-e PGADMIN_DEFAULT_PASSWORD=admin \
docker.io/dpage/pgadmin4:latest

podman run -d --pod lifenance --name tomcat \
docker.io/library/tomcat:latest

echo 'Containers created!'
echo 'Configuring tomcat...'

podman exec tomcat rmdir webapps
podman exec tomcat mv webapps.dist webapps
podman exec tomcat sed -ie '/<Valve/,/>/d' webapps/manager/META-INF/context.xml
podman exec tomcat sed -i '56i\\t<role rolename="manager-gui"/>' conf/tomcat-users.xml
podman exec tomcat sed -i '57i\\t<role rolename="manager-jmx"/>' conf/tomcat-users.xml
podman exec tomcat sed -i '58i\\t<role rolename="manager-script"/>' conf/tomcat-users.xml
podman exec tomcat sed -i '59i\\t<user username="tomcat" password="123456" roles="manager-gui,manager-script,manager-jmx"/>' conf/tomcat-users.xml

podman restart tomcat

echo 'Successfully!'
podman ps