CREATE DEFINER=`root`@`localhost` FUNCTION `add-user`(USER VARCHAR(20), PASSWORD_P VARCHAR(20), NAME_PLAYER VARCHAR(20), SURNAME_PLAYER VARCHAR(20), SEX VARCHAR(1), AGE INT) RETURNS tinyint(1)
BEGIN
DECLARE RES BOOLEAN;
IF(EXISTS (SELECT * FROM USERS WHERE USERNAME = USER)) THEN 

	SET RES = FALSE;
ELSE
	SET RES = TRUE;
	INSERT INTO USERS (USERNAME, PASSWORD_P, NAME_PLAYER, SURNAME_PLAYER, SEX, AGE) VALUES (USER, PASSWORD_P, NAME_PLAYER, SURNAME_PLAYER, SEX, AGE);
END IF;
RETURN (RES);
END