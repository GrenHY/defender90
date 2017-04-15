select * from emp;

CREATE TABLE EMP(
  ID			NUMBER(4) CONSTRAINT EMP_ID_PK PRIMARY KEY,
  NAME		VARCHAR(50)  NOT NULL,
  AGE		NUMBER(11),
  SALARY		NUMBER(7,2),
  MARRY 		CHAR(1),
  BIRTHDAY 	DATE,
  LAST_LOGIN_TIME	DATE
  );

insert into emp 
values(1,'����',25,6000.00,'N',null,null);
insert into emp 
values(2,'����',26,7000.00,'N',null,null);
insert into emp 
values(3,'����',27,8000.00,'N',null,null);
commit;


