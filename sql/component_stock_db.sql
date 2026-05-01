create database if not exists component_stock_db
    default character set utf8mb4
    default collate utf8mb4_unicode_ci;

use component_stock_db;

drop table if exists out_record;
drop table if exists in_record;
drop table if exists component;
drop table if exists storage_location;
drop table if exists category;
drop table if exists admin;

create table admin (
    id int primary key auto_increment,
    username varchar(50) not null unique,
    password varchar(100) not null
);

create table category (
    id int primary key auto_increment,
    name varchar(100) not null unique,
    remark varchar(255)
);

create table storage_location (
    id int primary key auto_increment,
    code varchar(50) not null unique,
    name varchar(100) not null,
    remark varchar(255)
);

create table component (
    id int primary key auto_increment,
    name varchar(100) not null,
    model varchar(100),
    category_id int,
    location_id int,
    stock int not null default 0,
    warning_quantity int not null default 0,
    remark varchar(255),
    constraint fk_component_category foreign key (category_id) references category(id),
    constraint fk_component_location foreign key (location_id) references storage_location(id)
);

create table in_record (
    id int primary key auto_increment,
    component_id int not null,
    quantity int not null,
    operator varchar(50),
    in_time datetime not null,
    remark varchar(255),
    constraint fk_in_record_component foreign key (component_id) references component(id)
);

create table out_record (
    id int primary key auto_increment,
    component_id int not null,
    quantity int not null,
    operator varchar(50),
    out_time datetime not null,
    remark varchar(255),
    constraint fk_out_record_component foreign key (component_id) references component(id)
);

insert into admin(username, password) values ('admin', '123456');
insert into category(name, remark) values ('Resistor', 'Default category');
insert into storage_location(code, name, remark) values ('A-01-01-01', 'Default location', 'Default location');
