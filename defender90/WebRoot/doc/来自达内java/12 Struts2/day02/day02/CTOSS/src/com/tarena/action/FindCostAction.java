package com.tarena.action;

import java.util.List;

import com.tarena.dao.CostDao;
import com.tarena.dao.CostDaoImpl;
import com.tarena.entity.Cost;

public class FindCostAction {
	
	private List<Cost> costs;
	
	public String execute() {
		//由于当前没有使用Spring框架，无法注入DAO，
		//需要自己实例化DAO。
		CostDao dao = new CostDaoImpl();
		//调用DAO查询全部的资费数据，并将其赋值
		//给成员变量，在方法执行结束时，Struts2
		//会自动将此变量的值传给页面。
		costs = dao.findAll();
		return "success";
	}

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}

}
