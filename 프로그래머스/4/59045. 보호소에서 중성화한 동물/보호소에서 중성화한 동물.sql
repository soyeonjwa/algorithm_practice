select distinct i.animal_id as ANIMAL_ID, i.animal_type AS ANIMAL_TYPE, i.name as NAME
from animal_ins as i, animal_outs as o
where i.animal_id = o.animal_id and
    i.sex_upon_intake regexp "^Intact" and
    (o.sex_upon_outcome) regexp "^(Spayed|Neutered)"
order by i.animal_id;
    