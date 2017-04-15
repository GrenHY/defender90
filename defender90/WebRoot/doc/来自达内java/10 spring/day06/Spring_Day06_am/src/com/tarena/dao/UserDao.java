package com.tarena.dao;

import com.tarena.entity.User;

public interface UserDao {
	User findByName(String name);
}
