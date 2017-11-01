DROP TABLE DONATE CASCADE CONSTRAINTS;
CREATE TABLE DONATE(
  DONATION_NO VARCHAR2(13) PRIMARY KEY,
  MEMBER_ID VARCHAR2(15) NOT NULL,
  DONATION NUMBER NOT NULL,
  DONATION_DATE DATE DEFAULT SYSDATE NOT NULL
);
ALTER TABLE DONATE
ADD CONSTRAINT FK_MEMBER_ID FOREIGN KEY(MEMBER_ID)
REFERENCES MEMBER(MEMBER_ID);
COMMENT ON COLUMN DONATE.DONATION_NO IS '기부 번호';
COMMENT ON COLUMN DONATE.MEMBER_ID IS '아이디';
COMMENT ON COLUMN DONATE.DONATION IS '기부금';
COMMENT ON COLUMN DONATE.DONATION_DATE IS '기부일자';

--------------------- 샘플 데이터 -------------------------------
insert into donate values(1,'user11',10000,default);
insert into donate values(2,'user22',10000,default);
insert into donate values(3,'user22',10000,default);
insert into donate values(4,'user44',10000,default);
insert into donate values(5,'user33',10000,default);
insert into donate values(6,'user55',10000,default);
insert into donate values(7,'user11',10000,default);
insert into donate values(8,'user77',10000,default);
insert into donate values(9,'user22',10000,default);
insert into donate values(10,'user11',10000,default);
insert into donate values(11,'user22',10000,default);
insert into donate values(12,'user22',10000,default);
insert into donate values(13,'user44',10000,default);
insert into donate values(14,'user55',10000,default);
insert into donate values(15,'user44',10000,default);
insert into donate values(16,'user33',10000,default);
insert into donate values(17,'user77',10000,default);
insert into donate values(18,'user99',10000,default);
insert into donate values(19,'user55',10000,default);
insert into donate values(20,'user22',10000,default);
insert into donate values(21,'user11',10000,default);
insert into donate values(22,'user11',10000,default);
insert into donate values(23,'user22',10000,default);
insert into donate values(24,'user66',10000,default);
insert into donate values(25,'user33',10000,default);
insert into donate values(26,'user33',10000,default);
insert into donate values(27,'user22',10000,default);
insert into donate values(28,'user77',10000,default);