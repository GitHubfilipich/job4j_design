insert into students (name)
values ('Иван Иванов');
insert into students (name)
values ('Петр Петров');
insert into students (name)
values ('Степан Степанов');

insert into authors (name)
values ('Александр Пушкин');
insert into authors (name)
values ('Николай Гоголь');
insert into authors (name)
values ('Михаил Лермонтов');

insert into books (name, author_id)
values ('Евгений Онегин', 1);
insert into books (name, author_id)
values ('Капитанская дочка', 1);
insert into books (name, author_id)
values ('Дубровский', 1);
insert into books (name, author_id)
values ('Мертвые души', 2);
insert into books (name, author_id)
values ('Вий', 2);
insert into books (name, author_id)
values ('Бородино', 3);

insert into orders (book_id, student_id)
values (1, 1);
insert into orders (book_id, student_id)
values (3, 1);
insert into orders (book_id, student_id)
values (5, 2);
insert into orders (book_id, student_id)
values (4, 1);
insert into orders (book_id, student_id)
values (2, 2);
insert into orders (book_id, student_id)
values (6, 1);
insert into orders (book_id, student_id)
values (1, 3);
insert into orders (book_id, student_id)
values (4, 2);