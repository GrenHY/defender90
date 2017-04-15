--课后练习
--与rose同部门的其他员工--一张表
--Step1不确定:
select deptno from emp_zhangdong
where name='rose';--10
--Step2：
select id,name,deptno from emp_zhangdong
where name!='rose' and
	deptno in (Step1查询)
--比部门20人数多的部门信息--2张
--join：每个部门的人数和部门
--Step1：每个部门的人数
select deptno,count(*) 人数 from emp_zhangdong
group by deptno--表
--Step2：
select deptno,dname,人数
from dept_zhangdong 
	join (select deptno,count(*) 人数 from emp_zhangdong
		group by deptno)
	using(deptno)
--Step3：部门20的人数
select count(*) from emp_zhangdong
where deptno=20--3
--Step4:
select deptno,dname,人数
from dept_zhangdong 
	join (select deptno,count(*) 人数 
	      from emp_zhangdong
		  group by deptno)
	using(deptno)
where 人数>(select count(*) 
		   from emp_zhangdong
		   where deptno=20)
		   
--简化
select deptno,dname,count(*)
from emp_zhangdong join dept_zhangdong
     using(deptno)
group by deptno,dname 
--dname不影响count的结果，只为有资格出现在Select中
having count(*)>(select count(*) 
				 from emp_zhangdong
	             where deptno=20)

--视图：部门10的员工
create or replace view v_dept10_zhangdong
--视图名：当前用户schema范围内必须唯一
as
select id,name,salary,deptno 
from emp_zhangdong
where deptno=10
--with check option
--DML操作不能违背where条件的限制
with read only
--干脆不能DML

--使用视图：同普通表
--*查询时范围只局限在视图的行列之内*
select salary from v_dept10_zhangdong

--限制数据访问
create user u1 identified by 密码
grant resource,connect to u1
grant select on 其他用户名.视图名 to u1
select * from 其他用户名.视图名 --能查到
select * from 其他用户名.表名 --不能查到

--视图的insert--*只有简单视图才可DML*
insert into v_dept10_zhangdong 
values(1100,'饭老师',20000,10)
select * from v_dept10_zhangdong
insert into v_dept10_zhangdong 
values(1200,'红衣女孩',20000,20)

--系统视图
select object_name,object_type,created
from user_objects
where object_name like '%_ZHANGDONG';
select view_name,text from user_views
where view_name like '%_ZHANGDONG';
select table_name from user_tables
where table_name like '%_ZHANGDONG';

--删除视图:
drop view v_dept10_zhangdong;
select * from recyclebin;

--总结：
--什么是视图：一条SQL语句，起名字
--作用：简化复杂查询；限制数据访问
--视图不占用物理空间；不保存实际数据
--视图不能修改(alter)，只能替换
--查询：不能超出视图的行列范围
--能不能DML：简单视图可以DML，视图不建议DML
--        ，可使用with read only防止一切DML
--系统视图：user_objects;user_views;user_tables;
