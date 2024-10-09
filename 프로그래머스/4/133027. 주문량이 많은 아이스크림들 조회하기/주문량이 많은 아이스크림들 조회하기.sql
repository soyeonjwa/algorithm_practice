with j as (
    select sum(total_order) as total_order, flavor
    from july
    group by flavor
)
select j.flavor
from j join first_half as f on j.flavor = f.flavor
order by j.total_order+f.total_order desc
limit 3;
