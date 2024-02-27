begin transaction isolation level serializable;
select count(*) from animals;
update animals set age = 6 where name = 'Polkan';
commit;
