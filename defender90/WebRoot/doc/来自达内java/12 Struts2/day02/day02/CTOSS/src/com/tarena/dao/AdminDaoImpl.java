package com.tarena.dao;

import com.tarena.entity.Admin;

public class AdminDaoImpl implements AdminDao {

	/* 
	 * ���赱ǰ����Ա����ֻ��һ�����ݣ���
	 * admin_code=caocao
	 */
	@Override
	public Admin findByCode(String adminCode) {
		if(adminCode == null)
			return null;
		//ģ���ѯ���ݿ�
		if(adminCode.equals("caocao")) {
			Admin a = new Admin();
			a.setAdmin_id(5000);
			a.setAdmin_code("caocao");
			a.setPassword("123456");
			a.setName("�ܲ�");
			a.setEmail("caocao@qq.com");
			a.setTelephone("110");
			return a;
		} else {
			return null;
		}
	}

}
