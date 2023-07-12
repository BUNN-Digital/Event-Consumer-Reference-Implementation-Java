#!/bin/bash
set -Eeuxo pipefail

timestamp=`date +"%Y-%m-%d_%H%M%S"`
echo $timestamp

version="$(docker run --rm -v `pwd`:/git-semver ghcr.io/mdomke/git-semver -no-meta)"
echo $version

tag=$version-$timestamp
echo $tag

./mvnw verify -U -T 3 --fail-at-end
./mvnw clean install -DskipTests -DskipITs -Drevision=$version
./mvnw deploy -DskipTests -DskipITs -Drevision=$version

### Local Build
docker build -t report-api:$tag .

### DockerHub
docker tag report-api:$tag bunndigital/report-api:$tag
docker push bunndigital/report-api:$tag

### GitLab
docker tag report-api:$tag registry.gitlab.com/bunn-digital/web/report-api-group/report-api:$tag
docker push registry.gitlab.com/bunn-digital/web/report-api-group/report-api:$tag

### Artifactory
#docker tag report-api:$tag bunn.jfrog.io/default-docker-virtual/report-api:$tag
#docker push bunn.jfrog.io/default-docker-virtual/report-api:$tag

# For Marc's own convenience
echo $tag
