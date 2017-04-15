package com.tarena.dao;

import com.tarena.entity.Admin;

public class AdminDaoImpl implements AdminDao {

	/* 
	 * 假设当前管理员表中只有一条数据，其
	 * admin_code=caocao
	 */
	@Override
	public Admin findByCode(String adminCode) {
		if(adminCode == null)
			return null;
		//模拟查询数据库
		if(adminCode.equals("caocao")) {
			Admin a = new Admin();
			a.setAdmin_id(5000);
			a.setAdmin_code("caocao");
			a.setPassword("123456");
			a.setName("曹操");
			a.setEmail("caocao@qq.com");
			a.setTelephone("110");
			return a;
		} else {
			return null;
		}
	}

}
