create table role(
    name varchar(50) not null,
    primary key (name)
);

insert into role(name) values ('READ_WRITE');