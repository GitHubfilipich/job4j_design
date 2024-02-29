BEGIN;
DECLARE cursor_products SCROLL cursor for
select * from products;
FETCH LAST FROM cursor_products;
MOVE ABSOLUTE 14 FROM cursor_products;
FETCH FROM cursor_products;
MOVE BACKWARD 9 FROM cursor_products;
FETCH FROM cursor_products;
FETCH ABSOLUTE 2 FROM cursor_products;
FETCH PRIOR FROM cursor_products;
CLOSE cursor_products;
COMMIT;