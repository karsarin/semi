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