ALTER TABLE CONFIGURATION ALTER COLUMN VALUE TEXT NULL

INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'server.maxqueuesize', '0')

DROP TABLE EVENT

CREATE TABLE EVENT
	(ID INTEGER IDENTITY (1, 1) NOT NULL PRIMARY KEY,
	DATE_CREATED DATETIME DEFAULT GETDATE(),
	NAME TEXT NOT NULL,
	LEVEL VARCHAR(40) NOT NULL,
	OUTCOME VARCHAR(40) NOT NULL,
	ATTRIBUTES TEXT
	USER_ID INTEGER NOT NULL,
	IP_ADDRESS VARCHAR(40))