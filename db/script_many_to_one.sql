create table persons(
    id serial primary key,
    name varchar(255),
	surname varchar(255)
);
create table cars(
    id serial primary key,
    model varchar(255),
	year int,
	ouner_id int references persons(id)
);