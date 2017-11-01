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

COMMIT;