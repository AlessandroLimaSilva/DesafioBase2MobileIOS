rem @echo off
rem @AlessandroLima 08/06/2023
rem Compilação do projeto mobile para ser executado na aws device farm
echo Iniciando a compilacao do projeto
echo Deletando a pasta target se existir.
call rmdir /s /q target
echo Deletando a pasta temp se existir.
call rmdir /s /q temp
echo Executando o Maven.
call mvn clean package -DskipTests=true
echo Execucao do Maven finalizada.
echo Iniciando Contrucao da estrutura de dados
mkdir temp
xcopy /s target\dependency-jars temp\
xcopy /s target\*.jar* temp\
mkdir temp\QAPortalClienteAPPSerenity
mkdir temp\QAPortalClienteAPPSerenity\src
xcopy /s src temp\QAPortalClienteAPPSerenity\src
xcopy pom.xml temp\QAPortalClienteAPPSerenity
xcopy serenity.properties temp\QAPortalClienteAPPSerenity
cd temp
powershell -Command "Compress-Archive -Path * -DestinationPath test_package.zip"
copy test_package.zip ..\target
cd ..
echo Fim da construcao do projeto
echo arquivo disponivel em target/test_package.zip