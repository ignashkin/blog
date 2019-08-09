create sequence hibernate_sequence start 1 increment 1;
create table post (
id int8 not null,
filename varchar(255),
tag varchar(255),
text text,
title varchar(255),
user_id int8,
primary key (id)
);

create table usr (
    id int8 not null,
    activation_code varchar(255),
    active boolean not null,
    email varchar(255),
    password varchar(255) not null UNIQUE,
    username varchar(255) not null UNIQUE,
    primary key (id)
);

create table user_role (
user_id int8 not null,
roles varchar(255)
);

alter table if exists post
add constraint post_user_fk
foreign key (user_id) references usr;

alter table if exists user_role
add constraint user_role_user_fk
foreign key (user_id) references usr;