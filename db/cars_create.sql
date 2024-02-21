create table car_bodies
(
    id             serial primary key,
    name           text
);
create table car_engines
(
    id             serial primary key,
    name           text
);
create table car_transmissions
(
    id             serial primary key,
    name           text
);
create table cars
(
    id              serial primary key,
    name            text,
    body_id         int references car_bodies(id),
    engine_id       int references car_engines(id),
    transmission_id int references car_transmissions(id)
);
