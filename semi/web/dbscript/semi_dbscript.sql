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






DROP TABLE board CASCADE CONSTRAINTS;
create table board (
board_no number PRIMARY KEY,
board_name varchar2(30)
);
COMMENT ON COLUMN board.board_no IS '�Խ��� ���� ��ȣ';
COMMENT ON COLUMN board.board_name IS '�Խ��� ���� �̸�';

--------------------- ���� ������ -------------------------------
insert into board values(1,'��ɱ��');
insert into board values(2,'�����Խ���');
insert into board values(3,'QnA');






DROP TABLE CHAT CASCADE CONSTRAINTS;
CREATE TABLE CHAT (
  SENDER VARCHAR2(15) UNIQUE,
  RECIVER VARCHAR2(15) UNIQUE
);






DROP TABLE SUGGEST CASCADE CONSTRAINTS;
CREATE TABLE SUGGEST(
SUGGEST_NO NUMBER,
SUGGEST_TITLE VARCHAR2(50) NOT NULL,
SUGGEST_REQUEST_PREOID VARCHAR(20),
SUGGEST_CONTENT LONG,
SUGGEST_DATE DATE DEFAULT SYSDATE,
SUGGEST_ORIGINAL_FILENAME VARCHAR2(100),
SUGGEST_RENAME_FILENAME VARCHAR2(100),
SUGGEST_WRITER VARCHAR2(15) NOT NULL,
SUGGEST_RECIVE VARCHAR2(15),
CONSTRAINT PK_SUGGESTNO PRIMARY KEY (SUGGEST_NO),
CONSTRAINT FK_SUGGESTWR FOREIGN KEY (SUGGEST_WRITER) REFERENCES MEMBER (MEMBER_ID) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_SUGGESTRE FOREIGN KEY (SUGGEST_RECIVE) REFERENCES MEMBER (MEMBER_ID) ON DELETE CASCADE ON UPDATE CASCADE
);
COMMENT ON COLUMN SUGGEST.SUGGEST_NO IS '�䱸���� ��ȣ';
COMMENT ON COLUMN SUGGEST.SUGGEST_TITLE IS '�䱸���� ����';
COMMENT ON COLUMN SUGGEST.SUGGEST_REQUEST_PREOID IS '�䱸 �Ⱓ';
COMMENT ON COLUMN SUGGEST.SUGGEST_CONTENT IS '�䱸���� ����';
COMMENT ON COLUMN SUGGEST.SUGGEST_DATE IS '�䱸���� �ۼ�����';
COMMENT ON COLUMN SUGGEST.SUGGEST_ORIGINAL_FILENAME IS '�䱸���� ���� ÷�����ϸ�';
COMMENT ON COLUMN SUGGEST.SUGGEST_RENAME_FILENAME IS '�䱸���� �ٲ� ÷�����ϸ�';
COMMENT ON COLUMN SUGGEST.SUGGEST_WRITER IS '�䱸���� ������ ����';
COMMENT ON COLUMN SUGGEST.SUGGEST_RECIVE IS '�䱸���� �޴� ����';

--------------------- ���� ������ -------------------------------
insert into suggest values(
  1, '�䱸��������', '10��', '�䱸���׳���', default, null, null, 'user33', 'user22'
);





DROP TABLE DONATE CASCADE CONSTRAINTS;
CREATE TABLE DONATE(
  DONATION_NO VARCHAR2(13) PRIMARY KEY,
  MEMBER_ID VARCHAR2(15) NOT NULL,
  DONATION NUMBER NOT NULL,
  DONATION_DATE DATE DEFAULT SYSDATE NOT NULL
);
ALTER TABLE DONATE
ADD CONSTRAINT FK_MEMBER_ID FOREIGN KEY(MEMBER_ID)
REFERENCES MEMBER(MEMBER_ID) ON DELETE CASCADE ON UPDATE CASCADE;
COMMENT ON COLUMN DONATE.DONATION_NO IS '��� ��ȣ';
COMMENT ON COLUMN DONATE.MEMBER_ID IS '���̵�';
COMMENT ON COLUMN DONATE.DONATION IS '��α�';
COMMENT ON COLUMN DONATE.DONATION_DATE IS '�������';

