create table specialities
(
    id             serial primary key,
    name           text,
    importance     int
);
create table workers
(
    id               serial primary key,
    name             text,
    age              int,
    specialities_id  int references specialities(id)
);