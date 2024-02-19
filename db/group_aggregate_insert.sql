insert into devices(name, price) values('phone', 15000);    -- 1
insert into devices(name, price) values('pen', 100);        -- 2
insert into devices(name, price) values('pencil', 200);     -- 3
insert into devices(name, price) values('TV', 50000);       -- 4
insert into devices(name, price) values('car', 500000);     -- 5

insert into people(name) values('Ivan');    -- 1
insert into people(name) values('Petr');    -- 2
insert into people(name) values('Fedor');    -- 3

insert into devices_people(device_id, people_id) values(1, 1);
insert into devices_people(device_id, people_id) values(4, 1);
insert into devices_people(device_id, people_id) values(5, 1);
insert into devices_people(device_id, people_id) values(1, 2);
insert into devices_people(device_id, people_id) values(2, 2);
insert into devices_people(device_id, people_id) values(2, 3);
insert into devices_people(device_id, people_id) values(3, 3);