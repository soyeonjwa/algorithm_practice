WITH A AS(
    SELECT *
    FROM APPOINTMENT
    WHERE apnt_cncl_yn = 'N'
)
SELECT A.apnt_no as APNT_NO, P.pt_name as PT_NAME, P.pt_no as PT_NO, A.mcdp_cd as MCDP_CD, D.dr_name as DR_NAME, A.apnt_ymd as APNT_YMD
FROM PATIENT AS P, DOCTOR AS D, A
WHERE P.pt_no = A.pt_no AND D.dr_id = A.mddr_id AND DATE(A.apnt_ymd) = '2022-04-13'
ORDER BY APNT_YMD;