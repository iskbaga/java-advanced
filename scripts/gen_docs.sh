#!/bin/bash

JAR="../../java-advanced-2024/artifacts/info.kgeorgiy.java.advanced.implementor.jar"
LIB="../../java-advanced-2024/lib/*"

# :NOTE: документация не генерируется, даже если поправить пути на относительные

# :NOTE: javadoc добавлен в репозиторий, но он должен лежать вкорне репозитория

cd ../java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/
javadoc \
    -private \
    -link https://docs.oracle.com/en/java/javase/14/docs/api/ \
    -d javadoc \
    -cp $JAR:$LIB \
    Implementor.java \
