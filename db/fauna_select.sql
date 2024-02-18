select * from public.fauna where name like '%fish%'; -- имя name содержит подстроку fish
select * from public.fauna where avg_age >= 10000 and avg_age <= 21000; -- сред. продолжительность жизни находится в диапазоне 10 000 и 21 000
select * from public.fauna where discovery_date is null; -- дата открытия не известна (null)
select * from public.fauna where discovery_date < '1950-01-01'; -- дата открытия раньше 1950 года