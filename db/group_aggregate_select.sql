select avg(d.price) from devices d; -- среднюю цену устройств

select p.name, avg(d.price)
from devices d
join devices_people dp
join people p
on dp.people_id = p.id
on d.id = dp.device_id
group by p.name; -- для каждого человека среднюю цену его устройств

select p.name, avg(d.price)
from devices d
join devices_people dp
join people p
on dp.people_id = p.id
on d.id = dp.device_id
group by p.name
having avg(d.price) > 5000; -- для каждого человека среднюю цену его устройств, средняя стоимость больше 5000