create database if not exists MytestDB;

use MytestDB;

create table Users
(
    Id         integer PRIMARY KEY auto_increment,
    First_name varchar(25),
    Last_name  varchar(25),
    Email      varchar(25) UNIQUE,
    Password   varchar(50),
    Admin      boolean default false
);


CREATE TABLE Produkter (
                           Produkt_ID integer UNIQUE auto_increment,
                           Produkt_navn VARCHAR(50),
                           Kategori VARCHAR(50),
                           Beskrivelse VARCHAR(500),
                           Bilde blob,
                           Brukes BOOLEAN,
                           Kurs_ID INTEGER,
                           Pris INTEGER);

create table Files(
    Id              integer UNIQUE auto_increment,
    Name            varchar(255) not null,
    Content         LONGBLOB not null,
    ContentType varchar(255) not null,
    CONSTRAINT PRIMARY KEY (Id)
);


                           