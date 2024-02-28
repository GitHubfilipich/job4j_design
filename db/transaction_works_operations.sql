begin transaction;
select count(*) from plants;
insert into plants(name, height) values('tomato', 1.5);
select count(*) from plants;
savepoint first_savepoint;
insert into plants(name, height) values('cucumber', 0.5);
select count(*) from plants;
savepoint second_savepoint;
insert into plants(name, height) values('agave', 0.5);
select count(*) from plants;
insert into plants(name, not_correct_name) values('hogweed', 1.5);
rollback to second_savepoint;
select count(*) from plants;
rollback to first_savepoint;
select count(*) from plants;
commit;
select count(*) from plants;