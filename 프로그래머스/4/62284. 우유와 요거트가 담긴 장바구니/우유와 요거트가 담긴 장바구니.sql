with cart as (
    select distinct cart_id
    from cart_products
)
select distinct c.cart_id as CART_ID
from cart as c
where c.cart_id in (
        select distinct cart_id
        from cart_products
        where name = 'Yogurt'
    ) and c.cart_id in (
        select distinct cart_id
        from cart_products
        where name = 'Milk'
    )
order by cart_id
