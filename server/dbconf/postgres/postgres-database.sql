CREATE TABLE SCHEMA_INFO
	(VERSION INTEGER);

CREATE SEQUENCE EVENT_SEQUENCE START WITH 1;

CREATE TABLE EVENT
	(ID INTEGER DEFAULT nextval('EVENT_SEQUENCE') NOT NULL PRIMARY KEY,
	DATE_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	NAME TEXT NOT NULL,
	EVENT_LEVEL VARCHAR(40) NOT NULL,
	OUTCOME VARCHAR(40) NOT NULL,
	ATTRIBUTES TEXT,
	USER_ID INTEGER NOT NULL,
	IP_ADDRESS VARCHAR(40));
	
CREATE TABLE CHANNEL
	(ID CHAR(36) NOT NULL PRIMARY KEY,
	NAME VARCHAR(40) NOT NULL,
	DESCRIPTION TEXT,
	IS_ENABLED BOOLEAN NOT NULL,
	VERSION VARCHAR(40),
	REVISION INTEGER,
	LAST_MODIFIED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	SOURCE_CONNECTOR TEXT,
	DESTINATION_CONNECTORS TEXT,
	PROPERTIES TEXT,
	PREPROCESSING_SCRIPT TEXT,
	POSTPROCESSING_SCRIPT TEXT,
	DEPLOY_SCRIPT TEXT,
	SHUTDOWN_SCRIPT TEXT);
	
CREATE TABLE CHANNEL_STATISTICS
	(SERVER_ID CHAR(36) NOT NULL,
	CHANNEL_ID CHAR(36) NOT NULL REFERENCES CHANNEL(ID) ON DELETE CASCADE,
	RECEIVED NUMERIC,
	FILTERED NUMERIC,
	SENT NUMERIC,
	ERROR NUMERIC,
	QUEUED NUMERIC,
	ALERTED NUMERIC,
	PRIMARY KEY(SERVER_ID, CHANNEL_ID));

CREATE SEQUENCE MESSAGE_SEQUENCE START WITH 1;

CREATE TABLE CHANNEL_TAGS (
	CHANNEL_ID CHAR(36) NOT NULL,
	TAG VARCHAR(255) NOT NULL,
	CONSTRAINT CHANNEL_TAGS_PKEY PRIMARY KEY (channel_id, tag)
);

CREATE TABLE ATTACHMENT
    (ID VARCHAR(255) NOT NULL PRIMARY KEY,
     MESSAGE_ID VARCHAR(255) NOT NULL,
     ATTACHMENT_DATA BYTEA,
     ATTACHMENT_SIZE INTEGER,
     ATTACHMENT_TYPE VARCHAR(40));

CREATE INDEX ATTACHMENT_INDEX1 ON ATTACHMENT(MESSAGE_ID);

CREATE TABLE MESSAGE
	(SEQUENCE_ID INTEGER DEFAULT NEXTVAL('MESSAGE_SEQUENCE') NOT NULL PRIMARY KEY,
	ID CHAR(36) NOT NULL,
	SERVER_ID CHAR(36) NOT NULL,
	CHANNEL_ID CHAR(36) NOT NULL REFERENCES CHANNEL(ID) ON DELETE CASCADE,
	SOURCE VARCHAR(255),
	TYPE VARCHAR(255),
	DATE_CREATED TIMESTAMP NOT NULL,
	VERSION VARCHAR(40),
	IS_ENCRYPTED BOOLEAN NOT NULL,
	STATUS VARCHAR(40),
	RAW_DATA TEXT,
	RAW_DATA_PROTOCOL VARCHAR(40),
	TRANSFORMED_DATA TEXT,
	TRANSFORMED_DATA_PROTOCOL VARCHAR(40),
	ENCODED_DATA TEXT,
	ENCODED_DATA_PROTOCOL VARCHAR(40),
	CONNECTOR_MAP TEXT,
	CHANNEL_MAP TEXT,
	RESPONSE_MAP TEXT,
	CONNECTOR_NAME VARCHAR(255),
	ERRORS TEXT,
	CORRELATION_ID VARCHAR(255),
	ATTACHMENT BOOLEAN,	
	UNIQUE (ID));

CREATE INDEX MESSAGE_INDEX1 ON MESSAGE(CHANNEL_ID, DATE_CREATED);

CREATE INDEX MESSAGE_INDEX2 ON MESSAGE(CHANNEL_ID, DATE_CREATED, CONNECTOR_NAME);

CREATE INDEX MESSAGE_INDEX3 ON MESSAGE(CHANNEL_ID, DATE_CREATED, RAW_DATA_PROTOCOL);

CREATE INDEX MESSAGE_INDEX4 ON MESSAGE(CHANNEL_ID, DATE_CREATED, SOURCE);

CREATE INDEX MESSAGE_INDEX5 ON MESSAGE(CHANNEL_ID, DATE_CREATED, STATUS);

