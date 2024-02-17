insert into roles(name) values('user');
insert into roles(name) values('admin');
insert into roles(name) values('guest');

insert into users(name, roles_id) values('Ivan', 1);
insert into users(name, roles_id) values('Petr', 2);
insert into users(name, roles_id) values('Fedor', 3);

insert into rules(name) values('read');
insert into rules(name) values('write');
insert into rules(name) values('delete');

insert into roles_rules(roles_id, rules_id) values(1, 1);
insert into roles_rules(roles_id, rules_id) values(1, 2);
insert into roles_rules(roles_id, rules_id) values(2, 1);
insert into roles_rules(roles_id, rules_id) values(2, 2);
insert into roles_rules(roles_id, rules_id) values(2, 3);
insert into roles_rules(roles_id, rules_id) values(3, 1);

insert into categories(name) values('ordinary');
insert into categories(name) values('urgent');
insert into categories(name) values('critical');

insert into states(name) values('prepared');
insert into states(name) values('processed');
insert into states(name) values('closed');

insert into items(number, users_id, categories_id, states_id) values('A101', 1, 1, 1);
insert into items(number, users_id, categories_id, states_id) values('A102', 2, 1, 1);
insert into items(number, users_id, categories_id, states_id) values('A103', 2, 2, 2);
insert into items(number, users_id, categories_id, states_id) values('A104', 2, 3, 3);

insert into comments(text, items_id) values('Hi, start working', 1);
insert into comments(text, items_id) values('Hi, stop', 1);
insert into comments(text, items_id) values('Hi, start item again', 2);
insert into comments(text, items_id) values('Good job!', 4);


insert into attachs(file_name, items_id) values('d:\items\doc1.docx', 1);
insert into attachs(file_name, items_id) values('d:\items\doc2.docx', 1);
insert into attachs(file_name, items_id) values('d:\items\doc3.docx', 3);