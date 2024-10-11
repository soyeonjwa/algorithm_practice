with max_favorites as (
    select food_type, max(favorites) as max_favorites
    from rest_info
    group by food_type
)
select r.food_type as FOOD_TYPE, r.rest_id as REST_ID, r.rest_name as REST_NAME, r.favorites as FAVORITES 
from rest_info as r, max_favorites as m
where r.food_type = m.food_type and r.favorites = m.max_favorites
order by r.food_type desc;
