with max_member as(
    select member_id, count(*) as cnt
    from rest_review
    group by member_id
)
select p.member_name as MEMBER_NAME, r.review_text as REVIEW_TEXT, date_format(r.review_date, "%Y-%m-%d") as REVIEW_DATE
from member_profile as p, max_member as m, rest_review as r
where p.member_id = m.member_id and m.cnt >= all(
        select distinct cnt
        from max_member
    ) and r.member_id = p.member_id
order by review_date, review_text
