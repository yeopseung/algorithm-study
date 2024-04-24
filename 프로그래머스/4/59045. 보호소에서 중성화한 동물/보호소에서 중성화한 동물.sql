WITH INTACT AS(
    SELECT ANIMAL_ID
    FROM ANIMAL_INS
    WHERE SEX_UPON_INTAKE LIKE ('Intact%')
)

SELECT 
    AO.ANIMAL_ID, AO.ANIMAL_TYPE, AO.NAME
FROM 
    ANIMAL_OUTS AO JOIN INTACT I ON AO.ANIMAL_ID = I.ANIMAL_ID
WHERE 
    AO.SEX_UPON_OUTCOME LIKE ('Spayed%') OR AO.SEX_UPON_OUTCOME LIKE ('Neutered%')
ORDER BY 
    AO.ANIMAL_ID;
    