#!/bin/bash

####
#
####

# set up bash to handle errors more aggressively - a "strict mode" of sorts
set -e # give an error if any command finishes with a non-zero exit code
set -u # give an error if we reference unset variables
set -o pipefail # for a pipeline, if any of the commands fail with a non-zero exit code, fail the entire pipeline with that exit code

if [ "$(id -u)" != "0" ]; then
	echo "You don't have sufficient privileges to run this script."
	exit 1
fi

pushd $(dirname $0) > /dev/null
PRJ_ROOT_PATH=$(dirname $(pwd -P))
popd > /dev/null
echo "Project path: $PRJ_ROOT_PATH"

#
# Dependencies
#
echo "Updating package lists..."
apt-get -qq update
apt-get -qq install -y wget git maven gdebi

#
# Mongodb
#
echo "Installing MongoDB server & client..."
apt-get -qq install -y mongodb
service mongodb start

#
# RabbitMQ
#
echo "Installing RabbitMQ server..."
wget -qN https://github.com/rabbitmq/rabbitmq-server/releases/download/rabbitmq_v3_6_10/rabbitmq-server_3.6.10-1_all.deb 

echo "Finished installing Lynx components."

#
# Lombok
#
echo "Starting Lombok installer..."
