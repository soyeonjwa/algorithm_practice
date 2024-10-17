select d.dept_id as DEPT_ID, d.dept_name_en as DEPT_NAME_EN, round(avg(e.sal)) as AVG_SAL
from hr_department as d join hr_employees as e on d.dept_id = e.dept_id
group by d.dept_id
order by avg_sal desc

