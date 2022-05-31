#!/bin/bash

error() {
  echo "Something went wrong!"
  exit 1;
}

trap 'exit 0' SIGTERM

pull_images() {
    echo 'Pulling images...'
    $1 pull docker.io/library/postgres:latest || error
    $1 pull docker.io/library/tomcat:latest || error
    $1 pull docker.io/dpage/pgadmin4:latest || error
}

create_pod() {
  echo 'Creating pod...'
  podman pod create --name lifenance -p 8080:80 -p 8888:8080 || die > /dev/null 2>&1
}

config_network() {
    echo 'Creating network'
    docker network create --subnet=172.20.0.0/16 lifenance || die > /dev/null 2>&1
}

create_containers() {
    echo 'Creating containers...'
    if [[ "$1" == "podman" ]] ; then
        ARG1="--pod lifenance"
        ARG2="--pod lifenance"
        ARG3="--pod lifenance"
    else
        ARG1="--net lifenance --ip 172.20.0.10"
        ARG2="--net lifenance --ip 172.20.0.11"
        ARG3="--net lifenance --ip 172.20.0.12"
    fi  

    $1 run $ARG1 \
        --name db_postgres -d \
        -e POSTGRES_USER=admin \
        -e POSTGRES_PASSWORD=admin \
        docker.io/library/postgres || die > /dev/null 2>&1

    $1 run $ARG2 -d --name pgadmin \
        -e PGADMIN_DEFAULT_EMAIL=admin@admin.com \
        -e PGADMIN_DEFAULT_PASSWORD=admin \
        docker.io/dpage/pgadmin4:latest || die > /dev/null 2>&1

    $1 run $ARG3 -d --name tomcat \
        docker.io/library/tomcat:latest || die > /dev/null 2>&1

    echo 'Containers created!'
}

config_tomcat() {
  echo 'Configuring tomcat...'

  $1 exec tomcat rmdir webapps
  $1 exec tomcat mv webapps.dist webapps
  $1 exec tomcat sed -ie '/<Valve/,/>/d' webapps/manager/META-INF/context.xml
  $1 exec tomcat sed -i '56i\\t<role rolename="manager-gui"/>' conf/tomcat-users.xml
  $1 exec tomcat sed -i '57i\\t<role rolename="manager-jmx"/>' conf/tomcat-users.xml
  $1 exec tomcat sed -i '58i\\t<role rolename="manager-script"/>' conf/tomcat-users.xml
  $1 exec tomcat sed -i '59i\\t<user username="tomcat" password="123456" roles="manager-gui,manager-script,manager-jmx"/>' conf/tomcat-users.xml

  podman restart tomcat
}

case "$1" in 
    "help")
        echo "Usage:"
        echo "  config.sh [docker|help|podman]"
        echo "  config.sh clean [podman|docker]"
        echo ""
        echo "Commands:"
        echo "  docker: create development environment using docker."
        echo "  podman: crete development environment using podman."
        echo "  help: Show this message and exit."
        echo "  clean: remove all stuff created by this script."
        echo ""
        echo "Clean targets:"
        echo "  podman: remove all stuff created by this script using podman."
        echo "  docker: remove all stuff created by this script using docker."
        exit 0;
    ;;
    "docker")
        if [[ -z $(command -v docker) ]] ; then
            echo 'docker not installed!'
            exit 1
        fi
        echo "This script config containers using static ips."
        pull_images docker
        config_network
        create_containers docker
        config_tomcat docker
        echo "Containers IPs:"
        echo 'NAME      IP'
        echo 'postgres  172.20.0.10'
        echo 'pgadmin4  172.20.0.11'
        echo 'tomcat    172.20.0.12'
    ;;
    "podman")
        if [[ -z $(command -v podman) ]] ; then
            echo 'Podman not installed!'
            exit 1
        fi
        echo "This script config containers using pod to share the same localhost."
        pull_images podman
        create_pod
        create_containers podman
        config_tomcat podman
    ;;
    "clean")
        case "$2" in 
            "podman")
                podman stop tomcat postgres pgadmin
                podman rm tomcat postgres pgadmin
                podman pod rm lifenance
            ;;
            "docker")
                docker stop tomcat postgres pgadmin
                docker rm tomcat postgres pgadmin
                docker network rm lifenance
            ;;
            *)
                echo "Error: unrecognized clean target '$1'"
                echo "Try 'config help' for more information"
            ;;
        esac
    ;;
    *)
        echo "Error: unrecognized command '$1'"
        echo "Try 'config help' for more information"
    ;;
esac

echo 'Successfully!'
