create table boats(
    id serial primary key,
    model varchar(255),
	year int
);
create table documents(
    id serial primary key,
    seria varchar(255),
	number int
);
create table boats_documents(
    id serial primary key,
    boat_id int references boats(id) unique,
	document_id int references documents(id) unique
);