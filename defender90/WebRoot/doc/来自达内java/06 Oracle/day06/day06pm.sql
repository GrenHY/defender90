--create 对象类型 对象名
--drop 对象类型 对象名
--序列:取号机（自己取；只增，不重复）
create sequence seq_emp_zhangdong
start with 10001--从10001开始
increment by 2;--每次+2
--删除序列:
drop sequence seq_emp_zhangdong;

--取号:序列名.nextval-->1个数
select seq_emp_zhangdong.nextval 
from dual;--取过的号永远不可再用
--主要用途：插入主键值
insert into emp_zhangdong 
	  (id,name,salary,deptno)
values(seq_emp_zhangdong.nextval,'员工1',20000,11);
insert into emp_zhangdong 
	  (id,name,salary,deptno)
values(seq_emp_zhangdong.nextval,'员工2',20000,11);
insert into emp_zhangdong 
	  (id,name,salary,deptno)
values(seq_emp_zhangdong.nextval,'员工3',20000,11);
insert into emp_zhangdong 
	  (id,name,salary,deptno)
values(seq_emp_zhangdong.nextval,'员工4',20000,11);
insert into emp_zhangdong 
	  (id,name,salary,deptno)
values(seq_emp_zhangdong.nextval,'员工5',20000,11);
select id,name from emp_zhangdong;
--cycle(了解)
--minvalue   startwith            maxvalue
--10000------>10001(1)------------->12000
    <----------------------------------|
--currval：返回当前值

--索引：快速查找的机制
--索引本质：树
create index i_emp_name_zhangdong
on emp_zhangdong(salary,deptno);

select id,name,salary from emp_zhangdong
where salary>5000 and deptno=10;
--SQL Developer中'解释计划'
--Oracle，智能分析是否使用索引
--*如何合理使用索引*
--1.经常用于条件或排序的列
--2.主外键，主键自动建索引，只要给外键建索引
--3.频繁修改的表，不适合建索引
--	3.1--空间换时间：复制一张表专门查询，定期同步
--  3.2--定期rebuild:
alter index i_emp_name_zhangdong rebuild;
--4.不要在小表上建立索引--索引也占物理空间
--5.限制表上索引数量，删除作废的索引
drop index i_emp_name_zhangdong;
--唯一索引：建索引的列上不能包含重复值，但可以有Null
--        如果后续插入重复值，同样会检查
--多列索引：多列同时作为条件时，绝大多数情况下用索引
--        只用其中一列作为条件时，不一定使用索引

--约束：数据检查规则
--*不能与现有数据冲突*
--*约束名:当前用户schema范围内唯一*
--*同一类约束，不能加在同一列*
--唯一约束
alter table emp_zhangdong modify(
	id number(11)
);
alter table emp_zhangdong modify(
	--constraint 约束名 约束类别(列名)
	constraint uk_emp_pid_zhangdong unique(pid)
);
insert into emp_zhangdong(id,name,pid)
values(seq_emp_zhangdong.nextval,'','')
--重复--不重复--null

--删除约束:
--alter table 表名 drop constraint 约束名
alter table emp_zhangdong 
drop constraint uk_emp_pid_zhangdong

--判断重名
--   如果有重名：删除表（*同时自动删除了表中的约束*）
--create table
--alter table    add(
-- constraint 
--)

--create or replace view
--判断重名
--create sequence
--判断重名
--create index

--主键（概念）：每个表中唯一标示每一行的列
--唯一，非空：unique+not null
--主键约束：
alter table emp_zhangdong 
	drop constraint SYS_C0027265;
alter table emp_zhangdong add(
	constraint pk_emp_id_zhangdong
		primary key(id)
);







