# javarush

1) собираем war файл:
mvn clean install

2) Копируем в tomcat
rm -rf $CATALINA_HOME/webapps/ROOT
cp ./target/parts-0.0.2-final.war $CATALINA_HOME/webapps/ROOT.war

3) Проливаем в базу sql скрипт test.sql