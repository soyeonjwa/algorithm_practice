with union_table as (select date_format(sales_date, "%Y-%m-%d") as SALES_DATE, PRODUCT_ID, NULL as USER_ID, SALES_AMOUNT
from offline_sale
where year(sales_date) = 2022 and month(sales_date) = 03
union
select date_format(sales_date, "%Y-%m-%d") as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from online_sale
where year(sales_date) = 2022 and month(sales_date) = 03)
select *
from union_table
order by sales_date, product_id, user_id;