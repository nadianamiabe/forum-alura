create table app_user(
    id bigint not null auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
    primary key (id)
);

insert into app_user(id, name, email) values(1, 'Ana da Silva', 'ana@email.com');