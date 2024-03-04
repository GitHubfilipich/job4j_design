-- список клиентов, возраст которых является минимальным:
select first_name, last_name, age from customers as c
where c.age = (select min(age) from customers);

-- список пользователей, которые еще не выполнили ни одного заказа:
select first_name, last_name, age from customers as c
where c.id not in (select customer_id from orders);