package com.tarena.dao;

import java.util.List;

import com.tarena.annotation.MyBatisRepository;
import com.tarena.entity.Cost;

@MyBatisRepository
public interface CostMapper {

	List<Cost> findAll();
	
}
