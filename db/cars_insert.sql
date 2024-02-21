insert into car_bodies(name) values('седан');   -- 1
insert into car_bodies(name) values('хэтчбек'); -- 2
insert into car_bodies(name) values('пикап');   -- 3
insert into car_bodies(name) values('джип');    -- 4
insert into car_bodies(name) values('фургон');    -- 5

insert into car_engines(name) values('бензиновый'); -- 1
insert into car_engines(name) values('дизельный');  -- 2
insert into car_engines(name) values('газовый');    -- 3
insert into car_engines(name) values('реактивный'); -- 4
insert into car_engines(name) values('педальный');  -- 5

insert into car_transmissions(name) values('ручная');   -- 1
insert into car_transmissions(name) values('автомат');  -- 2
insert into car_transmissions(name) values('робот');    -- 3
insert into car_transmissions(name) values('вариатор'); -- 4
insert into car_transmissions(name) values('ИИ');       -- 5

insert into cars(name, body_id, engine_id, transmission_id) values('Toyota', 1, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values('Honda', 1, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) values('Buick', 2, 2, 3);
insert into cars(name, body_id, engine_id, transmission_id) values('Aurus', 4, 4, 2);
insert into cars(name, body_id, transmission_id) values('Moskvich', 1, 1);
insert into cars(name, body_id) values('Hand maid', 1);