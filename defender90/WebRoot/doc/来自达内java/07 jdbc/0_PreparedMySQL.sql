use test;

/******dept_*******/
drop table if exists dept_你名字全拼;
create table dept_你名字全拼(
  deptno int(4) primary key,
  dname varchar(20) not null,
  loc varchar(20)
);
insert into dept_你名字全拼 values(10,'ACCOUNTING','NEW YORK');
insert into dept_你名字全拼 values(20,'RESEARCH','DALLAS');
insert into dept_你名字全拼 values(30,'SALES','CHICAGO');
insert into dept_你名字全拼 values(40,'OPERATIONS','BOSTON');
commit;

/******emp_*******/
drop table if exists emp_你名字全拼;
create table emp_你名字全拼(
  id	int(4) primary key auto_increment,
  name	varchar(10) not null,
  job	varchar(9),
  manager int(4),
  hiredate timestamp default now(),
  salary double(7,2),
  comm double(7,2),
  deptno int(2)
);

insert into emp_你名字全拼 
values(7369,upper('smith'),upper('clerk'),7902,'1980-12-17',800,null,20);
insert into emp_你名字全拼 
values(7499,upper('allen'),upper('salesman'),7698,'1981-2-20',1600,300,30);
insert into emp_你名字全拼 
values(7521,upper('ward'),upper('salesman'),7698,'1981-2-22',1250,500,30);
insert into emp_你名字全拼 
values(7566,upper('jones'),upper('manager'),7839,'1981-4-2',2975,null,20);
insert into emp_你名字全拼 
values(7654,upper('martin'),upper('salesman'),7698,'1981-9-28',1250,1400,30);
insert into emp_你名字全拼 
values(7698,upper('blake'),upper('manager'),7839,'1981-5-1',2850,null,30);
insert into emp_你名字全拼 
values(7782,upper('clark'),upper('manager'),7839,'1981-6-9',2450,null,10);
insert into emp_你名字全拼 
values(7788,upper('scott'),upper('analyst'),7566,'1987-4-19',3000,null,20);
insert into emp_你名字全拼 
values(7839,upper('king'),upper('president'),null,'1981-11-17',5000,null,10);
insert into emp_你名字全拼 
values(7844,upper('turner'),upper('salesman'),7698,'1981-9-8',1500,0,30);
insert into emp_你名字全拼 
values(7876,upper('adams'),upper('clerk'),7788,'1987-5-23',1100,null,20);
insert into emp_你名字全拼 
values(7900,upper('james'),upper('clerk'),7698,'1981-12-3',950,null,30);
insert into emp_你名字全拼 
values(7902,upper('ford'),upper('analyst'),7566,'1981-12-3',3000,null,20);
insert into emp_你名字全拼 
values(7934,upper('miller'),upper('clerk'),7782,'1982-1-23',1300,null,10);
commit;

