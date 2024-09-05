SELECT distinct o1.user_id, o1.product_id
FROM ONLINE_SALE as o1, ONLINE_SALE as o2
WHERE o1.user_id = o2.user_id 
    AND o1.product_id = o2.product_id
    AND o1.online_sale_id != o2.online_sale_id
ORDER BY o1.user_id, o1.product_id desc;