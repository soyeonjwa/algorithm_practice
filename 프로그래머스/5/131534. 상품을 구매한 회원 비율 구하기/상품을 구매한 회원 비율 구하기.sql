with users as (
    select distinct user_id
    from user_info
    where year(joined) = '2021'
), 
all_users as (
    select count(*) as cnt
    from users
)
select year(o.sales_date) as YEAR, month(o.sales_date) as MONTH, count(distinct u.user_id) as PURCHASED_USERS, round(count(distinct u.user_id)/a.cnt, 1) as PUCHASED_RATIO
from all_users as a, users as u join online_sale as o
    on u.user_id = o.user_id
group by year, month
order by year, month