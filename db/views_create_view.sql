create view show_students_and_authors_which_books_they_have_not_read_yet
as
select all_a_s.student, all_a_s.author
from
(select a.name author, s.name student
from authors a
cross join students s) as all_a_s
left join
(select a.name author, s.name student
from authors as a
join books as b on a.id = b.author_id
join orders as o on b.id = o.book_id
join students as s on s.id = o.student_id
group by author, student) as a_s
on all_a_s.author = a_s.author and all_a_s.student = a_s.student
where a_s.student is null
order by student, author;