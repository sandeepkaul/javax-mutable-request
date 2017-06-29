#!/bin/bash

#Cleanup before releasing 
mvn release:clean

#Preparing for the release
mvn release:prepare

mvn release:perform
