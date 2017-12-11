#!/bin/bash
./gradlew cleanTest test -i
./gradlew jar
java -jar ./build/libs/toy-robot-1.0-SNAPSHOT.jar test test1 test2