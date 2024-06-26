WITH 
GENERATION_ONE AS(
    SELECT ID
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
),
GENERATION_TWO AS(
    SELECT ID
    FROM ECOLI_DATA
    WHERE PARENT_ID IN (SELECT * FROM GENERATION_ONE)
)

SELECT ID
FROM ECOLI_DATA
WHERE PARENT_ID IN (SELECT * FROM GENERATION_TWO)
ORDER BY ID;