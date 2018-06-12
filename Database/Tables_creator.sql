DROP SCHEMA IF EXISTS SELECTION;

CREATE SCHEMA SELECTION;

USE SELECTION;


DROP TABLE IF EXISTS ADVERTISMENT;
DROP TABLE IF EXISTS USERS;


CREATE TABLE ADVERTISMENT						-- Tabella contenente gli annunci di ricerca di giocatori
			(
            COD INT PRIMARY KEY,
            SPORT CHAR (20),					-- Calcetto, Tennis, Pallavolo, Basket
            LOCATION CHAR(50),					-- Città e indirizzo
            EVENT_DATE DATE,					-- AAAA-MM-DD
            EVENT_HOUR TIME,					-- hh:mm:ss
            ROLE_REQUEST CHAR (20),				-- Se non c'è ruolo (come nel tennis) NULL
            PERIODICITY CHAR (20),
            AGE_MIN INT,
            AGE_MAX INT,
            LEVEL_EVENT CHAR (20),			    -- BASSO, MEDIO, ALTO
            SEX CHAR(1))						-- M, F o null se indifferente
            
			ENGINE = INNODB;
            
CREATE TABLE USERS 							-- Tabella contente i giocatori disponibili
			(
            USERNAME VARCHAR(20) PRIMARY KEY,
            PASSWORD_P VARCHAR(20),
            NAME_PLAYER VARCHAR(20),
            SURNAME_PLAYER VARCHAR (20),
            SEX VARCHAR (1),						-- M o F
            AGE INT)							-- Età del giocatore
            				
            
            ENGINE = INNODB;
            
-- Inserimento di alcuni annunci
INSERT INTO ADVERTISMENT VALUES('00001', 'CALCETTO', 'PAVIA VIA FERRATA 5', '2018-06-15', '18:00:00', 'PORTIERE', 'GIORNALIERA', '30', '40', 'MEDIUM', 'M');
INSERT INTO ADVERTISMENT VALUES('00002', 'CALCETTO', 'BRONI VIA QUARTIERE PIAVE 14', '2018-05-20', '20:00:00', 'PLAYER', 'SETTIMANALE',  '50', '55', 'LOW', 'F');
INSERT INTO ADVERTISMENT VALUES('00003', 'TENNIS', 'STRADELLA PIAZZALE FIERA', '2018-06-10', '16:00:00', 'NONE', 'NONE', '40', '50', 'MEDIUM', 'F');
INSERT INTO ADVERTISMENT VALUES('00004', 'PALLAVOLO', 'MILANO VIA DEI MISSAGLIA 142', '2018-06-07','21:00:00', 'PALLEGGIATORE', 'MENSILE', '20', '30', 'HIGH', NULL);
INSERT INTO ADVERTISMENT VALUES('00005', 'BASKET', 'PAVIA VIA TREVES 17', '2018-06-15', '19:00:00', 'NONE', 'GIORNALIERA', '25', '30', 'LOW', 'M');


-- Inserimento di giocatori
INSERT INTO USERS VALUES('ADRI','123','ADRIANO', 'FARAVELLI', 'M', 21);
INSERT INTO USERS VALUES('MONI','234','MONICA', 'MAGGI', 'F', 50);
INSERT INTO USERS VALUES('FRANCI','FRA','FRANCESCA', 'MARINI', 'F', 21);
INSERT INTO USERS VALUES('SILVI','246','SILVIA', 'FULGOSI', 'F', 31);
