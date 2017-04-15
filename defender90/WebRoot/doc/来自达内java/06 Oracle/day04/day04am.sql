--*复杂查询分步写*！
--When:需求中包含不确定
--和rose同职位的员工
--Step1:先查不确定：rose的职位？--PROGRAMMER
select job 
from emp_zhangdong 
where name='rose'--PROGRAMMER
--Step2：再拼接：where job='PROGRAMMER'
select id,name,job from emp_zhangdong
where job in (Step1SQL)

--工资高于全公司平均工资的员工
--Step1：全公司平均工资？
select avg(salary) from emp_zhangdong;
--4888
--Step2：where salary>?
select id,name,salary from emp_zhangdong
where salary>(Step1SQL);

--包含销售的部门 中的非销售员工
--Step1:包含销售的部门
select distinct deptno from emp_zhangdong
where job='SALESMAN'--10,20
--Step2:以上部门中非销售的员工
select id,name,job,deptno from emp_zhangdong
where job!='SALESMAN' 
	  and deptno in (Step1SQL)

--部门10中有人比部门20中所有人工资都低
--Step1:部门20中的最低工资
select min(salary) from emp_zhangdong
where deptno=20;--4000
--Step2:部门10中比最低工资小的
select id,name,salary from emp_zhangdong
where deptno=10 and salary<(Step1SQL)
--部门10中有人比部门20中所有人工资都高
--Step1：部门20中的最高工资？
select max(salary) from emp_zhangdong
where deptno=20;
--Step2:部门10中比最高工资还高的人
select id,name,salary from emp_zhangdong
where deptno=10 and salary>(Step1SQL)

--有员工的部门信息
--面试首选：--效率最高
select distinct deptno,dname
from emp_zhangdong e join dept_zhangdong
	using(deptno)
	--using中的列不要加别名

--Step1：确定哪些部门有员工
--11,20,10
--Step2:查询以上部门的信息
select deptno,dname,loc from dept_zhangdong
where deptno in (Step1SQL)

--Exist
select deptno,dname from dept_zhangdong d
where exists(select * from emp_zhangdong e
			  where e.deptno=d.deptno)

--最低薪水高于部门20最低薪水的部门
--不确定：部门20的最低薪水
select min(salary) from emp_zhangdong
where deptno=20 --4000
--*所有/每个部门*的*最低*薪水--group by
select deptno,min(salary) from emp_zhangdong
where deptno!=20 and deptno is not null
group by deptno
having min(salary)>(Step1SQL)

--薪水高于本部门平均薪水的员工
--不确定：每个部门的平均薪水--group by
select deptno,avg(salary) 平均工资 from emp_zhangdong
group by deptno;
--所有人的工资，部门--emp表和上表join成1张表
select id,name,salary,deptno,平均工资
from emp_zhangdong join (Step1表)
	using(deptno)
--添加比较条件
where salary>平均工资
--*from中的子查询永远先执行*

--查询员工信息，包含所在部门名
select id,name,deptno
 from emp_zhangdong
 
--课后作业
--姓名第二个字母是o的员工
select name from emp_zhangdong
where name like '_o%'
--where substr(name,2,1)='o'
--where instr(name,'o')=2
select deptno,max(salary) from emp_zhangdong
group by deptno

--比自己部门最高工资低的员工
select deptno,max(salary) 最高工资 
		  from emp_zhangdong
		  group by deptno
select name,salary,deptno,最高工资
from emp_zhangdong 
	join (  )
using(deptno)
where salary<最高工资

update emp_zhangdong set salary=5000
where id=1004;

--自连接：*不确定层级深度的管理结构*
--定义表：自身表中增加一列：保存每个实体的上级编号
--查询：自己join自己，必须用别名区分！
--找出比自己经理工资还高的员工
select 员工.id,员工.name,员工.salary
	  ,经理.name,经理.salary
from emp_zhangdong 员工 
	join emp_zhangdong 经理
	on(员工.manager=经理.id)
where 员工.salary>经理.salary

--每个部门的普通员工:
--manager不为空；不能在manager中出现过
--Step1：在manager中出现过的员工编号
select distinct manager from emp_zhangdong
where manager is not null--1001,1005,1006
--和manager不为空共同决定普通员工
select id,name
from emp_zhangdong
where manager is not null 
	  and id not in(Step1SQL)
--Step2:每个部门的平均工资
select deptno,avg(salary) 平均工资
from emp_zhangdong
where manager is not null 
	  and id not in(Step1SQL)
group by deptno
--Step3:emp join 平均工资临时表
select id,name,salary,deptno
from emp_zhangdong join (Step2表)
	using(deptno)
where salary>平均工资

--所有员工工资都>=4000的部门信息
--Step1:最低工资>=4000的部门
select deptno 
from emp_zhangdong
group by deptno
having min(salary)>=4000
--以上部门的信息
select deptno,dname from dept_zhangdong
where deptno in (Step1SQL)

--无主外键关系的关联
from emp e join taxgrade t
	on e.sal between t.min and t.max




