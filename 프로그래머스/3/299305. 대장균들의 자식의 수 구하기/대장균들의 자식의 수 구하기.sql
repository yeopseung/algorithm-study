SELECT  ID,
         (SELECT COUNT(ID) FROM ECOLI_DATA WHERE PARENT_ID = ED.ID) AS CHILD_COUNT
FROM    ECOLI_DATA ED
ORDER BY ID ASC