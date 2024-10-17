with recursive generation as (
    select id, 1 as generation
    from ecoli_data
    where parent_id is null
    union all
    select e.id, g.generation + 1 as generation
    from generation as g, ecoli_data as e
    where e.parent_id is not null and e.parent_id = g.id
),
no_child as (
    select distinct id
    from ecoli_data
    where id not in (
        select distinct parent_id
        from ecoli_data
        where parent_id is not null
    )
)
select count(*) as COUNT, g.generation as GENERATION
from generation as g join no_child as e
    on g.id = e.id
group by g.generation
order by generation
