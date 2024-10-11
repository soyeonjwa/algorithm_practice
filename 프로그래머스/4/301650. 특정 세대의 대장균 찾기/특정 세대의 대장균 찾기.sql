with second as (
    select distinct e2.id as id
    from ECOLI_DATA as e1, ECOLI_DATA as e2
    where e1.parent_id is null and e2.parent_id = e1.id
)
select distinct e.id as ID
from second, ECOLI_DATA as e
where second.id = e.parent_id
order by ID;