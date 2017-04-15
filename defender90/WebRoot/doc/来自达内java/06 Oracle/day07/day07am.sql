--account表
--判断重名
exec proc_dropifexists('account_zhangdong');
create table account_zhangdong(
	account_id number(11),
	login_name varchar2(30) not null,
	login_pwd varchar2(30) not null,
	status char not null,--1-开通，0-暂停，2-删除
	create_date date default sysdate,
	real_name varchar2(30) not null,
	pid char(18) not null
);
alter table account_zhangdong add(
--constraint 约束名 约束类型(列)
	constraint pk_account_id_zhangdong
		primary key(account_id),
	constraint uk_account_pid_zhangdong
		unique(pid),
--检查：业务规则和格式
--身份证号：18位数字/17位数字x
--^\d{18}|(\d{17}x)$
--检查约束：constraint 约束名 check(判断条件)
--*检查约束对空值不验证--check+not null*
--regexp_like(列名,'正则表达式')--返回true/false
	constraint ck_account_pid_zhangdong
	check(regexp_like(pid,'^\d{18}|(\d{17}x)$')),
--status，必须在0,1,2之中
	constraint ck_account_status_zhangdong
	check(status in ('0','1','2'))
);

--host表
exec proc_dropifexists('host_zhangdong');
create table host_zhangdong(
	host_ip varchar2(15),
	name varchar2(50) not null,
	loc varchar2(100)
);
alter table host_zhangdong add(
	constraint pk_host_ip_zhangdong
		primary key(host_ip)
);

--cost表
exec proc_dropifexists('cost_zhangdong');
create table cost_zhangdong(
	cost_id number(4),
	name varchar2(50) not null,
	cost_type char not null,--1.包月;2.套餐;3.计时
	descr varchar2(200)
);
alter table cost_zhangdong add(
	constraint pk_cost_id_zhangdong
		primary key(cost_id),
	constraint ck_cost_type_zhangdong
		check(cost_type in (1,2,3))
);

--service表
exec proc_dropifexists('service_zhangdong');
create table service_zhangdong(
	service_id number(11),
--ER图中有几个箭头，就要有几个外键
--外键的名称和类型必须和主键表的主键一致
	account_id number(11) not null,
	host_ip varchar2(15) not null,
	cost_id number(4) not null,
	os_username varchar2(8) not null,
	os_pwd varchar2(30) not null,
	create_date date default sysdate,
	status char not null --0:开通;1:暂停;2：删除
);
alter table service_zhangdong add(
	constraint pk_service_id_zhangdong
		primary key(service_id),
--外键：外键值必须包含在主键表的主键列中
--*外键列的值可以为null*
--外键约束：(可用可不用)
--如果不用：如何屏蔽主键中没有的值？--用程序先验证再插入
--constraint 约束名 foreign key(外键列)
--  references 主键表(主键列)
constraint fk_account_id_zhangdong foreign key(account_id)
	references account_zhangdong(account_id),
constraint fk_host_ip_zhangdong foreign key(host_ip)
	references host_zhangdong(host_ip),
constraint fk_cost_id_zhangdong foreign key(cost_id)
	references cost_zhangdong(cost_id),
constraint ck_service_status_zhangdong check(status in('0','1','2')),
--联合唯一约束：单列都可以重复，但多列的组合不能重复
--constraint 约束名 unique(列1,列2,。。。)
	constraint uk_ip_name_zhangdong
		unique(host_ip,os_username)
);








