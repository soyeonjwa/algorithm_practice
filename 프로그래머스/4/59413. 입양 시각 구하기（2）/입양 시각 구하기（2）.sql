with recursive time as(
    select 0 as HOUR
    union all
    select HOUR+1
    from time
    where HOUR < 23
)
select t.HOUR as HOUR, count(a.animal_id) as COUNT
from time as t left join animal_outs as a on t.HOUR = hour(a.datetime)
group by t.HOUR
order by HOUR;