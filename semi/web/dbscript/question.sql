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

COMMENT ON COLUMN question.question_NUM IS '게시글번호';
COMMENT ON COLUMN question.question_WRITER IS '게시글작성자';
COMMENT ON COLUMN question.question_TITLE IS '게시글제목';
COMMENT ON COLUMN question.question_CONTENT IS '게시글내용';
COMMENT ON COLUMN question.question_DATE IS '게시글날짜';
COMMENT ON COLUMN question.question_ORIGINAL_FILENAME IS '원래이미지파일명';
COMMENT ON COLUMN question.question_RENAME_FILENAME IS '바뀐이미지파일명';
COMMENT ON COLUMN question.question_LEVEL IS '댓글레벨';
COMMENT ON COLUMN question.question_REF IS '참조게시글번호';
COMMENT ON COLUMN question.question_REPLY_REF IS '참조댓글';
COMMENT ON COLUMN question.question_REPLY_SEQ IS '댓글시퀀스';
COMMENT ON COLUMN question.question_READCOUNT IS '조회수';
COMMENT ON COLUMN question.answer IS '답변여부';
COMMENT ON COLUMN question.board_no IS '게시판구분번호';

--------------------- 샘플 데이터 -------------------------------
INSERT INTO question VALUES(1,'게시글1','user22','본문 내용입니다',NULL,NULL,SYSDATE,0,0,1,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(2,'게시글2','user22','본문 내용입니다',NULL,NULL,SYSDATE,0,0,2,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(3,'게시글3','user22','본문 내용입니다',NULL,NULL,SYSDATE,0,0,3,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(4,'게시글4','user11','본문 내용입니다',NULL,NULL,SYSDATE,0,0,4,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(5,'게시글5','user22','본문 내용입니다',NULL,NULL,SYSDATE,0,0,5,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(6,'게시글6','user22','본문 내용입니다',NULL,NULL,SYSDATE,0,0,6,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(7,'게시글7','user11','본문 내용입니다',NULL,NULL,SYSDATE,0,0,7,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(8,'게시글8','user22','본문 내용입니다',NULL,NULL,SYSDATE,0,0,8,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(9,'게시글9','user11','본문 내용입니다',NULL,NULL,SYSDATE,0,0,9,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(10,'게시글10','user22','본문 내용입니다',NULL,NULL,SYSDATE,0,0,10,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(11,'게시글11','user22','본문 내용입니다',NULL,NULL,SYSDATE,0,0,11,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(12,'게시글12','user22','본문 내용입니다',NULL,NULL,SYSDATE,0,0,12,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(13,'게시글13','user11','본문 내용입니다',NULL,NULL,SYSDATE,0,0,13,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(14,'게시글14','user22','본문 내용입니다',NULL,NULL,SYSDATE,0,0,14,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(15,'게시글15','user11','본문 내용입니다',NULL,NULL,SYSDATE,0,0,15,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(16,'게시글16','user22','본문 내용입니다',NULL,NULL,SYSDATE,0,0,16,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(17,'게시글17','user11','본문 내용입니다',NULL,NULL,SYSDATE,0,0,17,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(18,'게시글18','user22','본문 내용입니다',NULL,NULL,SYSDATE,0,0,18,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(19,'게시글19','user11','본문 내용입니다',NULL,NULL,SYSDATE,0,0,19,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(20,'게시글20','user11','본문 내용입니다',NULL,NULL,SYSDATE,0,0,20,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(21,'게시글21','user11','본문 내용입니다',NULL,NULL,SYSDATE,0,0,21,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(22,'게시글22','user11','본문 내용입니다',NULL,NULL,SYSDATE,0,0,22,NULL,0,DEFAULT,DEFAULT);
INSERT INTO question VALUES(23,'게시글23','user11','본문 내용입니다',NULL,NULL,SYSDATE,0,0,23,NULL,0,DEFAULT,DEFAULT);

COMMIT;