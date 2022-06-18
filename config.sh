#!/bin/bash

error() {
  echo "Something went wrong!"
  exit 1;
}

trap 'exit 0' SIGTERM

pull_images() {
    echo 'Pulling images...'
    $1 pull docker.io/library/postgres:latest || error
    $1 pull docker.io/dpage/pgadmin4:latest || error
}

create_pod() {
  echo 'Creating pod...'
  podman pod create --name lifenance -p 8080:80 -p 5432:5432 > /dev/null 2>&1 || error 
}

config_network() {
    echo 'Creating network'
    docker network create --subnet=172.20.0.0/16 lifenance > /dev/null 2>&1 || error
}

create_containers() {
    echo 'Creating containers...'
    if [[ "$1" == "podman" ]] ; then
        ARG1="--pod lifenance"
        ARG2="--pod lifenance"
    else
        ARG1="--net lifenance --ip 172.20.0.10 -p 5432:5432"
        ARG2="--net lifenance --ip 172.20.0.11 -p 8080:80"
    fi  

    $1 run $ARG1 \
        --name postgres -d \
        -e POSTGRES_PASSWORD=admin \
        docker.io/library/postgres > /dev/null 2>&1 || error

    $1 run $ARG2 -d --name pgadmin \
        -e PGADMIN_DEFAULT_EMAIL=admin@admin.com \
        -e PGADMIN_DEFAULT_PASSWORD=admin \
        docker.io/dpage/pgadmin4:latest > /dev/null 2>&1 || error

    echo 'Containers created!'
}

create_database() {
    echo 'Creating lifenance_db'
    
    while ! $1 exec postgres pg_isready -q ;do 
        echo 'Wating postgres startup'
        sleep 5
    done
    
    ($1 exec -i postgres psql -U postgres < lifenance_db.sql) > /dev/null 2>&1 || error
    echo 'Database created!'
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
        create_database docker
        echo 'Successfully!'
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
        create_database podman
        echo 'Successfully!'
    ;;
    "clean")
        case "$2" in 
            "podman")
                podman stop postgres pgadmin
                podman rm postgres pgadmin
                podman pod rm lifenance
            ;;
            "docker")
                docker stop postgres pgadmin
                docker rm postgres pgadmin
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
