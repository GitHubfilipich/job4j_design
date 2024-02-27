begin transaction isolation level serializable;
select count(*) from animals;
update animals set age = 4 where name = 'Murka';
commit;