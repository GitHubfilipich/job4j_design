insert into type(name) values('СЫР');    -- 1
insert into type(name) values('МОЛОКО'); -- 2
insert into type(name) values('МЯСО');   -- 3

insert into product(name, type_id, expired_date, price) values('Сыр Моцарелла', 1, '2025-01-01', 1500);
insert into product(name, type_id, expired_date, price) values('Сыр Гауда', 1, '2024-01-01', 2000);
insert into product(name, type_id, expired_date, price) values('Сыр Костромской', 1, '2023-01-01', 500);

insert into product(name, type_id, expired_date, price) values('Молоко замороженое', 2, '2025-01-01', 50);
insert into product(name, type_id, expired_date, price) values('Молоко 1%', 2, '2025-01-01', 100);
insert into product(name, type_id, expired_date, price) values('Молоко 1,5%', 2, '2025-01-01', 100);
insert into product(name, type_id, expired_date, price) values('Молоко 2%', 2, '2025-01-01', 100);
insert into product(name, type_id, expired_date, price) values('Молоко 2,5%', 2, '2025-01-01', 100);
insert into product(name, type_id, expired_date, price) values('Молоко 3%', 2, '2025-01-01', 100);
insert into product(name, type_id, expired_date, price) values('Молоко 3,5%', 2, '2024-01-01', 100);
insert into product(name, type_id, expired_date, price) values('Молоко 4%', 2, '2025-01-01', 100);
insert into product(name, type_id, expired_date, price) values('Молоко 4,5%', 2, '2025-01-01', 100);
insert into product(name, type_id, expired_date, price) values('Молоко 6%', 2, '2020-01-01', 100);

insert into product(name, type_id, expired_date, price) values('Мясо охлажденное', 3, '2025-01-01', 200);
insert into product(name, type_id, expired_date, price) values('Мясо замороженое', 3, '2020-01-01', 300);
insert into product(name, type_id, expired_date, price) values('Мясо свиное', 3, '2025-01-01', 500);
insert into product(name, type_id, expired_date, price) values('Мясо говяжье', 3, '2027-01-01', 2000);
