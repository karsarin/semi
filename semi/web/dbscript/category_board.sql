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
ALTER TABLE CATEGORY_BOARD ADD CONSTRAINT FK_CATEGORYGROUP FOREIGN KEY (CATEGORY_GROUP) REFERENCES CATEGORY_GROUP(GROUP_NO);
ALTER TABLE CATEGORY_BOARD ADD CONSTRAINT FK_USERID FOREIGN KEY (USER_ID) REFERENCES MEMBER(member_id);
COMMENT ON COLUMN CATEGORY_BOARD.CATEGORY_NO IS 'ī�װ����Խñ۹�ȣ';
COMMENT ON COLUMN CATEGORY_BOARD.USER_ID IS '���̵�';
COMMENT ON COLUMN CATEGORY_BOARD.CATEGORY_GROUP IS 'ī�װ����з�';
COMMENT ON COLUMN CATEGORY_BOARD.CATEGORY_TITLE IS 'ī�װ����Խñ��̸�';
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