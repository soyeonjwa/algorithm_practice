SELECT CONCAT('/home/grep/src/',B.BOARD_ID,'/', F.FILE_ID, F.FILE_NAME,F.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_BOARD AS B, USED_GOODS_FILE AS F
WHERE B.BOARD_ID = F.BOARD_ID 
    AND B.VIEWS >= ALL(
        SELECT VIEWS
        FROM USED_GOODS_BOARD
    )
ORDER BY F.FILE_ID DESC;

