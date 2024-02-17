create table persons(
    id serial primary key,
    name varchar(255),
	surname varchar(255)
);
create table groups(
    id serial primary key,
    name varchar(255),
);
create table persons_groups(
    id serial primary key,
    person_id int references persons(id),
	group_id int references groups(id)
);