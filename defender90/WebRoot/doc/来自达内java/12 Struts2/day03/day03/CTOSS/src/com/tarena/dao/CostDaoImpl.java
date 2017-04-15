package com.tarena.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tarena.entity.Cost;

/**
 *	��ǰ�׶��Խ���Struts2����Ϊ��������DAO��ʵ��
 *	�������ˣ���������ֻ���ȼ򵥵�ģ��ʵ����DAO��
 *	������ѧϰ��Hibernate��������Hibernateʵ��
 *	��DAO��
 */
public class CostDaoImpl implements CostDao {

	@Override
	public List<Cost> findAll() {
		List<Cost> list = new ArrayList<Cost>();
		
		Cost c1 = new Cost();
		c1.setCost_id(1);
		c1.setName("50Ԫ�ײ�");
		c1.setBase_duration(50);
		c1.setBase_cost(5.0);
		c1.setUnit_cost(0.5);
		c1.setStatus("0");
		c1.setDescr("50Ԫ�ײ�");
		c1.setCreatime(new Timestamp(
			System.currentTimeMillis()));
		c1.setStartime(new Timestamp(
			System.currentTimeMillis()));
		c1.setCost_type("2");
		list.add(c1);
		
		Cost c2 = new Cost();
		c2.setCost_id(2);
		c2.setName("70Ԫ�ײ�");
		c2.setBase_duration(70);
		c2.setBase_cost(7.0);
		c2.setUnit_cost(0.7);
		c2.setStatus("0");
		c2.setDescr("70Ԫ�ײ�");
		c2.setCreatime(new Timestamp(
			System.currentTimeMillis()));
		c2.setStartime(new Timestamp(
			System.currentTimeMillis()));
		c2.setCost_type("2");
		list.add(c2);
		
		return list;
	}
	
	@Override
	public void delete(int id) {
		System.out.println(
			"ɾ��id="+id+"���ʷ�����.");
	}

}
