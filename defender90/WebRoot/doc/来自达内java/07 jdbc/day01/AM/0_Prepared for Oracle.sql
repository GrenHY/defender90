exec proc_dropifexists('emp_你名字全拼');
create table emp_你名字全拼(
  id	NUMBER(4,0),
  name	VARCHAR2(10),
  job	VARCHAR2(9),
  manager	NUMBER(4,0),
  hiredate DATE,
  salary	NUMBER(7,2),
  comm NUMBER(7,2),
  deptno NUMBER(2,0)
);

insert into emp_你名字全拼 
values(7369,upper('smith'),upper('clerk'),7902,to_date('1980/12/17','YYYY/MM/DD'),800,null,20);
insert into emp_你名字全拼
values(7499,upper('allen'),upper('salesman'),7698,to_date('1981/2/20','YYYY/MM/DD'),1600,300,30);
insert into emp_你名字全拼 
values(7521,upper('ward'),upper('salesman'),7698,to_date('1981/2/22','YYYY/MM/DD'),1250,500,30);
insert into emp_你名字全拼 
values(7566,upper('jones'),upper('manager'),7839,to_date('1981/4/2','YYYY/MM/DD'),2975,null,20);
insert into emp_你名字全拼 
values(7654,upper('martin'),upper('salesman'),7698,to_date('1981/9/28','YYYY/MM/DD'),1250,1400,30);
insert into emp_你名字全拼 
values(7698,upper('blake'),upper('manager'),7839,to_date('1981/5/1','YYYY/MM/DD'),2850,null,30);
insert into emp_你名字全拼 
values(7782,upper('clark'),upper('manager'),7839,to_date('1981/6/9','YYYY/MM/DD'),2450,null,10);
insert into emp_你名字全拼
values(7788,upper('scott'),upper('analyst'),7566,to_date('1987/4/19','YYYY/MM/DD'),3000,null,20);
insert into emp_你名字全拼 
values(7839,upper('king'),upper('president'),null,to_date('1981/11/17','YYYY/MM/DD'),5000,null,10);
insert into emp_你名字全拼 
values(7844,upper('turner'),upper('salesman'),7698,to_date('1981/9/8','YYYY/MM/DD'),1500,0,30);
insert into emp_你名字全拼 
values(7876,upper('adams'),upper('clerk'),7788,to_date('1987/5/23','YYYY/MM/DD'),1100,null,20);
insert into emp_你名字全拼 
values(7900,upper('james'),upper('clerk'),7698,to_date('1981/12/3','YYYY/MM/DD'),950,null,30);
insert into emp_你名字全拼 
values(7902,upper('ford'),upper('analyst'),7566,to_date('1981/12/3','YYYY/MM/DD'),3000,null,20);
insert into emp_你名字全拼
values(7934,upper('miller'),upper('clerk'),7782,to_date('1982/1/23','YYYY/MM/DD'),1300,null,10);
commit;

/******dept_*******/
exec proc_dropifexists('dept_你名字全拼');
create table dept_你名字全拼(
  deptno number(4) unique not null,
  dname varchar2(20) not null,
  loc varchar2(20) not null
);
insert into dept_你名字全拼 values(10,'ACCOUNTING','NEW YORK');
insert into dept_你名字全拼 values(20,'RESEARCH','DALLAS');
insert into dept_你名字全拼 values(30,'SALES','CHICAGO');
insert into dept_你名字全拼 values(40,'OPERATIONS','BOSTON');
commit;