CREATE INDEX MESSAGE_INDEX6 ON MESSAGE(CHANNEL_ID, DATE_CREATED, TYPE);

CREATE INDEX MESSAGE_INDEX7 ON MESSAGE(CORRELATION_ID, CONNECTOR_NAME);

CREATE INDEX MESSAGE_INDEX8 ON MESSAGE(ATTACHMENT) WHERE (ATTACHMENT=TRUE);
	
CREATE TABLE SCRIPT
	(GROUP_ID VARCHAR(40) NOT NULL,
	ID VARCHAR(40) NOT NULL,
	SCRIPT TEXT,
	PRIMARY KEY(GROUP_ID, ID));

CREATE TABLE TEMPLATE
	(GROUP_ID VARCHAR(255) NOT NULL,
	ID VARCHAR(255) NOT NULL,
	TEMPLATE TEXT,
	PRIMARY KEY(GROUP_ID, ID));	

CREATE SEQUENCE PERSON_SEQUENCE START WITH 1;

CREATE TABLE PERSON
	(ID INTEGER DEFAULT nextval('PERSON_SEQUENCE') NOT NULL PRIMARY KEY,
	USERNAME VARCHAR(40) NOT NULL,
	FIRSTNAME VARCHAR(40),
	LASTNAME VARCHAR(40),
	ORGANIZATION VARCHAR(255),
	EMAIL VARCHAR(255),
	PHONENUMBER VARCHAR(40),
	DESCRIPTION VARCHAR(255),
	LAST_LOGIN TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	GRACE_PERIOD_START TIMESTAMP DEFAULT NULL,
	LOGGED_IN BOOLEAN NOT NULL);

CREATE TABLE PERSON_PASSWORD
	(PERSON_ID INTEGER NOT NULL REFERENCES PERSON(ID) ON DELETE CASCADE,
	PASSWORD VARCHAR(256) NOT NULL,
	PASSWORD_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

CREATE TABLE ALERT
	(ID CHAR(36) NOT NULL PRIMARY KEY,
	NAME VARCHAR(40) NOT NULL,
	IS_ENABLED BOOLEAN NOT NULL,
	EXPRESSION TEXT,
	TEMPLATE TEXT,
	SUBJECT VARCHAR(998));
	
CREATE TABLE CODE_TEMPLATE
	(ID VARCHAR(255) NOT NULL PRIMARY KEY,
	NAME VARCHAR(40) NOT NULL,
	CODE_SCOPE VARCHAR(40) NOT NULL,
	CODE_TYPE VARCHAR(40) NOT NULL,
	TOOLTIP VARCHAR(255),
	CODE TEXT);		
	
CREATE TABLE CHANNEL_ALERT
	(CHANNEL_ID CHAR(36) NOT NULL,
	ALERT_ID CHAR(36) NOT NULL REFERENCES ALERT(ID) ON DELETE CASCADE);

CREATE TABLE ALERT_EMAIL
	(ALERT_ID CHAR(36) NOT NULL REFERENCES ALERT(ID) ON DELETE CASCADE,
	EMAIL VARCHAR(255) NOT NULL);

CREATE SEQUENCE CONFIGURATION_SEQUENCE START WITH 1;

CREATE TABLE CONFIGURATION
	(CATEGORY VARCHAR(255) NOT NULL,
	NAME VARCHAR(255) NOT NULL,
	VALUE TEXT);
	
CREATE TABLE tasks (
	task_id serial NOT NULL,
	task_type character varying(255) NOT NULL,
	task_description character varying(255) NOT NULL,
	date_created timestamp without time zone NOT NULL DEFAULT now(),
	CONSTRAINT tasks_pkey PRIMARY KEY (task_id)
);

CREATE TABLE reprocessing (
	reprocessing_id serial NOT NULL,
	user_id integer NOT NULL,
	message_id bigint NOT NULL,
	completed boolean NOT NULL DEFAULT false,
	CONSTRAINT reprocessing_pkey PRIMARY KEY (reprocessing_id)
);

CREATE INDEX reprocessing_index1 ON reprocessing USING btree (user_id);

CREATE INDEX reprocessing_index2 ON reprocessing USING btree (completed);

INSERT INTO PERSON (USERNAME, LOGGED_IN) VALUES('admin', FALSE);

INSERT INTO PERSON_PASSWORD (PERSON_ID, PASSWORD) VALUES(1, 'YzKZIAnbQ5m+3llggrZvNtf5fg69yX7pAplfYg0Dngn/fESH93OktQ==');

INSERT INTO SCHEMA_INFO (VERSION) VALUES (9);

INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'update.url', 'http://updates.mirthcorp.com');

INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'update.enabled', '1');

INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'stats.enabled', '1');

INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'firstlogin', '1');

INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'server.resetglobalvariables', '1');

INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'smtp.timeout', '5000');

INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'smtp.auth', '0');

INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'smtp.secure', '0');

INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'server.maxqueuesize', '0');