package com.tarena.action;

import java.util.List;

import com.tarena.dao.CostDao;
import com.tarena.dao.CostDaoImpl;
import com.tarena.entity.Cost;

public class FindCostAction {
	
	private List<Cost> costs;
	
	public String execute() {
		//���ڵ�ǰû��ʹ��Spring��ܣ��޷�ע��DAO��
		//��Ҫ�Լ�ʵ����DAO��
		CostDao dao = new CostDaoImpl();
		//����DAO��ѯȫ�����ʷ����ݣ������丳ֵ
		//����Ա�������ڷ���ִ�н���ʱ��Struts2
		//���Զ����˱�����ֵ����ҳ�档
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
