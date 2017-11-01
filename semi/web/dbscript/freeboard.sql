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
  CONSTRAINT FK_FREEBOARDWR FOREIGN KEY(FREEBOARD_WRITER) REFERENCES MEMBER(MEMBER_ID) 
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