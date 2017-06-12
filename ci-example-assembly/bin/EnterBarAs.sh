#!/bin/bash

cd $(dirname "$0")
java -cp ci-example-1.0.0-1-SNAPSHOT-jar-with-dependencies.jar ci.example.Bar $1