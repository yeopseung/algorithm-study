-- 코드를 입력하세요
SELECT AO.ANIMAL_ID, AO.NAME
FROM ANIMAL_INS AO JOIN ANIMAL_OUTS AI ON AI.ANIMAL_ID = AO.ANIMAL_ID
ORDER BY DATEDIFF(AI.DATETIME, AO.DATETIME) DESC
LIMIT 2;