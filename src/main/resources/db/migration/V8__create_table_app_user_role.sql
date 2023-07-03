create table app_user_roles(
    id bigint not null auto_increment,
    app_user_id bigint not null,
    roles_name varchar(50) not null,
    primary key (id),
    foreign key (app_user_id) references app_user(id),
    foreign key (roles_name) references role(name)
);

insert into app_user_roles(id, app_user_id, roles_name) values (1, 1, 'READ_WRITE');