#!/bin/bash

cd $(dirname "$0")
java -cp ${project.parent.artifactId}-${project.version}-jar-with-dependencies.jar ci.example.Bar $1