-- SET ECHO ON

BEGIN
	FOR R1 IN (SELECT TABLE_NAME FROM USER_TABLES) LOOP
		BEGIN
			EXECUTE IMMEDIATE 'DROP TABLE ' || R1.TABLE_NAME;
			EXCEPTION WHEN OTHERS THEN NULL;
		END;
	END LOOP;
END;
/

DROP SEQUENCE EVENT_SEQUENCE;

CREATE SEQUENCE EVENT_SEQUENCE START WITH 1 INCREMENT BY 1;

DROP TABLE EVENT;

CREATE TABLE EVENT
	(ID INTEGER NOT NULL PRIMARY KEY,
	DATE_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	EVENT CLOB NOT NULL,
	EVENT_LEVEL VARCHAR(40) NOT NULL,
	DESCRIPTION CLOB,
	ATTRIBUTES CLOB);

DROP TABLE CHANNEL;

CREATE TABLE CHANNEL
	(ID VARCHAR(255) NOT NULL PRIMARY KEY,
	NAME VARCHAR(40) NOT NULL,
	DESCRIPTION CLOB,
	IS_ENABLED CHAR(1),
	VERSION VARCHAR(40),
	REVISION INTEGER,
	DIRECTION VARCHAR(40),
	PROTOCOL VARCHAR(40),
	C_MODE VARCHAR(40),
	SOURCE_CONNECTOR CLOB,
	DESTINATION_CONNECTORS CLOB,
	PROPERTIES CLOB,
	PREPROCESSING_SCRIPT CLOB);

DROP SEQUENCE MESSAGE_SEQUENCE;

CREATE SEQUENCE MESSAGE_SEQUENCE START WITH 1 INCREMENT BY 1;

DROP TABLE MESSAGE;

CREATE TABLE MESSAGE
	(SEQUENCE_ID INTEGER NOT NULL PRIMARY KEY,
	ID VARCHAR(255) NOT NULL,
	CHANNEL_ID VARCHAR(255) NOT NULL REFERENCES CHANNEL(ID) ON DELETE CASCADE,
	SOURCE VARCHAR(255),
	TYPE VARCHAR(255),
	DATE_CREATED TIMESTAMP NOT NULL,
	VERSION VARCHAR(40),
	IS_ENCRYPTED CHAR(1) NOT NULL,
	STATUS VARCHAR(40),
	RAW_DATA CLOB,
	RAW_DATA_PROTOCOL VARCHAR(40),
	TRANSFORMED_DATA CLOB,
	TRANSFORMED_DATA_PROTOCOL VARCHAR(40),
	ENCODED_DATA CLOB,
	ENCODED_DATA_PROTOCOL VARCHAR(40),
	CONNECTOR_MAP CLOB,
	CHANNEL_MAP CLOB,
	RESPONSE_MAP CLOB,
	CONNECTOR_NAME VARCHAR(255),
	ERRORS CLOB,
	CORRELATION_ID VARCHAR(255),
	UNIQUE (ID));

CREATE INDEX MESSAGE_INDEX1 ON MESSAGE(SEQUENCE_ID, DATE_CREATED, CHANNEL_ID);

CREATE INDEX MESSAGE_INDEX2 ON MESSAGE(STATUS, CHANNEL_ID);

CREATE INDEX MESSAGE_INDEX3 ON MESSAGE(CORRELATION_ID, CHANNEL_ID);

CREATE INDEX MESSAGE_INDEX4 ON MESSAGE(CHANNEL_ID);
	
DROP TABLE SCRIPT;

CREATE TABLE SCRIPT
	(ID VARCHAR(255) NOT NULL PRIMARY KEY,
	SCRIPT CLOB);

DROP TABLE TEMPLATE;

CREATE TABLE TEMPLATE
	(ID VARCHAR(255) NOT NULL PRIMARY KEY,
	TEMPLATE CLOB);

DROP SEQUENCE PERSON_SEQUENCE;	

CREATE SEQUENCE PERSON_SEQUENCE START WITH 1 INCREMENT BY 1;

DROP TABLE PERSON;

CREATE TABLE PERSON
	(ID INTEGER NOT NULL PRIMARY KEY,
	USERNAME VARCHAR(40) NOT NULL,
	PASSWORD VARCHAR(40) NOT NULL,
	SALT VARCHAR(40) NOT NULL,
	FULLNAME VARCHAR(255),
	EMAIL VARCHAR(255),
	PHONENUMBER VARCHAR(40),
	DESCRIPTION VARCHAR(255),
	LOGGED_IN CHAR(1) NOT NULL);

DROP TABLE ALERT;

CREATE TABLE ALERT
	(ID VARCHAR(255) NOT NULL PRIMARY KEY,
	NAME VARCHAR(40) NOT NULL,
	IS_ENABLED CHAR(1) NOT NULL,
	EXPRESSION CLOB,
	TEMPLATE CLOB);
	
DROP TABLE CHANNEL_ALERT;

