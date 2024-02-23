-- 코드를 입력하세요
-- CAR_RENTAL_COMPANY_CAR 테이블과 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블과 CAR_RENTAL_COMPANY_DISCOUNT_PLAN 테이블에서 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력하는 SQL문을 작성해주세요. 결과는 대여 금액을 기준으로 내림차순 정렬하고, 대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬, 자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬해주세요.
SELECT  ca.CAR_ID,ca.CAR_TYPE,	ROUND(ca.DAILY_FEE * 30 * (100-cc.DISCOUNT_RATE) /100 ) as FEE
FROM CAR_RENTAL_COMPANY_CAR as ca
INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY as cb
ON ca.CAR_ID = cb.CAR_ID
INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN as cc
ON ca.CAR_TYPE = cc.CAR_TYPE
WHERE ca.CAR_ID NOT IN (SELECT CAR_ID
                        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                        WHERE START_DATE <'2022-12-01' AND END_DATE > '2022-10-31') 
                        -- WHERE END_DATE > '2022-11-01' AND START_DATE < '2022-12-01'
                        AND (ca.CAR_TYPE = '세단' OR ca.CAR_TYPE = 'SUV') AND cc.DURATION_TYPE = '30일 이상' 
GROUP BY ca.CAR_ID 
HAVING  (FEE>=500000 AND FEE<2000000) 
ORDER BY FEE DESC , CAR_TYPE , CAR_ID DESC