create table departments
(
    id             serial primary key,
    name           text
);
create table employees
(
    id               serial primary key,
    name             text,
    departments_id  int references departments(id)
);