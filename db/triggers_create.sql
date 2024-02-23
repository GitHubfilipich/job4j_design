create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);
create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

-- после вставки данных прибавить налог к цене товара (statement уровень)
create
or replace function add_tax_statement()
    returns trigger as
$$
    BEGIN
        update products
        set price = price * 1.2
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger add_tax_statement_trigger
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure add_tax_statement();

-- до вставки данных прибавить налог к цене товара (row уровень)
create
or replace function add_tax_row()
    returns trigger as
$$
    BEGIN
        new.price = new.price * 1.2;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger add_tax_row_trigger
    before insert
    on products
    for each row
    execute procedure add_tax_row();

-- на row уровне после вставки в таблицу products заносить имя, цену и текущую дату в таблицу history_of_price
create
or replace function insert_history_of_price()
    returns trigger as
$$
    BEGIN
        INSERT INTO history_of_price(name, price, date) values(new.name, new.price, now());
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger insert_history_of_price_trigger
    after insert
    on products
    for each row
    execute procedure insert_history_of_price();




