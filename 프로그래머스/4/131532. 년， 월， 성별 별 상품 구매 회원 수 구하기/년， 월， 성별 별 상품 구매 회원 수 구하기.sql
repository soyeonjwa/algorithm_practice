with sales as (
    select year(s.sales_date) as sales_year, month(s.sales_date) as sales_month, u.gender as gender, u.user_id as user_id
    from user_info as u, online_sale as s
    where u.user_id = s.user_id and u.gender is not null
)
select sales_year as YEAR, sales_month as MONTH, gender as GENDER, count(distinct user_id) as USERS
from sales
group by sales_year, sales_month, gender
order by sales_year, sales_month, gender