--------------------- ���� ������ -------------------------------
insert into donate values(1,'user11',10000,default);
insert into donate values(2,'user22',10000,default);
insert into donate values(3,'user22',10000,default);
insert into donate values(4,'user44',10000,default);
insert into donate values(5,'user33',10000,default);
insert into donate values(6,'user55',10000,default);
insert into donate values(7,'user11',10000,default);
insert into donate values(8,'user77',10000,default);
insert into donate values(9,'user22',10000,default);
insert into donate values(10,'user11',10000,default);
insert into donate values(11,'user22',10000,default);
insert into donate values(12,'user22',10000,default);
insert into donate values(13,'user44',10000,default);
insert into donate values(14,'user55',10000,default);
insert into donate values(15,'user44',10000,default);
insert into donate values(16,'user33',10000,default);
insert into donate values(17,'user77',10000,default);
insert into donate values(18,'user99',10000,default);
insert into donate values(19,'user55',10000,default);
insert into donate values(20,'user22',10000,default);
insert into donate values(21,'user11',10000,default);
insert into donate values(22,'user11',10000,default);
insert into donate values(23,'user22',10000,default);
insert into donate values(24,'user66',10000,default);
insert into donate values(25,'user33',10000,default);
insert into donate values(26,'user33',10000,default);
insert into donate values(27,'user22',10000,default);
insert into donate values(28,'user77',10000,default);






DROP TABLE CATEGORY_GROUP CASCADE CONSTRAINTS;
CREATE TABLE CATEGORY_GROUP(
    GROUP_NO NUMBER NOT NULL CONSTRAINT PK_NO PRIMARY KEY,
    GROUP_NAME VARCHAR2(50)
);

--------------------- ���� ������ -------------------------------
INSERT INTO CATEGORY_GROUP VALUES(1, 'IT');
INSERT INTO CATEGORY_GROUP VALUES(2, '������');
INSERT INTO CATEGORY_GROUP VALUES(3, '������');
INSERT INTO CATEGORY_GROUP VALUES(4, '����');
INSERT INTO CATEGORY_GROUP VALUES(5, '���Ͽ�/���');
INSERT INTO CATEGORY_GROUP VALUES(6, '����');
INSERT INTO CATEGORY_GROUP VALUES(7, '�ǰ�');
INSERT INTO CATEGORY_GROUP VALUES(8, '��Ÿ');






