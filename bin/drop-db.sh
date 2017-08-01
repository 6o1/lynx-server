#!/bin/bash

####
# Drops Lynx database - Use this only for debug purposes!
####

# set up bash to handle errors more aggressively - a "strict mode" of sorts
set -e # give an error if any command finishes with a non-zero exit code
set -u # give an error if we reference unset variables
set -o pipefail # for a pipeline, if any of the commands fail with a non-zero exit code, fail the entire pipeline with that exit code

echo "Dropping database..."
mongo lynxdb --eval "db.dropDatabase()"
