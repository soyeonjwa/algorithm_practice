select car_type as CAR_TYPE, count(car_id) as CARS
from car_rental_company_car
where options regexp "통풍시트|열선시트|가죽시트"
group by car_type
order by car_type;