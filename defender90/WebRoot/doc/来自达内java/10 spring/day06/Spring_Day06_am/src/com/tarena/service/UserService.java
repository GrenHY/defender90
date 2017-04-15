package com.tarena.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.dao.UserDao;
import com.tarena.entity.User;

@Service
public class UserService {
	@Resource
	private UserDao userDao;
	
	/**
	 * 登陆系统
	 * @param name
	 * @param pwd
	 * @return 登陆成功返回登陆的用户信息
	 * @throws NameOrPwdException 用户名或者密码错误
	 * @throws EmptyParamException 用户名或者密码是空的
	 */
	public User login(String name, String pwd)
		throws NameOrPwdException, 
		       EmptyParamException{
		if(name==null || name.trim().equals("")){
			throw new EmptyParamException("名不能空");
		}
		if(pwd==null || pwd.trim().equals("")){
			throw new EmptyParamException("密码不能空");
		}
		User user = userDao.findByName(name);
		if(user==null){
			throw new NameOrPwdException("名不对");
		}
		if(user.getPwd().equals(pwd)){
			return user;//登陆成功！
		}
		throw new NameOrPwdException("密码不对");
	}
}



