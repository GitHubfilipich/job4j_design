-- названия всех фильмов, которые сняты по книге:
select name from movie as m
inner join book as b
on m.name = b.title

-- все названия книг, у которых нет экранизации:
select title from book as b
left join movie as m
on b.title = m.name
where m.name is null;

-- все уникальные названия произведений из таблиц movie и book (т.е фильмы, которые сняты не по книге, и книги без экранизации):
select name from movie as m
left join book as b
on m.name = b.title
where b.title is null
union all
select title from book as b
left join movie as m
on b.title = m.name
where m.name is null;