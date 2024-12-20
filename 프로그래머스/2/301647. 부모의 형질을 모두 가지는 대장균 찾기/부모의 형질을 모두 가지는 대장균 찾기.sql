SELECT b.ID, b.GENOTYPE, a.GENOTYPE AS "PARENT_GENOTYPE"
FROM ECOLI_DATA a
JOIN ECOLI_DATA b
ON a.ID = b.PARENT_ID
WHERE (a.GENOTYPE & a.GENOTYPE) = (a.GENOTYPE & b.GENOTYPE)
ORDER BY b.ID