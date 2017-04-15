package com.tarena.dao;

import java.util.List;

import com.tarena.annotation.MyBatisRepository;
import com.tarena.entity.Emp;

@MyBatisRepository
public interface EmpMapper {
	
	List<Emp> findAll();

}
