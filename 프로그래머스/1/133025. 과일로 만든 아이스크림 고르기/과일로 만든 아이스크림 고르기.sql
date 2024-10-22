with shipment as (
    select flavor, sum(total_order) as sum
    from first_half
    group by flavor
)
select s.flavor as FLAVOR
from shipment as s join icecream_info as i
    on s.flavor = i.flavor
where s.sum > 3000 and i.ingredient_type like "%fruit%"
order by s.sum desc
    