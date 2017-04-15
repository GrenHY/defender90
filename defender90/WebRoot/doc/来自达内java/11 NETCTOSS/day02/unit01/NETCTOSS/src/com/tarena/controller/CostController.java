package com.tarena.controller;

import java.sql.Timestamp;
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
	
	@RequestMapping("/toAddCost.do")
	public String toAdd() {
		return "cost/add_cost";
	}
	
	/**
	 * ���ύʱ��������ᴫ�ݸ������Ĳ�����
	 * ʵ����Spring��֪��Ҫ�����ݸ��ĸ���������ֻ��
	 * ������ɵ��ʽ�Ĵ������������еĲ����������
	 * ���ı���ƥ���������ֵ����������ˡ�
	 */
	@RequestMapping("/addCost.do")
	public String add(Cost cost) {
		//����Ĭ��ֵ
		cost.setStatus("1");
		cost.setCreatime(
			new Timestamp(System.currentTimeMillis()));
		//��������
		costMapper.save(cost);
		//�ض��򵽲�ѯ
		return "redirect:findCost.do";
	}
	
	@RequestMapping("/toUpdateCost.do")
	public String toUpdate(int id, Model model) {
		//��ѯ��Ҫ�޸ĵ����ݣ����޸�ҳ����Ĭ����ʾ
		Cost cost = costMapper.findById(id);
		model.addAttribute("cost", cost);
		//ת�����޸�ҳ��
		return "cost/update_cost";
	}
	
	@RequestMapping("/updateCost.do")
	public String update(Cost cost) {
		costMapper.update(cost);
		return "redirect:findCost.do";
	}
	
}
