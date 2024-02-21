select t1.name Male, t2.name Female
from teens t1 cross join teens t2
where t1.gender != t2.gender and t1.gender = 'male'; -- все возможные разнополые пары без дублирования
