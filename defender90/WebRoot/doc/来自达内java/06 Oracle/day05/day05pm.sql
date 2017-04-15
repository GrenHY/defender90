--排序函数+分组
--排序函数() over(partition by 分组的列
--				order by 排序的列)
--每个部门内排名--分组
select id,name,hiredate,deptno,
	row_number() over(
		partition by deptno 
		order by hiredate)
from emp_zhangdong
--每部门前两名有房？row_number()-->rank()

--*简化分页+排序*
select *
from (select id,name,salary,
		row_number() 
		    over(order by salary desc) 行号
	  from emp_zhangdong)
where 行号>4*(2-1) and 行号<=4*2--真
--真、假：直接用SQL分页——真；用框架、Java--假

--集合函数：
--部门10的员工
select id,name,salary,deptno from emp_zhangdong
where deptno=10
union all
--部门10工资的总和
select null,'小计：',sum(salary),null from emp_zhangdong
where deptno=10
union all
select id,name,salary,deptno from emp_zhangdong
where deptno=20
union all
select null,'小计：',sum(salary),null from emp_zhangdong
where deptno=20
union all
select null,'总计：',sum(salary),null from emp_zhangdong
where deptno in (10,20)

--union:去重复，自动按首列排序
--如果结果中肯定没有重复行，首选union all
--所有程序员
select id,name,salary,job,deptno from emp_zhangdong
where job='PROGRAMMER'
minus
--工资>=5000
select id,name,salary,job,deptno from emp_zhangdong
where salary>=5000
order by salary desc
--order by只能加在最后一行
--列名只使用第一个查询的列名

--交集：intersect：去重复，自动排序
--减:minus:上表去掉交集，剩下的行， 去重复，自动排序

--一个店铺每笔交易的日期和交易额
select orderdate,sales_value
from sales_zhangdong
order by orderdate
--(每年)每个月的销售额--group by 年,月
--Step1:年月日打散
select extract(year from orderdate) 年,
	   extract(month from orderdate) 月,
	   extract(day from orderdate) 日,
	   sales_value
from sales_zhangdong;
--Step2:
select 年,月,日,sum(sales_value)
from (Step1表)
where 月<4 and 日<4
group by 年,rollup(月,日)
--每天先统计，每月再统计，最后全年统计
order by 年,月,日
	 
	 
--cube:多维统计
select 年,月,日,sum(sales_value)
from (select extract(year from orderdate) 年,
	   extract(month from orderdate) 月,
	   extract(day from orderdate) 日,
	   sales_value
	  from sales_zhangdong)
where 月<3 and 日<3
group by 年,grouping sets(月,日)
order by 年,月,日






  
