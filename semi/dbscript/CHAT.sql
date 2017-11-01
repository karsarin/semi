DROP TABLE CHAT CASCADE CONSTRAINTS;

CREATE TABLE CHAT (
  SENDER VARCHAR2(15) UNIQUE,
  RECIVER VARCHAR2(15) UNIQUE
);

--------------------- ?깦?뵆 ?뜲?씠?꽣 -------------------------------

COMMIT;