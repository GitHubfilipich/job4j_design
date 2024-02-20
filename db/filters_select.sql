select p.name
from product p
join type t
on p.type_id = t.id
where t.name = 'СЫР'; -- всех продуктов с типом "СЫР"

select p.name
from product p
where p.name like '%мороженое%'; -- у кого в имени есть слово "мороженое"

select p.name
from product p
where p.expired_date < current_date; -- срок годности которых уже истек

select p.name, p.price
from product p
where p.price in
(select max(p.price)
from product p); -- самый дорогой продукт

select t.name as "Имя типа", count(p.name) as "Количество"
from type t
join product p
on t.id = p.type_id
group by t.name; -- для каждого типа количество продуктов к нему принадлежащих

select t.name as "Имя типа", p.name as "Имя продукта"
from type t
join product p
on t.id = p.type_id
where t.name = 'СЫР' or t.name = 'МОЛОКО'; -- продуктов с типом "СЫР" и "МОЛОКО"

select t.name as "Имя типа", count(p.name) as "Количество"
from type t
join product p
on t.id = p.type_id
group by t.name
having count(p.name) < 10; -- тип продуктов, которых осталось меньше 10 штук

select t.name as "Имя типа", p.name as "Имя продукта"
from type t
join product p
on t.id = p.type_id; -- все продукты и их тип