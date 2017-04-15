package com.tarena.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.dao.EmpMapper;
import com.tarena.entity.Emp;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Resource
	private EmpMapper empMapper;

	/**
	 * 查询全部的员工
	 */
	@RequestMapping("/findEmp.do")
	public String find(Model model) {
		//查询
		List<Emp> list = empMapper.findAll();
		model.addAttribute("emps", list);
		//转发
		return "emp/emp_list";
	}
	
}
