create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

-- процедура, которая будет удалять записи по id или если количество товара < минимально заданного
create
or replace procedure
delete_data_on_id_or_less_when_min_count_procedure(p_id integer, min_count integer default 0)
language 'plpgsql'
as $$
    BEGIN
        if p_id > 0 THEN
            delete from products
            where id = p_id;
        end if;
        if min_count > 0 THEN
            delete from products
            where count < min_count;
        end if;
    END;
$$;

-- функция, которая возвращает количество удаленных записей по id или если количество товара < минимально заданного
create or replace function
rows_of_deleted_data_on_id_or_less_when_min_count_procedure(p_id integer, min_count integer default 0)
returns integer
language 'plpgsql'
as
$$
    declare
        result integer;
        result_count integer;
    begin
        result = 0;
        if p_id > 0 THEN
            select into result count(*) from products
            where id = p_id;
            delete from products
            where id = p_id;
        end if;
        if min_count > 0 THEN
            select into result_count count(*) from products
            where count < min_count;
            delete from products
            where count < min_count;
            result = result + result_count;
        end if;
        return result;
    end;
$$;

