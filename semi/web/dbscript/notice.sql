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
  CONSTRAINT FK_NOTICEWR FOREIGN KEY(NOTICE_WRITER) REFERENCES MEMBER(MEMBER_ID) 
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