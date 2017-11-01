-- SUGGEST 테이블

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
CONSTRAINT FK_SUGGESTWR FOREIGN KEY (SUGGEST_WRITER) REFERENCES MEMBER (MEMBER_ID),
CONSTRAINT FK_SUGGESTRE FOREIGN KEY (SUGGEST_RECIVE) REFERENCES MEMBER (MEMBER_ID)
);

COMMENT ON COLUMN SUGGEST.SUGGEST_NO IS '요구사항 번호';
COMMENT ON COLUMN SUGGEST.SUGGEST_TITLE IS '요구사항 제목';
COMMENT ON COLUMN SUGGEST.SUGGEST_REQUEST_PREOID IS '요구 기간';
COMMENT ON COLUMN SUGGEST.SUGGEST_CONTENT IS '요구사항 내용';
COMMENT ON COLUMN SUGGEST.SUGGEST_DATE IS '요구사항 작성일자';
COMMENT ON COLUMN SUGGEST.SUGGEST_ORIGINAL_FILENAME IS '요구사항 원래 첨부파일명';
COMMENT ON COLUMN SUGGEST.SUGGEST_RENAME_FILENAME IS '요구사항 바뀐 첨부파일명';
COMMENT ON COLUMN SUGGEST.SUGGEST_WRITER IS '요구사항 보내는 유저';
COMMENT ON COLUMN SUGGEST.SUGGEST_RECIVE IS '요구사항 받는 유저';

COMMIT;

INSERT INTO SUGGEST VALUES (1, '쪽지 테스트', '11월 3일', '성공', DEFAULT, NULL, NULL, 'user77', 'user22');