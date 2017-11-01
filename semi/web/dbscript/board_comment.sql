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