with more_than70 as(
    select writer_id, sum(price) as total_price
    from USED_GOODS_BOARD
    where status = 'DONE'
    group by writer_id
    having total_price>=700000
)
select u.user_id as USER_ID, u.nickname as NICKNAME, m.total_price as TOTAL_SALES
from more_than70 as m, USED_GOODS_USER as u
where m.writer_id = u.user_id
order by m.total_price;