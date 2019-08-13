insert into usr (id, username, password, active, email)
values (1,'admin', 'admin', true, 'admin@admin.com');

insert into user_role (user_id, roles)
values (1, 'USER'), (1,'ADMIN');