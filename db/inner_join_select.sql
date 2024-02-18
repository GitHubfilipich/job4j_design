select w.name Работник, w.age Возраст, s.name Специальность, s.importance as "Важность специальности"
from workers w join specialities s on w.specialities_id = s.id order by s.importance desc;

select w.name Работник, w.age Возраст, s.name Специальность, s.importance as "Важность специальности"
from workers w join specialities s on w.specialities_id = s.id where w.age <= 30;

select w.name Работник, w.age Возраст, s.name Специальность, s.importance as "Важность специальности"
from workers w join specialities s on w.specialities_id = s.id where s.importance >= 2 order by s.importance desc;
