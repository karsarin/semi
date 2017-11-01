DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
  MEMBER_ID VARCHAR2(15) PRIMARY KEY,
  MEMBER_PWD VARCHAR2(20)NOT NULL,
  MEMBER_NAME VARCHAR2(50) NOT NULL,
  MEMBER_NO VARCHAR2(13) NOT NULL
  CONSTRAINT MEMBER_NO_UK UNIQUE,
  MEMBER_NIK VARCHAR2(20) NOT NULL
  CONSTRAINT MEMBER_NIK_UK UNIQUE,
  MEMBER_ADDRESS VARCHAR2(255) NOT NULL,
  MEMBER_EMAIL VARCHAR2(255) NOT NULL
  CONSTRAINT MEMBER_EMAIL_UK UNIQUE,
  MEMBER_PHONE VARCHAR2(30) NOT NULL
  CONSTRAINT MEMBER_PHONE_UK UNIQUE,
  SIGNUP_DATE DATE DEFAULT SYSDATE NOT NULL,
  CONNECTION CHAR(1) CHECK(CONNECTION IN('Y','N')) NOT NULL,
  TALENT VARCHAR2(255),
  manager_chatting      CHAR(1)  DEFAULT 'Y' CONSTRAINT NN_CHAT NOT NULL,
  manager_login     CHAR(1) DEFAULT 'Y' CONSTRAINT NN_LOGIN NOT NULL,
  CONSTRAINT CK_CHAT_LOGIN CHECK(manager_chatting IN ('N','Y')), CHECK(manager_login IN ('N','Y'))
);
COMMENT ON COLUMN MEMBER.MEMBER_ID IS '���̵�';
COMMENT ON COLUMN MEMBER.MEMBER_PWD IS '��й�ȣ';
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS '�̸�';
COMMENT ON COLUMN MEMBER.MEMBER_NO IS '�ֹι�ȣ';
COMMENT ON COLUMN MEMBER.MEMBER_NIK IS '�г���';
COMMENT ON COLUMN MEMBER.MEMBER_ADDRESS IS '�ּ�';
COMMENT ON COLUMN MEMBER.MEMBER_EMAIL IS '�̸���';
COMMENT ON COLUMN MEMBER.MEMBER_PHONE IS '��ȭ��ȣ';
COMMENT ON COLUMN MEMBER.SIGNUP_DATE IS '������';
COMMENT ON COLUMN MEMBER.CONNECTION IS '���ӿ���';
COMMENT ON COLUMN MEMBER.TALENT IS '���';
COMMENT ON COLUMN MEMBER.manager_chatting IS 'ä�ð��ɿ���';
COMMENT ON COLUMN MEMBER.manager_login IS '�α��ΰ��ɿ���';

--------------------- ���� ������ -------------------------------
INSERT INTO MEMBER VALUES (
  'user11', 'pass11', '����1', '9001011122334', '����_1', 
  '����� ������ ���ﵿ', 'user11@iei.org', '01012345678',
  DEFAULT, 'N', '���α׷���', DEFAULT, DEFAULT
);
INSERT INTO MEMBER VALUES (
  'user22', 'pass22', '����2', '9101011122334', '����_2', 
  '����� ������ ���ﵿ', 'user22@iei.org', '01012345679',
  DEFAULT, 'N', '������', DEFAULT, DEFAULT
);
INSERT INTO MEMBER VALUES (
  'user33', 'pass33', '����3', '9301011122334', '����_3', 
  '����� ������ ���ﵿ', 'user33@iei.org', '01012345688',
  DEFAULT, 'N', '������,���α׷���', DEFAULT, DEFAULT
);
INSERT INTO MEMBER VALUES (
  'user44', 'pass44', '����4', '9401011122334', '����_4', 
  '����� ������ ���ﵿ', 'user44@iei.org', '01022345678',
  DEFAULT, 'N', '�뿪,����', DEFAULT, DEFAULT
);
INSERT INTO MEMBER VALUES (
  'user55', 'pass55', '����5', '9501011122334', '����_5', 
  '����� ������ ���ﵿ', 'user55@iei.org', '01012348678',
  DEFAULT, 'N', '���α׷���', DEFAULT, DEFAULT
);
INSERT INTO MEMBER VALUES (
  'user66', 'pass66', '����6', '9601011122334', '����_6', 
  '����� ������ ���ﵿ', 'user66@iei.org', '01012645678',
  DEFAULT, 'N', '���α׷���', DEFAULT, DEFAULT
);
INSERT INTO MEMBER VALUES (
  'user77', 'pass77', '����7', '9701011122334', '����_7', 
  '����� ������ ���ﵿ', 'user77@iei.org', '01012345778',
  DEFAULT, 'N', '���α׷���', DEFAULT, DEFAULT
);
INSERT INTO MEMBER VALUES (
  'user88', 'pass88', '����8', '8801011122334', '����_8', 
  '����� ������ ���ﵿ', 'user88@iei.org', '01088345778',
  DEFAULT, 'N', '���α׷���', DEFAULT, DEFAULT
);
INSERT INTO MEMBER VALUES (
  'user99', 'pass99', '����99', '8901011122334', '����_9', 
  '����� ������ ���ﵿ', 'user99@iei.org', '01012995778',
  DEFAULT, 'N', '���α׷���', DEFAULT, DEFAULT
);
INSERT INTO MEMBER VALUES (
  'user10', 'pass10', '����10', '8401011122334', '����_10', 
  '����� ������ ���ﵿ', 'user10@iei.org', '01011045778',
  DEFAULT, 'N', '���α׷���', DEFAULT, DEFAULT
);
INSERT INTO MEMBER VALUES (
  'admin', 'admin', '������', '1111111111111', '������', 
  '����� ������ ���ﵿ', 'admin@iei.org', '01011111111',
  DEFAULT, 'N', '������', DEFAULT, DEFAULT
);