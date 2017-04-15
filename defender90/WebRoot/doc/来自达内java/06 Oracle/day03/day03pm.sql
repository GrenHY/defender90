--回顾排序：
select id,name,salary,deptno from emp_zhangdong
order by salary desc;
--每个部门内部按工资降序排列
--先按部门排序，再部门排序的基础上对工资排序
--*后排序的结果不能违背先排序的结果*
select id,name,salary,deptno 
from emp_zhangdong
order by deptno,salary desc;

--max/min
--count/sum/avg
--个数   /求和/平均
--全公司最高工资
select min(hiredate) 最早入职
	  ,max(salary) 最高工资 
	  ,count(comm) 领奖金的人数
	  ,count(salary) 领工资的人数
	  ,sum(salary) 工资总额
	  ,sum(comm) 奖金总额
	  ,avg(salary) 平均工资
	  ,avg(nvl(comm,0)) 平均奖金(所有人平均)
from emp_zhangdong;
--*聚合函数不能和非聚合的列混搭*
--*聚合函数自动忽略null值*-->avg不应忽略null值
--*单独使用聚合函数，相当于对全表聚合*

--分组统计-->group by 列名
--每个部门的平均工资-->先分组-->结果：分几组，返回几个数
select deptno, avg(salary)
		     ,count(salary)
		     ,sum(salary) 
from emp_zhangdong
group by deptno;
--*聚合函数只能和分组中的列混搭*

--having：聚合函数专用的Where
--平均工资高于5000的部门
select deptno,avg(salary+nvl(comm,0)) 平均工资
from emp_zhangdong
where depno is not null
--where avg(salary)>5000
--比较符左侧，出现聚合函数，应放入Having中
group by deptno
having avg(salary+nvl(comm,0))>5000
--having和Group by无关先后
order by 平均工资 desc;

--*SQL顺序*:
--from-->where-->
--       group by-->having-->
--       select-->order by

--笛卡尔积
--左表的每一行都要和右表的每一行握手
--有效的握手只保留等值部分
select name,e.deptno,d.deptno,dname--2
from emp_zhangdong e,dept_zhangdong d--1
where e.deptno=d.deptno--3
-->from-->where
-->group by-->having
-->select-->order by
--每个员工来自哪个部门
select name,salary,dname,loc
from emp_zhangdong e join dept_zhangdong d
	on(e.deptno=d.deptno)
--面试：当发现要查询的数据来自多个表
-->先join成1个表
--Oracle官方建议优先选择关联查询

--默认的Join..on..是内连接-->只取等值部分
--所有员工所在部门，包含暂时没有部门的员工
--*只要包含不等值部分-->外连接*
--外连接：左left、右right、全full
select name,salary,dname,loc
from emp_zhangdong e left join dept_zhangdong d
	on(e.deptno=d.deptno)
--所有部门的员工信息，包含暂时没有员工的部门
select name,salary,dname,loc
from emp_zhangdong e right join dept_zhangdong d
	on(e.deptno=d.deptno)
--全连接-->左右两表都完整显示
select name,salary,dname,loc
from emp_zhangdong e full join dept_zhangdong d
	on(e.deptno=d.deptno)
	
--当主外键列名相同时
select name,salary,dname,loc
from emp_zhangdong e join dept_zhangdong d
    using(deptno)
    
    
    
    
