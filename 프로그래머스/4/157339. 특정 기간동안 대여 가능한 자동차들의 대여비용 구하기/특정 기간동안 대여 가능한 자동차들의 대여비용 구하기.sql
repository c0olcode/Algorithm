SELECT
  c.CAR_ID,
  c.CAR_TYPE,
  ROUND(c.DAILY_FEE * 30 * (1 - p.discount_rate/100), 0) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS c
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS p
  ON p.CAR_TYPE = c.CAR_TYPE
 AND p.DURATION_TYPE = '30일 이상'          -- 30일 요금 할인만 적용
WHERE c.CAR_TYPE IN ('세단', 'SUV')          -- 대상 차종
  AND NOT EXISTS (                           -- 기간과 겹치는 대여내역이 아예 없어야 함
      SELECT 1
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
      WHERE h.CAR_ID = c.CAR_ID
        AND h.START_DATE <= '2022-11-30'
        AND h.END_DATE   >= '2022-11-01'
  )
HAVING FEE BETWEEN 500000 AND 2000000        -- 요금 필터(별칭 사용 OK)
ORDER BY FEE DESC, c.CAR_TYPE, c.CAR_ID DESC;
