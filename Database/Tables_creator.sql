DROP SCHEMA IF EXISTS SELECTION;

CREATE SCHEMA SELECTION;

USE SELECTION;


DROP TABLE IF EXISTS ADVERTISMENT;
DROP TABLE IF EXISTS PLAYERS;


CREATE TABLE ADVERTISMENT						-- Tabella contenente gli annunci di ricerca di giocatori
			(
            COD INT PRIMARY KEY,
            SPORT CHAR (20),					-- Calcetto, Tennis, Pallavolo, Basket
            LOCATION CHAR(50),					-- Città e indirizzo
            EVENT_DATE DATE,					-- AAAA-MM-DD
            EVENT_HOUR TIME,					-- hh:mm:ss
            ROLE_REQUEST CHAR (20),				-- Se non c'è ruolo (come nel tennis) NULL
            AGE_MIN INT,
            AGE_MAX INT,
            LEVEL_EVENT CHAR (20),			    -- BASSO, MEDIO, ALTO
            SEX CHAR(1))						-- M, F o null se indifferente
            
			ENGINE = INNODB;
            
CREATE TABLE PLAYERS 							-- Tabella contente i giocatori disponibili
			(
            NAME_PLAYER CHAR(20),
            SURNAME_PLAYER CHAR (20),
            SEX CHAR (1),						-- M o F
            AGE INT,							-- Età del giocatore
            CITY CHAR(50),						-- Residenza
            SPORT CHAR(20),						-- Calcetto, Tennis, Pallavolo, Basket		
            ROLE CHAR (20),						-- Se non c'è ruolo (come nel tennis) NULL
            LEVEL_PLAYER CHAR(20),				-- BASSO, MEDIO, ALTO
            PRIMARY KEY(NAME_PLAYER, SURNAME_PLAYER))				
            
            ENGINE = INNODB;
            
-- Inserimento di alcuni annunci
INSERT INTO ADVERTISMENT VALUES('00001', 'CALCETTO', 'PAVIA VIA FERRATA 5', '2018-06-15', '18:00:00', 'PORTIERE', '30', '40', 'MEDIO', 'M');
INSERT INTO ADVERTISMENT VALUES('00002', 'CALCETTO', 'BRONI VIA QUARTIERE PIAVE 14', '2018-05-20', '20:00:00', 'PLAYER', '50', '55', 'BASSO', 'F');
INSERT INTO ADVERTISMENT VALUES('00003', 'TENNIS', 'STRADELLA PIAZZALE FIERA', '2018-06-10', '16:00:00', NULL, '40', '50', 'MEDIO', 'F');
INSERT INTO ADVERTISMENT VALUES('00004', 'PALLAVOLO', 'MILANO VIA DEI MISSAGLIA 142', '2018-06-07','21:00:00', 'PALLEGGIATORE', '20', '30', 'ALTO', NULL);
INSERT INTO ADVERTISMENT VALUES('00005', 'BASKET', 'PAVIA VIA TREVES 17', '2018-06-15', '19:00:00', NULL, '25', '30', 'BASSO', 'M');


-- Inserimento di giocatori
INSERT INTO PLAYERS VALUES('ADRIANO', 'FARAVELLI', 'M', '21', 'MONTECALVO VERSIGGIA (PV)', 'BASKET', NULL, 'MEDIO');
INSERT INTO PLAYERS VALUES('MONICA', 'MAGGI', 'F', '50', 'STRADELLA (PV)', 'TENNIS', NULL, 'MEDIO');
INSERT INTO PLAYERS VALUES('FRANCESCA', 'MARINI', 'F', '21', 'GODIASCO (PV)', 'PALLAVOLO', 'PALLEGGIATORE', 'BASSO');
INSERT INTO PLAYERS VALUES('SILVIA', 'FULGOSI', 'F', '31', 'STRADELLA (PV)', 'PALLAVOLO', NULL, 'BASSO');
