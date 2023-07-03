create table app_user_role(
    id bigint not null auto_increment,
    user_id bigint not null,
    role_id bigint not null,
    primary key (id),
    foreign key (user_id) references app_user(id),
    foreign key (role_id) references role(id)
);