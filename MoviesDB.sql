create database if not exists movies;

use movies;

drop table if exists genres;
drop table if exists actors;
drop table if exists directors;
drop table if exists movies;


create table directors(
id int(10) not null auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
primary key(id)
);

create table actors(
id int(10) not null auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
primary key(id)
);

create table genres(
id int(10) not null auto_increment,
genre varchar(50) not null,
primary key(id)
);

create table movies(
id int(10) not null auto_increment,
title varchar(50) not null,
year_released int(4) not null,
studio varchar(50) not null,
genre_id int(10) not null,
actors_id int(10) not null,
director_id int(10) not null,
primary key (id),
foreign key (genre_id) references genres(id),
foreign key (actors_id) references actors(id),
foreign key (director_id) references directors(id)
);