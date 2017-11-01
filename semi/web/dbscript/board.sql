DROP TABLE board CASCADE CONSTRAINTS;
create table board (
board_no number PRIMARY KEY,
board_name varchar2(30)
);
COMMENT ON COLUMN board.board_no IS '게시판 종류 번호';
COMMENT ON COLUMN board.board_name IS '게시판 종류 이름';

--------------------- 샘플 데이터 -------------------------------
insert into board values(1,'재능기부');
insert into board values(2,'자유게시판');
insert into board values(3,'QnA');