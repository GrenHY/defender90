--日期2字符串-->给别人看
select to_char(systimestamp,'yyyy"年"mm"月"dd"日" day am hh:mi:ss.')
from dual;
select name,birth from emp_zhangdong;

--字符串2日期-->自己用
--设置日期时，*两位年份要用RR*
--YY:当期日期的前两位简单拼接后两位：85-->2085
--RR:判断当前日期与年份后两位的关系：85-->1985;02-->2002
update emp_zhangdong 
set birth=to_date('850910','rrmmdd')
where name='马里奥';
--*日期的格式化仅是临时的，不会影响物理存储*
--想按自己的格式查询日期
select name,to_char(birth,'yyyy"年"mm"月"dd"日"')
from emp_zhangdong;

--last_day-->按月底计算日期的时候
--每个月最后三天停止报销，求每个月最后可报销的一天
--*天：日期可直接+-整数，单位是天*
select last_day(sysdate)-3 from dual;

--月：
--月份+-：add_months(日期,月数(可负))
--计算rose的试用期截止时间
select name
	,to_char(add_months(hiredate,3),'RR-MM-DD')
from emp_zhangdong
where id=1001;

--计算员工的年龄
--日期相减
--Step1:从身份证号中取生日字符串substr
--Step2：按自己的格式转化为日期to_date
--***Step3:当前日期-生日日期：
--         天数，不足一天/24小时换算为小数
--Step4:/365，再下取整
select name
	,floor((
		sysdate-to_date(
			substr(pid,7,8),'YYYYMMDD'
	 	)
	 )/365)-->从内往外写！
from emp_zhangdong
where id=1001;
--月份相减：months_between(sysdate,生日)：月数
select name,
	floor(months_between(
		sysdate,
		to_date(substr(pid,7,8),'YYYYMMDD')
	)/12)
from emp_zhangdong
where id=1001;

--年：月份的计算*/12变通实现

--next_day
select next_day(sysdate,6) from dual;

--取各分量的值：extract(单位 from 日期)
--*from后是Date类型，只能提年月日*
select extract(day from sysdate) 天,
	   extract(month from sysdate) 月,
	   extract(year from sysdate) 年
from dual;
--*取所有分量，只能使用timestamp*
select extract(day from systimestamp) 天,
	   extract(month from systimestamp) 月,
	   extract(year from systimestamp) 年,
	   extract(hour from systimestamp) 小时,
	   extract(minute from systimestamp) 分,
	   extract(second from systimestamp) 秒
from dual;

--如果系统对时间要求较高-->timestamp
alter table emp_zhangdong modify(
	hiredate timestamp default systimestamp
);
--获取所有人的入职月份
select name,extract(month from hiredate)
from emp_zhangdong;

--任意分量的加减:interval '数' 单位
select to_char(sysdate,'hh24:mi'),
to_char(sysdate+interval '1' hour
	,'hh24:mi')
from dual;

--任意分量提取：extract-->timestamp
--任意分量加减：天：+-整数
--           月：add_months/months_between
--           年：月份*/12变通实现
--           时、分、秒：+-interval

--空值函数：
--查询所有人的工资和奖金
select name,salary,comm from emp_zhangdong;
--查所有人的总工资
select name,salary+comm from emp_zhangdong;
--***null值不参与计算：null+number=null
-->和现实中的矛盾
--解决：把null替换为0-->*仅在显示时
--nvl(列名,替换值)
select name,salary,nvl(comm,0)
from emp_zhangdong;
--***不会影响物理数据
--nvl2(列名,不为空,为空)
select name,nvl2(comm,salary+comm,salary)
----------------------comm不为空     ,comm为空
from emp_zhangdong;
--有奖金显示有，无奖金显示无
select name,nvl2(comm,  '有'  ,'无'    )
------------------   comm不为空,comm为空
from emp_zhangdong;
select name,nvl(to_char(birth),'无')
--***替换值尽量和列类型一致
--解决：格式化列
from emp_zhangdong;







