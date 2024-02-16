create table persons(
	id serial primary key,
	name varchar(255),
	age integer,
	height numeric(3, 2),
	married boolean
);
insert into persons(name, age, height, married) values('Ivan', 25, 1.85, false);
update persons set name = 'Petr', age = 30, height = 1.80, married = true;
delete from persons;