DROP TABLE CATEGORY_BOARD CASCADE CONSTRAINTS;
CREATE TABLE CATEGORY_BOARD(
    CATEGORY_NO NUMBER CONSTRAINT PK_CATEGORY PRIMARY KEY,
    USER_ID VARCHAR2(15) NOT NULL,
    CATEGORY_GROUP NUMBER NOT NULL,
    CATEGORY_TITLE VARCHAR2(50) NOT NULL,
    CATEGORY_WRITER VARCHAR2(15) NOT NULL,
    CATEGORY_CONTENT VARCHAR2(2000) NOT NULL,
    CATEGORY_DATE DATE DEFAULT SYSDATE,
    CATEGORY_READCOUNT NUMBER DEFAULT 0,
    CATEGORY_DONATION NUMBER DEFAULT 0,
    WORK_DATE NUMBER DEFAULT 0,
    CATEGORY_LEVEL NUMBER,
    CATEGORY_REF NUMBER,
    CATEGORY_REPLY_REF NUMBER,
    CATEGORY_REPLY_SEQ NUMBER,
    PHONE CHAR(11),
    EMAIL VARCHAR2(30),
    ORIGINAL_IMAGE VARCHAR2(100),
    RENAME_IMAGE VARCHAR2(1000),
    ADD_IMAGE1 VARCHAR2(100),
    ADD_RENAME_IMAGE1 VARCHAR2(1000),
    ADD_IMAGE2 VARCHAR2(100),
    ADD_RENAME_IMAGE2 VARCHAR2(1000),
    ADD_IMAGE3 VARCHAR2(100),
    ADD_RENAME_IMAGE3 VARCHAR2(1000),
    ADD_IMAGE4 VARCHAR2(100),
    ADD_RENAME_IMAGE4 VARCHAR2(1000),
    VERDICT NUMBER DEFAULT 0,
    PURCHASE_COUNT NUMBER DEFAULT 0,
    SPECIAL CHAR(1) DEFAULT 'N',
    APPROVAL CHAR(1) DEFAULT 'N',
    BOARD_NO NUMBER default 1
);
ALTER TABLE category_board ADD FOREIGN KEY(board_no) references board(board_no);
ALTER TABLE CATEGORY_BOARD ADD CONSTRAINT FK_CATEGORYGROUP FOREIGN KEY (CATEGORY_GROUP) REFERENCES CATEGORY_GROUP(GROUP_NO) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE CATEGORY_BOARD ADD CONSTRAINT FK_USERID FOREIGN KEY (USER_ID) REFERENCES MEMBER(member_id) ON DELETE CASCADE ON UPDATE CASCADE;
COMMENT ON COLUMN CATEGORY_BOARD.CATEGORY_NO IS 'ī�װ��Խñ۹�ȣ';
COMMENT ON COLUMN CATEGORY_BOARD.USER_ID IS '���̵�';
COMMENT ON COLUMN CATEGORY_BOARD.CATEGORY_GROUP IS 'ī�װ��з�';
COMMENT ON COLUMN CATEGORY_BOARD.CATEGORY_TITLE IS 'ī�װ��Խñ��̸�';
COMMENT ON COLUMN CATEGORY_BOARD.CATEGORY_DATE IS '�ۼ�����';
COMMENT ON COLUMN CATEGORY_BOARD.CATEGORY_DONATION IS '��α�';
COMMENT ON COLUMN CATEGORY_BOARD.WORK_DATE IS '�۾���';
COMMENT ON COLUMN CATEGORY_BOARD.ORIGINAL_IMAGE IS '�����̹���';
COMMENT ON COLUMN CATEGORY_BOARD.ORIGINAL_IMAGE IS '�̸��ٲ��̹���';
COMMENT ON COLUMN CATEGORY_BOARD.CATEGORY_CONTENT IS '�󼼳���';
COMMENT ON COLUMN CATEGORY_BOARD.PHONE IS '��ȭ��ȣ';
COMMENT ON COLUMN CATEGORY_BOARD.EMAIL IS '�̸���';
COMMENT ON COLUMN CATEGORY_BOARD.CATEGORY_READCOUNT IS '��ȸ��';

