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
		//查询全部资费数据
		List<Cost> list = costMapper.findAll();
		model.addAttribute("costs", list);
		//转发
		return "cost/cost_list";
	}
	
	@RequestMapping("/toAddCost.do")
	public String toAdd() {
		return "cost/add_cost";
	}
	
	/**
	 * 表单提交时，数据项会传递给方法的参数。
	 * 实际上Spring不知道要把数据给哪个参数，它只是
	 * 采用了傻瓜式的处理，即遍历所有的参数，如果有
	 * 与文本框匹配的属性则赋值，否则就算了。
	 */
	@RequestMapping("/addCost.do")
	public String add(Cost cost) {
		//设置默认值
		cost.setStatus("1");
		cost.setCreatime(
			new Timestamp(System.currentTimeMillis()));
		//新增保存
		costMapper.save(cost);
		//重定向到查询
		return "redirect:findCost.do";
	}
	
	@RequestMapping("/toUpdateCost.do")
	public String toUpdate(int id, Model model) {
		//查询出要修改的数据，在修改页面上默认显示
		Cost cost = costMapper.findById(id);
		model.addAttribute("cost", cost);
		//转发到修改页面
		return "cost/update_cost";
	}
	
	@RequestMapping("/updateCost.do")
	public String update(Cost cost) {
		costMapper.update(cost);
		return "redirect:findCost.do";
	}
	
}
