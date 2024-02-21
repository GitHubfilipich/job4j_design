select d.name Department, e.name Employee
from departments d left join employees e
on d.id = e.departments_id;                 -- left join

select d.name Department, e.name Employee
from departments d right join employees e
on d.id = e.departments_id;                 -- right join

select d.name Department, e.name Employee
from departments d full join employees e
on d.id = e.departments_id;                 -- full join

select d.name Department, e.name Employee
from departments d cross join employees e;  -- cross join

select d.name Department
from departments d left join employees e
on d.id = e.departments_id
where e.name is null;                       -- департаменты, у которых нет работников

-- left и right join, которые давали бы одинаковый результат:
select d.name Department, e.name Employee
from departments d left join employees e
on d.id = e.departments_id;                 -- left join

select d.name Department, e.name Employee
from employees e right join departments d
on e.departments_id = d.id;                 -- right join
