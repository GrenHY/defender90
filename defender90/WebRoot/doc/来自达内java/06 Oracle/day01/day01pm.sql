select systimestamp from dual;
--1.创建表
create table mynum_zhangdong(
	id number(5),--25210 --2521 --2.5
    sal number(6,2)
    --|xxxx.xx
	--1000.995 -->1001.00
	--9999.995 -->X
);
create table mychar_zhangdong(
	name varchar2(20),
	--“张三丰”
	telephone varchar2(13), 
	mobile char(11),
	qq varchar2(15),
	pid char(18)
);

select sysdate from dual;

create table mydate_zhangdong(
	birth date,
	hiredate date
);

create table emp_zhangdong(
	id number(11),
	name varchar2(20),
	birth date,
	gender char,--F M
	salary number(7,2),
	job varchar2(30),
	deptno number(4)
);
------------------------- add/modify/drop
alter table emp_zhangdong modify(
	gender char default 'M',
	salary number(7,2) default 4500
);
alter table emp_zhangdong add(
	hiredate date default sysdate
);
alter table emp_zhangdong drop(deptno);
alter table emp_zhangdong modify(
	name varchar2(20) null
);

--insert into 表名 (列名1,列名2,列名3,...)
--          values(值1  ,值2  ,值3 ,...)
insert into emp_zhangdong(id,name,birth,job)
values(1,'奔波儿灞','29-6月-82','Manager');
insert into emp_zhangdong(id,name,birth,job)
values(2,'灞波儿奔','26-12月-83','Programmer');
insert into emp_zhangdong(id,name,gender,birth,job)
values(3,'奔波儿妹','F','10-11月-85','SalesMan');
--三个一致：个数，类型，顺序

--update 表名 set 列名1=值1,列名2=值2...
--where 条件
update emp_zhangdong set salary=12000
where id=3;
--回滚上次Commit之后，还未提交的数据
rollback;

delete from emp_zhangdong where salary>9000;

select * from emp_zhangdong;

drop table emp_zhangdong purge;
select * from recyclebin;
purge recyclebing;



