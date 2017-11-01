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
  BOARDTYPE varchar2(20) default '자유',
  BOARD_NO number default 2,
  CONSTRAINT PK_FREEBOARDNO PRIMARY KEY(FREEBOARD_NO),
  CONSTRAINT FK_FREEBOARDWR FOREIGN KEY(FREEBOARD_WRITER) REFERENCES MEMBER(MEMBER_ID) 
);
ALTER TABLE freeboard ADD FOREIGN KEY(board_no) references board(board_no);
COMMENT ON COLUMN FREEBOARD.FREEBOARD_NO IS '게시글번호';
COMMENT ON COLUMN FREEBOARD.FREEBOARD_TITLE IS '게시글제목';
COMMENT ON COLUMN FREEBOARD.FREEBOARD_WRITER IS '게시글작성자아이디';
COMMENT ON COLUMN FREEBOARD.FREEBOARD_CONTENT IS '게시글내용';
COMMENT ON COLUMN FREEBOARD.FREEBOARD_DATE IS '게시글올린날짜';
COMMENT ON COLUMN FREEBOARD.ORIGINAL_IMAGENAME IS '원래첨부이미지명';
COMMENT ON COLUMN FREEBOARD.RENAME_IMAGENAME IS '바뀐첨부이미지명';
COMMENT ON COLUMN FREEBOARD.READ_COUNT IS '조회수';
COMMENT ON COLUMN FREEBOARD.BOARDTYPE IS '게시글종류';
COMMENT ON COLUMN FREEBOARD.BOARD_NO IS '게시글구분번호';

--------------------- 샘플 데이터 -------------------------------
INSERT INTO FREEBOARD VALUES(1, '반가워요', 'user22', '안녕하세요. 처음들어왔습니다. 반갑습니다. 너무오고싶었어요.' ,DEFAULT, NULL, NULL, DEFAULT, '후기' , default);
INSERT INTO FREEBOARD VALUES(2, '오늘 점심 뭐 먹지', 'user22', '하.....잠이나 자야겠다' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default);
INSERT INTO FREEBOARD VALUES(3, '게시판 디자인', 'user22', '디자인이 되게 이뻐요!' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default );
INSERT INTO FREEBOARD VALUES(4, '동의?', 'user22', '어 보감' ,DEFAULT, NULL, NULL, DEFAULT, '후기' , default );
INSERT INTO FREEBOARD VALUES(5, '오늘 저녁은 모냐', 'user22', '김치찌개 먹기싫다 사우나 갈란다.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default );
INSERT INTO FREEBOARD VALUES(6, '가을', 'admin', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT  , default);
INSERT INTO FREEBOARD VALUES(7, '다재다능 자유게시판1', 'user22', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, '후기' , default );
INSERT INTO FREEBOARD VALUES(8, '다재다능 자유게시판1', 'user22', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default );
INSERT INTO FREEBOARD VALUES(9, '다재다능 자유게시판1', 'admin', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT, default);
INSERT INTO FREEBOARD VALUES(10, '다재다능 자유게시판1', 'user22', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, '후기', default );
INSERT INTO FREEBOARD VALUES(11, '다재다능 자유게시판1', 'user22', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT, default );
INSERT INTO FREEBOARD VALUES(12, '다재다능 자유게시판1', 'user22', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT, default );
INSERT INTO FREEBOARD VALUES(13, 'search 자유게시판1', 'admin', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default );
INSERT INTO FREEBOARD VALUES(14, 'search 자유게시판1', 'user22', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, '후기', default  );
INSERT INTO FREEBOARD VALUES(15, 'search 자유게시판1', 'user22', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default );
INSERT INTO FREEBOARD VALUES(16, 'search 자유게시판1', 'admin', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default);
INSERT INTO FREEBOARD VALUES(17, 'search 자유게시판1', 'user22', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, '후기', default );
INSERT INTO FREEBOARD VALUES(18, 'search 자유게시판1', 'user22', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, '후기', default );
INSERT INTO FREEBOARD VALUES(19, 'search 자유게시판1', 'user22', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, '후기', default );
INSERT INTO FREEBOARD VALUES(20, 'search 자유게시판1', 'admin', '다재다능 서비스가 개시되었습니다. 많이 이용해주세요.' ,DEFAULT, NULL, NULL, DEFAULT, DEFAULT , default);