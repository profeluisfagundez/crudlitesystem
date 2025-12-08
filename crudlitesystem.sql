CREATE DATABASE crudlitesystem;
USE crudlitesystem;
CREATE TABLE usuario(
	ci VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL);
INSERT INTO usuario(ci,nombre,apellido) VALUES('11111111','Foo','Bar');
SELECT * FROM usuario;
SELECT ci FROM usuario;
