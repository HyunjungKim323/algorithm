-- 코드를 입력하세요
SELECT p.PRODUCT_CODE , p.PRICE * SUM(os.SALES_AMOUNT) as SALES
FROM PRODUCT as p 
INNER JOIN OFFLINE_SALE as os
ON p.PRODUCT_ID = os.PRODUCT_ID
GROUP BY os.PRODUCT_ID
ORDER BY SALES DESC , p.PRODUCT_CODE