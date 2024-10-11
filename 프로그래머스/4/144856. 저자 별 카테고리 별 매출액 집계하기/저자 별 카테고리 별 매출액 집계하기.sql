select b.author_id as AUTHOR_ID, a.author_name as AUTHOR_NAME, b.category as CATEGORY, sum(s.sales*b.price) as TOTAL_SALES
from book as b
    join author as a on b.author_id = a.author_id
    join book_sales as s on b.book_id = s.book_id
where year(s.sales_date) = '2022' and month(s.sales_date) = '01'
group by b.category, b.author_id
order by b.author_id, b.category DESC;