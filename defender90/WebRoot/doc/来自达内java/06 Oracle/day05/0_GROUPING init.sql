/***********高级分组统计初始化数据*************/
/************准备存储过程****************/
--使用orale的存储过程实现table的drop if exists的效果
create or replace procedure proc_dropifexists(p_table in varchar2) 
	is v_count number(10);   
begin   
   select count(*)   
   into v_count   
   from user_tables 
   where table_name = upper(p_table);
   if v_count > 0 then   
      execute immediate 'drop table ' || p_table ||' cascade constraint PURGE'; 
   end if;   
end proc_dropifexists;
/
/*********建表***********/
exec proc_dropifexists('sales_你名字全拼');
CREATE TABLE sales_你名字全拼 (
  orderdate   date,
  sales_value NUMBER(10,2) NOT NULL
);
/***********初始化数据*************/
INSERT INTO sales_你名字全拼
SELECT lpad(TRUNC(DBMS_RANDOM.value(1, 29)),2,'0')||'-'||
                          TRUNC(DBMS_RANDOM.value(1, 13))||'月'
                          ||'-'||TRUNC(DBMS_RANDOM.value(10, 12)),
       ROUND(DBMS_RANDOM.value(1, 100), 2) AS sales_value
FROM   dual
CONNECT BY level <= 1000;
commit;
