package com.tarena.action;

import com.tarena.dao.CostDao;
import com.tarena.dao.CostDaoImpl;

public class DeleteCostAction {

	private int id;
	
	public String delete() {
		CostDao dao = new CostDaoImpl();
		dao.delete(id);
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