CREATE TABLE CHANNEL_ALERT
	(CHANNEL_ID VARCHAR(255) NOT NULL,
	ALERT_ID VARCHAR(255) NOT NULL REFERENCES ALERT(ID) ON DELETE CASCADE);

DROP TABLE ALERT_EMAIL;

CREATE TABLE ALERT_EMAIL
	(ALERT_ID VARCHAR(255) NOT NULL REFERENCES ALERT(ID) ON DELETE CASCADE,
	EMAIL VARCHAR(255) NOT NULL);

DROP TABLE TRANSPORT;

CREATE TABLE TRANSPORT
	(NAME VARCHAR(255) NOT NULL PRIMARY KEY,
	CLASS_NAME VARCHAR(255) NOT NULL,
	PROTOCOL VARCHAR(255) NOT NULL,
	TRANSFORMERS VARCHAR(255),
	TYPE VARCHAR(255) NOT NULL);

DROP SEQUENCE CONFIGURATION_SEQUENCE;

CREATE SEQUENCE CONFIGURATION_SEQUENCE START WITH 1 INCREMENT BY 1;

DROP TABLE CONFIGURATION;

CREATE TABLE CONFIGURATION
	(ID INTEGER NOT NULL PRIMARY KEY,
	DATE_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	DATA CLOB NOT NULL);
	
DROP TABLE ENCRYPTION_KEY;

CREATE TABLE ENCRYPTION_KEY
	(DATA CLOB NOT NULL);

INSERT INTO PERSON (ID, USERNAME, PASSWORD, SALT, LOGGED_IN) VALUES (PERSON_SEQUENCE.NEXTVAL, 'admin', '0DPiKuNIrrVmD8IUCuw1hQxNqZc=', 'Np+FZYzu4M0=', '0');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('FTP Reader', 'com.webreach.mirth.server.mule.providers.ftp.FtpConnector', 'ftp', 'ByteArrayToString', 'LISTENER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('SFTP Reader', 'com.webreach.mirth.server.mule.providers.sftp.SftpConnector', 'sftp', 'ByteArrayToString', 'LISTENER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('JMS Reader', 'com.webreach.mirth.server.mule.providers.jms.JmsConnector', 'jms', 'JMSMessageToObject ObjectToString', 'LISTENER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('SOAP Listener', 'com.webreach.mirth.server.mule.providers.soap.axis.AxisConnector', 'axis', 'SOAPRequestToString', 'LISTENER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('File Reader', 'com.webreach.mirth.server.mule.providers.file.FileConnector', 'file', 'ByteArrayToString', 'LISTENER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('Database Reader', 'com.webreach.mirth.server.mule.providers.jdbc.JdbcConnector', 'jdbc', 'ResultMapToXML', 'LISTENER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('LLP Listener', 'com.webreach.mirth.server.mule.providers.mllp.MllpConnector', 'mllp', 'ByteArrayToString', 'LISTENER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('TCP Listener', 'com.webreach.mirth.server.mule.providers.tcp.TcpConnector', 'tcp', 'ByteArrayToString', 'LISTENER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('Channel Reader', 'com.webreach.mirth.server.mule.providers.vm.VMConnector', 'vm', NULL, 'LISTENER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('HTTP Listener', 'com.webreach.mirth.server.mule.providers.http.HttpConnector', 'http', 'HttpRequestToString HttpStringToXML', 'LISTENER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('FTP Writer', 'com.webreach.mirth.server.mule.providers.ftp.FtpConnector', 'ftp', NULL, 'SENDER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('SFTP Writer', 'com.webreach.mirth.server.mule.providers.sftp.SftpConnector', 'sftp', NULL, 'SENDER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('JMS Writer', 'com.webreach.mirth.server.mule.providers.jms.JmsConnector', 'jms', NULL, 'SENDER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('SOAP Sender', 'com.webreach.mirth.server.mule.providers.soap.axis.AxisConnector', 'axis', NULL, 'SENDER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('Document Writer', 'com.webreach.mirth.server.mule.providers.doc.DocumentConnector', 'doc', NULL, 'SENDER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('File Writer', 'com.webreach.mirth.server.mule.providers.file.FileConnector', 'file', NULL, 'SENDER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('Database Writer', 'com.webreach.mirth.server.mule.providers.jdbc.JdbcConnector', 'jdbc', NULL, 'SENDER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('LLP Sender', 'com.webreach.mirth.server.mule.providers.mllp.MllpConnector', 'mllp', NULL, 'SENDER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('TCP Sender', 'com.webreach.mirth.server.mule.providers.tcp.TcpConnector', 'tcp', NULL, 'SENDER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('Channel Writer', 'com.webreach.mirth.server.mule.providers.vm.VMConnector', 'vm', NULL, 'SENDER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('Email Sender', 'com.webreach.mirth.server.mule.providers.email.SmtpConnector', 'smtp', NULL, 'SENDER');

INSERT INTO TRANSPORT (NAME, CLASS_NAME, PROTOCOL, TRANSFORMERS, TYPE) VALUES ('HTTP Sender', 'com.webreach.mirth.server.mule.providers.http.HttpConnector', 'http', NULL, 'SENDER');

COMMIT;
