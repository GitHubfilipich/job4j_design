select c.id, c.name car_name, b.name body_name, e.name engine_name, t.name transmission_name
from cars c
left join car_bodies b
on c.body_id = b.id
left join car_engines e
on c.engine_id = e.id
left join car_transmissions t
on c.transmission_id = t.id;    -- список всех машин и все привязанные к ним детали

select b.id, b.name body_name
from car_bodies b
left join cars c
on b.id = c.body_id
where c.name is null;           -- кузова, которые не используются НИ в одной машине

select e.id, e.name engine_name
from car_engines e
left join cars c
on e.id = c.engine_id
where c.name is null;           -- двигатели, которые не используются НИ в одной машине

select t.id, t.name transmission_name
from car_transmissions t
left join cars c
on t.id = c.transmission_id
where c.name is null;           -- коробки передач, которые не используются НИ в одной машине