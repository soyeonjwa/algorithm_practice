with max_product as (
    select category, max(price) as max_price
    from food_product
    where category in ('과자', '국', '김치', '식용유')
    group by category
)
select f.category as CATEGORY, M.max_price as MAX_PRICE, f.product_name as PRODUCT_NAME
from food_product as f, max_product as m
where f.category = m.category and f.price = m.max_price
order by m.max_price desc;
    
