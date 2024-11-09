#!/bin/bash

# :NOTE: тоже проблема с путями
JARR="/Users/iskanderbagautdinov/Homework/adv-combo/shared/artifacts/info.kgeorgiy.java.advanced.implementor.jar"
LIB="/Users/iskanderbagautdinov/Homework/adv-combo/shared/LIB/*"
DIR="/Users/iskanderbagautdinov/Homework/adv-combo/out/production/adv-combo"
# :NOTE: манифст должен лежать не там, а рядом со скриптом, а не рядом с калссом
MF="/Users/iskanderbagautdinov/Homework/adv-combo/solutions/java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/MANIFEST.MF"
D="info/kgeorgiy/java/advanced/implementor/"

cd /Users/iskanderbagautdinov/Homework/adv-combo
javac -d "$DIR" -cp "$LIB":"$JARR" /Users/iskanderbagautdinov/Homework/adv-combo/solutions/java-solutions/info/kgeorgiy/ja/bagautdinov/implementor/Implementor.java

cd "$DIR"
jar xf "$JARR" "$D"Impler.class "$D"JarImpler.class "$D"ImplerException.class
jar cfm Implementor.jar "$MF" info/kgeorgiy/ja/bagautdinov/implementor/*.class "$D"*.class
rm -rf info
