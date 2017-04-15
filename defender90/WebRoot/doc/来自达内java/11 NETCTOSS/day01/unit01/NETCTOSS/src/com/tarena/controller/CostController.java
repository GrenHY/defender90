package com.tarena.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.dao.CostMapper;
import com.tarena.entity.Cost;

@Controller
@RequestMapping("/cost")
public class CostController {

	@Resource
	private CostMapper costMapper;
	
	@RequestMapping("/findCost.do")
	public String find(Model model) {
		//��ѯȫ���ʷ�����
		List<Cost> list = costMapper.findAll();
		model.addAttribute("costs", list);
		//ת��
		return "cost/cost_list";
	}
	
}
