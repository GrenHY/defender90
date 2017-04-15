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
	 * ��½ϵͳ
	 * @param name
	 * @param pwd
	 * @return ��½�ɹ����ص�½���û���Ϣ
	 * @throws NameOrPwdException �û��������������
	 * @throws EmptyParamException �û������������ǿյ�
	 */
	public User login(String name, String pwd)
		throws NameOrPwdException, 
		       EmptyParamException{
		if(name==null || name.trim().equals("")){
			throw new EmptyParamException("�����ܿ�");
		}
		if(pwd==null || pwd.trim().equals("")){
			throw new EmptyParamException("���벻�ܿ�");
		}
		User user = userDao.findByName(name);
		if(user==null){
			throw new NameOrPwdException("������");
		}
		if(user.getPwd().equals(pwd)){
			return user;//��½�ɹ���
		}
		throw new NameOrPwdException("���벻��");
	}
}