--------------------- ���� ������ -------------------------------
INSERT INTO CATEGORY_BOARD VALUES(1, 'user11', 1, 'IT ���', 'user11', 
    'IT ��� �����', DEFAULT, DEFAULT, 10000, 1, 1, 0, 0, 0, 01012345678, 'user11@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);    
INSERT INTO CATEGORY_BOARD VALUES(2, 'user22', 2, '���� ���', 'user22', 
    '���� ��� �����', DEFAULT, DEFAULT, 500000, 3, 1, 0, 0, 0, 01023456789, 'user22@daum.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);    
INSERT INTO CATEGORY_BOARD VALUES(3, 'user33', 3, '�ǰ� ���', 'user33', 
    '�ǰ� ��� �����', DEFAULT, DEFAULT, 7000, 2, 1, 0, 0, 0, 01034567890, 'user33@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(4, 'user44', 4, '������ ���', 'user44', 
    '������ ��� �����', DEFAULT, DEFAULT, 40000, 4, 1, 0, 0, 0, 01045678901, 'user44@hotmail.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(5, 'user55', 5, '������ ���', 'user55', 
    '������ ��� �����', DEFAULT, DEFAULT, 20000, 6, 1, 0, 0, 0, 01056789012, 'user55@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(6, 'user66', 6, '���� ���', 'user66', 
    '���� ��� �����', DEFAULT, DEFAULT, 610000, 6, 1, 0, 0, 0, 01067890123, 'user66@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(7, 'user77', 7, '���Ͽ�/��� ���', 'user77', 
    '���Ͽ�/��� ��� �����', DEFAULT, DEFAULT, 70000, 1, 1, 0, 0, 0, 01089012345, 'user77@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(8, 'user88', 8, '���� ���', 'user88', 
    '���� ��� �����', DEFAULT, DEFAULT, 80000, 8, 1, 0, 0, 0, 01078901234, 'user88@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(9, 'user99', 8, '���� ���', 'user88', 
    '���� ��� �����', DEFAULT, DEFAULT, 80000, 8, 1, 0, 0, 0, 01078901234, 'user88@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(10, 'user66', 6, '���� ���', 'user66', 
    '���� ��� �����', DEFAULT, DEFAULT, 610000, 6, 1, 0, 0, 0, 01067890123, 'user66@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(11, 'user77', 7, '���Ͽ�/��� ���', 'user77', 
    '���Ͽ�/��� ��� �����', DEFAULT, DEFAULT, 70000, 1, 1, 0, 0, 0, 01089012345, 'user77@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(12, 'user88', 8, '���� ���', 'user88', 
    '���� ��� �����', DEFAULT, DEFAULT, 80000, 8, 1, 0, 0, 0, 01078901234, 'user88@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(13, 'user99', 8, '���� ���', 'user88', 
    '���� ��� �����', DEFAULT, DEFAULT, 80000, 8, 1, 0, 0, 0, 01078901234, 'user88@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(14, 'user66', 6, '���� ���', 'user66', 
    '���� ��� �����', DEFAULT, DEFAULT, 610000, 6, 1, 0, 0, 0, 01067890123, 'user66@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(15, 'user77', 7, '���Ͽ�/��� ���', 'user77', 
    '���Ͽ�/��� ��� �����', DEFAULT, DEFAULT, 70000, 1, 1, 0, 0, 0, 01089012345, 'user77@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(16, 'user88', 8, '���� ���', 'user88', 
    '���� ��� �����', DEFAULT, DEFAULT, 80000, 8, 1, 0, 0, 0, 01078901234, 'user88@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO CATEGORY_BOARD VALUES(17, 'user99', 8, '���� ���', 'user88', 
    '���� ��� �����', DEFAULT, DEFAULT, 80000, 8, 1, 0, 0, 0, 01078901234, 'user88@naver.com',
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);






drop table category_used cascade constraints;
CREATE TABLE CATEGORY_USED(
USE_NO NUMBER PRIMARY KEY,
USE_ID VARCHAR2(15) NOT NULL,
CATEGORY_NO NUMBER NOT NULL,
USED_DATE DATE DEFAULT SYSDATE NOT NULL
);
ALTER TABLE CATEGORY_USED
ADD CONSTRAINT FK_CATEGORY_USED_ID FOREIGN KEY(USE_ID)
REFERENCES MEMBER(MEMBER_ID) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE CATEGORY_USED
ADD CONSTRAINT FK_CATEGORY_NO FOREIGN KEY(CATEGORY_NO)
REFERENCES CATEGORY_BOARD(CATEGORY_NO) ON DELETE CASCADE ON UPDATE CASCADE;
COMMENT ON COLUMN CATEGORY_USED.USE_NO IS '��û��ȣ';
COMMENT ON COLUMN CATEGORY_USED.USE_ID IS '����ھ��̵�';
COMMENT ON COLUMN CATEGORY_USED.CATEGORY_NO IS 'ī�װ���ȣ';
COMMENT ON COLUMN CATEGORY_USED.USED_DATE IS '��û����';
---------------------------------------------------------------
insert into CATEGORY_USED values(1, 'user11', 1, default);






DROP TABLE NOTICE CASCADE CONSTRAINTS;
CREATE TABLE NOTICE(
  NOTICE_NO NUMBER,
  NOTICE_TITLE VARCHAR2(50) NOT NULL,
  NOTICE_WRITER VARCHAR2(15) NOT NULL,
  NOTICE_CONTENT LONG, 
  NOTICE_DATE DATE DEFAULT SYSDATE,
  ORIGINAL_FILENAME VARCHAR2(100),
  RENAME_FILENAME VARCHAR2(100),
  READ_COUNT NUMBER DEFAULT 0,
  CONSTRAINT PK_NOTICENO PRIMARY KEY(NOTICE_NO),
  CONSTRAINT FK_NOTICEWR FOREIGN KEY(NOTICE_WRITER) REFERENCES MEMBER(MEMBER_ID) ON DELETE CASCADE ON UPDATE CASCADE
);
COMMENT ON COLUMN NOTICE.NOTICE_NO IS '�����۹�ȣ';
COMMENT ON COLUMN NOTICE.NOTICE_TITLE IS '����������';
COMMENT ON COLUMN NOTICE.NOTICE_WRITER IS '�������ۼ��ھ��̵�';
COMMENT ON COLUMN NOTICE.NOTICE_CONTENT IS '�����۳���';
COMMENT ON COLUMN NOTICE.NOTICE_DATE IS '�����ۿø���¥';
COMMENT ON COLUMN NOTICE.ORIGINAL_FILENAME IS '����÷�����ϸ�';
COMMENT ON COLUMN NOTICE.RENAME_FILENAME IS '�ٲ�÷�����ϸ�';
COMMENT ON COLUMN NOTICE.READ_COUNT IS '��ȸ��';

--------------------- ���� ������ -------------------------------
INSERT INTO NOTICE VALUES(1, '����ٴ� ������1', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT );
INSERT INTO NOTICE VALUES(2, '����ٴ� ������2', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT );
INSERT INTO NOTICE VALUES(3, '����ٴ� ������3', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT );
INSERT INTO NOTICE VALUES(4, '����ٴ� ������4', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT );
INSERT INTO NOTICE VALUES(5, '����ٴ� ������5', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT );
INSERT INTO NOTICE VALUES(6, '����ٴ� ������6', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT );
INSERT INTO NOTICE VALUES(7, '����ٴ� ������7', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT );
INSERT INTO NOTICE VALUES(8, '����ٴ� ������8', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT );
INSERT INTO NOTICE VALUES(9, '����ٴ� ������9', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT);
INSERT INTO NOTICE VALUES(10, '����ٴ� ������10', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT);
INSERT INTO NOTICE VALUES(11, '����ٴ� ������11', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT);
INSERT INTO NOTICE VALUES(12, '����ٴ� ������12', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT);
INSERT INTO NOTICE VALUES(13, 'search Ȯ�ο�', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT );
INSERT INTO NOTICE VALUES(14, 'search Ȯ�ο�', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT );
INSERT INTO NOTICE VALUES(15, 'search Ȯ�ο�', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT );
INSERT INTO NOTICE VALUES(16, 'search Ȯ�ο�', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT);
INSERT INTO NOTICE VALUES(17, 'search Ȯ�ο�', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT);
INSERT INTO NOTICE VALUES(18, 'search Ȯ�ο�', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT);
INSERT INTO NOTICE VALUES(19, 'search Ȯ�ο�', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT);
INSERT INTO NOTICE VALUES(20, 'search Ȯ�ο�', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT);






DROP TABLE question cascade CONSTRAINTS;
create table question(
question_num number,
question_title varchar2(50) NOT NULL,
question_writer varchar2(15) NOT NULL,
question_content varchar2(2000) NOT NULL,
question_original_imagename varchar2(100),
question_rename_imagename varchar2(100),
question_date date DEFAULT SYSDATE,
question_readcount number DEFAULT 0,
question_level number DEFAULT 0,
question_ref number,
question_reply_ref number,
question_reply_seq number DEFAULT 0,
answer CHAR(1) DEFAULT 'N' CONSTRAINT CK_ANSWER CHECK(answer IN('Y','N')),
board_no number default 3,
CONSTRAINT PK_question PRIMARY KEY (question_NUM),
CONSTRAINT FK_question_WR FOREIGN KEY (question_WRITER) REFERENCES MEMBER (MEMBER_ID) ON DELETE SET NULL,
CONSTRAINT FK_question_REF FOREIGN KEY (question_REF) REFERENCES question (question_NUM) ON DELETE CASCADE,
CONSTRAINT FK_question_REPLY_REF FOREIGN KEY (question_REPLY_REF) REFERENCES question (question_NUM) ON DELETE CASCADE
);
COMMENT ON COLUMN question.question_NUM IS '�Խñ۹�ȣ';
COMMENT ON COLUMN question.question_WRITER IS '�Խñ��ۼ���';
COMMENT ON COLUMN question.question_TITLE IS '�Խñ�����';
COMMENT ON COLUMN question.question_CONTENT IS '�Խñ۳���';
COMMENT ON COLUMN question.question_DATE IS '�Խñ۳�¥';
COMMENT ON COLUMN question.question_ORIGINAL_FILENAME IS '�����̹������ϸ�';
COMMENT ON COLUMN question.question_RENAME_FILENAME IS '�ٲ��̹������ϸ�';
COMMENT ON COLUMN question.question_LEVEL IS '��۷���';
COMMENT ON COLUMN question.question_REF IS '�����Խñ۹�ȣ';
COMMENT ON COLUMN question.question_REPLY_REF IS '�������';
COMMENT ON COLUMN question.question_REPLY_SEQ IS '��۽�����';
COMMENT ON COLUMN question.question_READCOUNT IS '��ȸ��';
COMMENT ON COLUMN question.answer IS '�亯����';
COMMENT ON COLUMN question.board_no IS '�Խ��Ǳ��й�ȣ';

--------------------- ���� ������ -------------------------------
INSERT INTO question VALUES(1,'�Խñ�1','user22','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,1,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(2,'�Խñ�2','user22','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,2,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(3,'�Խñ�3','user22','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,3,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(4,'�Խñ�4','user11','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,4,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(5,'�Խñ�5','user22','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,5,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(6,'�Խñ�6','user22','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,6,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(7,'�Խñ�7','user11','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,7,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(8,'�Խñ�8','user22','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,8,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(9,'�Խñ�9','user11','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,9,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(10,'�Խñ�10','user22','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,10,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(11,'�Խñ�11','user22','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,11,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(12,'�Խñ�12','user22','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,12,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(13,'�Խñ�13','user11','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,13,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(14,'�Խñ�14','user22','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,14,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(15,'�Խñ�15','user11','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,15,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(16,'�Խñ�16','user22','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,16,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(17,'�Խñ�17','user11','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,17,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(18,'�Խñ�18','user22','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,18,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(19,'�Խñ�19','user11','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,19,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(20,'�Խñ�20','user11','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,20,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(21,'�Խñ�21','user11','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,21,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(22,'�Խñ�22','user11','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,22,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(23,'�Խñ�23','user11','���� �����Դϴ�',NULL,NULL,SYSDATE,0,0,23,NULL,0,DEFAULT,DEFAULT);






DROP TABLE FREEBOARD CASCADE CONSTRAINTS;
CREATE TABLE FREEBOARD(
  FREEBOARD_NO NUMBER,
  FREEBOARD_TITLE VARCHAR2(50) NOT NULL,
  FREEBOARD_WRITER VARCHAR2(15) NOT NULL,
  FREEBOARD_CONTENT LONG, 
  FREEBOARD_DATE DATE DEFAULT SYSDATE,
  ORIGINAL_IMAGENAME VARCHAR2(100),
  RENAME_IMAGENAME VARCHAR2(100),
  READ_COUNT NUMBER DEFAULT 0,
  BOARDTYPE varchar2(20) default '����',
  BOARD_NO number default 2,
  CONSTRAINT PK_FREEBOARDNO PRIMARY KEY(FREEBOARD_NO),
  CONSTRAINT FK_FREEBOARDWR FOREIGN KEY(FREEBOARD_WRITER) REFERENCES MEMBER(MEMBER_ID) ON DELETE CASCADE ON UPDATE CASCADE
);
ALTER TABLE freeboard ADD FOREIGN KEY(board_no) references board(board_no);
COMMENT ON COLUMN FREEBOARD.FREEBOARD_NO IS '�Խñ۹�ȣ';
COMMENT ON COLUMN FREEBOARD.FREEBOARD_TITLE IS '�Խñ�����';
COMMENT ON COLUMN FREEBOARD.FREEBOARD_WRITER IS '�Խñ��ۼ��ھ��̵�';
COMMENT ON COLUMN FREEBOARD.FREEBOARD_CONTENT IS '�Խñ۳���';
COMMENT ON COLUMN FREEBOARD.FREEBOARD_DATE IS '�Խñۿø���¥';
COMMENT ON COLUMN FREEBOARD.ORIGINAL_IMAGENAME IS '����÷���̹�����';
COMMENT ON COLUMN FREEBOARD.RENAME_IMAGENAME IS '�ٲ�÷���̹�����';
COMMENT ON COLUMN FREEBOARD.READ_COUNT IS '��ȸ��';
COMMENT ON COLUMN FREEBOARD.BOARDTYPE IS '�Խñ�����';
COMMENT ON COLUMN FREEBOARD.BOARD_NO IS '�Խñ۱��й�ȣ';

--------------------- ���� ������ -------------------------------
INSERT INTO FREEBOARD VALUES(1, '�ݰ�����', 'user22', '�ȳ��ϼ���. ó�����Խ��ϴ�. �ݰ����ϴ�. �ʹ�����;����.' ,DEFAULT, NULL, NULL, DEFAULT, '�ı�' , default);
INSERT INTO FREEBOARD VALUES(2, '���� ���� �� ����', 'user22', '��.....���̳� �ھ߰ڴ�' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default);
INSERT INTO FREEBOARD VALUES(3, '�Խ��� ������', 'user22', '�������� �ǰ� �̻���!' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default );
INSERT INTO FREEBOARD VALUES(4, '����?', 'user22', '�� ����' ,DEFAULT, NULL, NULL, DEFAULT, '�ı�' , default );
INSERT INTO FREEBOARD VALUES(5, '���� ������ ���', 'user22', '��ġ� �Ա�ȴ� ��쳪 ������.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default );
INSERT INTO FREEBOARD VALUES(6, '����', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT  , default);
INSERT INTO FREEBOARD VALUES(7, '����ٴ� �����Խ���1', 'user22', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, '�ı�' , default );
INSERT INTO FREEBOARD VALUES(8, '����ٴ� �����Խ���1', 'user22', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default );
INSERT INTO FREEBOARD VALUES(9, '����ٴ� �����Խ���1', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT, default);
INSERT INTO FREEBOARD VALUES(10, '����ٴ� �����Խ���1', 'user22', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, '�ı�', default );
INSERT INTO FREEBOARD VALUES(11, '����ٴ� �����Խ���1', 'user22', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT, default );
INSERT INTO FREEBOARD VALUES(12, '����ٴ� �����Խ���1', 'user22', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT, default );
INSERT INTO FREEBOARD VALUES(13, 'search �����Խ���1', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default );
INSERT INTO FREEBOARD VALUES(14, 'search �����Խ���1', 'user22', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, '�ı�', default  );
INSERT INTO FREEBOARD VALUES(15, 'search �����Խ���1', 'user22', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default );
INSERT INTO FREEBOARD VALUES(16, 'search �����Խ���1', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default);
INSERT INTO FREEBOARD VALUES(17, 'search �����Խ���1', 'user22', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, '�ı�', default );
INSERT INTO FREEBOARD VALUES(18, 'search �����Խ���1', 'user22', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, '�ı�', default );
INSERT INTO FREEBOARD VALUES(19, 'search �����Խ���1', 'user22', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, '�ı�', default );
INSERT INTO FREEBOARD VALUES(20, 'search �����Խ���1', 'admin', '����ٴ� ���񽺰� ���õǾ����ϴ�. ���� �̿����ּ���.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default);






DROP TABLE BOARD_COMMENT CASCADE CONSTRAINTS;
CREATE TABLE BOARD_COMMENT 
(
  COMMENT_NUM NUMBER NOT NULL,
  COMMENT_BOARD_NUM NUMBER NOT NULL,
  COMMENT_ID VARCHAR2(15),
  COMMENT_DATE DATE default sysdate,
  COMMENT_CONTENT VARCHAR2(1000) NOT NULL,
  CONSTRAINT PK_comment PRIMARY KEY(COMMENT_NUM),
  CONSTRAINT FK_comment FOREIGN KEY(COMMENT_BOARD_NUM) REFERENCES FREEBOARD(FREEBOARD_NO)  on delete cascade
);

--------------------- ���� ������ -------------------------------
insert into BOARD_COMMENT values 	(1, 1, 'user11', sysdate, 'ù��°����Դϴ�.');
insert into BOARD_COMMENT values 	(2, 20, 'user11', sysdate, '�ι�°����Դϴ�.');






DROP TABLE NOTICE_COMMENT CASCADE CONSTRAINTS;
CREATE TABLE NOTICE_COMMENT 
(
  COMMENT_NUM NUMBER NOT NULL,
  COMMENT_NOTICE_NUM NUMBER NOT NULL,
  COMMENT_ID VARCHAR2(15),
  COMMENT_DATE DATE default sysdate,
  COMMENT_CONTENT VARCHAR2(1000) NOT NULL,
  CONSTRAINT PK_NOTICE_comment PRIMARY KEY(COMMENT_NUM),
  CONSTRAINT FK_NOTICE_comment FOREIGN KEY(COMMENT_NOTICE_NUM) REFERENCES NOTICE(NOTICE_NO)  on delete cascade
);

--------------------- ���� ������ -------------------------------
insert into NOTICE_COMMENT values 	(1, 1, 'user11', sysdate, 'ù��°����Դϴ�.');






commit;