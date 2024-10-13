with avg_score as (
    select emp_no, avg(score) as avg_score
    from hr_grade
    group by emp_no
),
grade as (
    select e.emp_no as EMP_NO, e.emp_name as EMP_NAME, 
        case
            when s.avg_score >=96 then 'S'
            when s.avg_score >=90 then 'A'
            when s.avg_score >= 80 then 'B'
            else 'C'
        end as GRADE,
        e.sal as SAL
    from hr_department as d, hr_employees as e, avg_score as s
    where d.dept_id = e.dept_id and e.emp_no = s.emp_no
)
select emp_no as EMP_NO, emp_name as EMP_NAME, grade as GRADE,
    case 
        when grade = 'S' then sal*0.2
        when grade = 'A' then sal*0.15
        when grade = 'B' then sal*0.1
        else 0
    end as BONUS
from grade
order by emp_no;
