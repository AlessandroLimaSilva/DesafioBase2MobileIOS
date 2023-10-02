#!/bin/bash

mkdir temp
cp -rp target/dependency-jars temp/
cp -r target/*.jar* temp/
mkdir -p temp/DesafioBase2MobileIOS
cp -rp src temp/DesafioBase2MobileIOS
cp pom.xml temp/DesafioBase2MobileIOS
cp serenity.properties temp/DesafioBase2MobileIOS
cd temp
zip -r test_package.zip *
cp test_package.zip ../target