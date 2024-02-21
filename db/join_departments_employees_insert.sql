insert into departments(name) values('IT');      -- 1
insert into departments(name) values('Sales');   -- 2
insert into departments(name) values('HR');      -- 3
insert into departments(name) values('General'); -- 4

insert into employees(name, departments_id) values('Ivan', 1);
insert into employees(name, departments_id) values('Petr', 1);
insert into employees(name, departments_id) values('Fedor', 2);
insert into employees(name, departments_id) values('Stepan', 3);
insert into employees(name) values('Stas');