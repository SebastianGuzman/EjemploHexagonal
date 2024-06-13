## EjemploHexagonal

## 1) Descargar la imagen para la base de datos, en este caso mysql
docker pull mysql:latest

## 2) Crear una red comun para las imagenes doker del proyecto
docker network create mi_red

## 4) Levantar la imagen docker con la base de datos
docker run --name mysql_microservice --network mi_red --env=MYSQL_ROOT_PASSWORD=root --env=MYSQL_USER=cbastian90 --env=MYSQL_PASSWORD=cbastian90 --env=MYSQL_DATABASE=microservice_db -p 3306:3306 -p 33060:33060 --runtime=runc -d mysql:latest

## 5) Crear las tablas que hay en el archivo 
BaseDatos.sql

## 6) Descargar imagen con el proyecto
docker pull cbastian90/microservice-persona-cliente

## 7) Levantar pryecto
docker run --name microservicio_persona --network mi_red --env DATABASE_URL="jdbc:mysql://mysql_microservice:3306/microservice_db" --env DATABASE_USERNAME="root" --env DATABASE_PASSWORD="root" -p 9000:9000 -d cbastian90/microservice-persona-cliente:0.0.5
