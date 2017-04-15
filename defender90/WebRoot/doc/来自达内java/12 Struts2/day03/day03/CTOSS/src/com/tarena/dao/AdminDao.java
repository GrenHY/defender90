package com.tarena.dao;

import com.tarena.entity.Admin;

public interface AdminDao {
	
	Admin findByCode(String adminCode);

}
