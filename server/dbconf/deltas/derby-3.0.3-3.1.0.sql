CREATE TABLE PERSON_PREFERENCE
	(PERSON_ID INTEGER NOT NULL,
	NAME VARCHAR(255) NOT NULL,
	VALUE CLOB,
	CONSTRAINT PERSON_ID_PERSON_PREF_FK FOREIGN KEY(PERSON_ID) REFERENCES PERSON(ID) ON DELETE CASCADE)
	
CREATE INDEX PERSON_PREFERENCE_INDEX1 ON PERSON_PREFERENCE(PERSON_ID)
	
ALTER TABLE PERSON ADD COLUMN INDUSTRY VARCHAR(255) DEFAULT NULL

INSERT INTO PERSON_PREFERENCE (PERSON_ID, NAME, VALUE) VALUES ((SELECT ID FROM PERSON), 'firstlogin', 'false')

DELETE FROM CONFIGURATION WHERE CATEGORY = 'core' AND NAME = 'firstlogin'

DELETE FROM CONFIGURATION WHERE CATEGORY = 'core' AND NAME = 'update.enabled'

DELETE FROM CONFIGURATION WHERE CATEGORY = 'core' AND NAME = 'update.url'

UPDATE SCRIPT SET ID = 'Undeploy' WHERE GROUP_ID = 'Global' AND ID = 'Shutdown'