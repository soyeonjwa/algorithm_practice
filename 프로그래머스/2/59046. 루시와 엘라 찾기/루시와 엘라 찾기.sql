select animal_id as ANIMAL_ID, name as NAME, sex_upon_intake as SEX_UPON_INTAKE
from animal_ins
where name regexp "^(Lucy|Ella|Pickle|Rogan|Sabrina|Mitty)$"
order by animal_id