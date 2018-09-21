## Инструкция
Грузим все к себе

    git clone https://github.com/jonnydrax/javarush.git
    cd ./javarush

собираем war файл:

    mvn clean install

Копируем в tomcat

    rm -rf $CATALINA_HOME/webapps/ROOT
    cp ./target/parts-0.0.2-final.war $CATALINA_HOME/webapps/ROOT.war

Проливаем в базу sql скрипт test.sql

Запускаем Tomcat

    $CATALINA_HOME/bin/startup.sh

Заходим и проверяем результат 

    http://localhost:8080/
