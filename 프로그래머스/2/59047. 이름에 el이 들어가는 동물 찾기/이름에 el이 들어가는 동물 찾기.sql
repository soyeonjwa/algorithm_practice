SELECT ANIMAL_ID, NAME
FROM animal_ins
WHERE name like '%el%' AND animal_type = 'Dog'
ORDER BY name;
