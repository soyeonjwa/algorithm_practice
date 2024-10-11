-- 코드를 입력하세요
SELECT datetime as 시간
from animal_ins
where datetime <= all(
    select datetime
    from animal_ins
);