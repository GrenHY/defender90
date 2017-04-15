drop table t_user;
create table t_user(
	id number(7,0),
	name varchar2(20),
	pwd varchar2(10),
	phone varchar2(20),
	PRIMARY KEY (id)
);
drop sequence seq_t_user;
create sequence seq_t_user;
insert into t_user (id, name, pwd, phone)
  values (seq_t_user.nextval,'tom','123','110');
insert into t_user (id, name, pwd, phone)
  values (seq_t_user.nextval,'jerry','123','110');
insert into t_user (id, name, pwd, phone)
  values (seq_t_user.nextval,'andy','123','110');
  


drop table t_emp;
create table t_emp(
	empno number(7,0),
	ename varchar2(20),
	job varchar2(10),
	mgr number(7,0) ,
	hiredate date,
	sal number(7,2),
	comm  number(7,2),
	deptno int,
	PRIMARY KEY (empno)
);

drop SEQUENCE SEQ_EMP;
CREATE SEQUENCE SEQ_EMP;

alter session set nls_date_format = 'yyyy-mm-dd';

Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'SMITH','CLERK',3,'1980-5-12',800,null,20);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'ALLEN','SALESMAN',3,'1981-6-3',1600,300,30);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'WARD','SALESMAN',4,'1990-3-15',1250,500,30);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'JONES','MANAGER',5,'1985-4-8',2975,null,20);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'MARTIN','SALESMAN',7,'1986-3-8',1250,1400,30);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'BLAKE','MANAGER',9,'1989-6-1',2850,null,30);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'CLARK','MANAGER',9,'1995-10-1',2450,null,10);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'SCOTT','ANALYST',9,'1993-5-1',3000,null,20);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'KING','PRESIDENT',null,'1988-8-8',5000,null,10);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'TURNER','SALESMAN',5,'1983-2-1',1500,0,30);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'ADAMS','CLERK',5,'1992-7-3',1100,null,20);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'JAMES','CLERK',1,'1996-9-10',950,null,30);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'FORD','ANALYST',1,'1993-1-1',3000,null,20);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (SEQ_EMP.nextval,'MILLER','CLERK',3,'1983-10-9',1300,null,10);

-- select SEQ_EMP.nextval as empno from dual;
