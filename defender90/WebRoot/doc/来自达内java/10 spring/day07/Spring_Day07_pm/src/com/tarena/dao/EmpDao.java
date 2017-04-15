package com.tarena.dao;

import java.util.List;
import com.tarena.entity.Emp;

public interface EmpDao {
	public void add(Emp emp);
	public Emp delete(Integer empno);
	public void update(Emp emp);
	public Emp findById(Integer empno);
	public List<Emp> findByDept(Integer deptno);
	public List<Emp> findAll();
}


