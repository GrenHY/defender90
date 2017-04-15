package com.tarena.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tarena.entity.User;


public class HelloAction {
	
	//基本属性
	private Integer id = 9;
	private String realName = "Tarena";
	//实体对象
	private User user;
	//数组
	private String[] langs = {"Java","c#","php"};
	//集合
	private List<String> cities;
	//Map
	private Map<String, Double> empMap;
	//实体对象集合
	private List<User> users;
	
	//分页信息
	private int totalPage = 5;
	private int currentPage = 3;

	public String sayHello() {
		//初始化实体对象
		user = new User();
		user.setUserName("zhangsan");
		user.setPassword("123");
		//初始化集合
		cities = new ArrayList<String>();
		cities.add("beijing");
		cities.add("shanghai");
		cities.add("guangzhou");
		//初始化Map
		empMap = new HashMap<String, Double>();
		empMap.put("zhangsan", 5000.0);
		empMap.put("lisi", 6000.0);
		empMap.put("wangwu", 7000.0);
		//初始化集合对象
		users = new ArrayList<User>();
		User u1 = new User();
		u1.setUserName("zhangsan");
		u1.setPassword("123");
		users.add(u1);
		User u2 = new User();
		u2.setUserName("lisi");
		u2.setPassword("456");
		users.add(u2);
		User u3 = new User();
		u3.setUserName("wangwu");
		u3.setPassword("789");
		users.add(u3);
		return "ok";
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String[] getLangs() {
		return langs;
	}

	public void setLangs(String[] langs) {
		this.langs = langs;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public Map<String, Double> getEmpMap() {
		return empMap;
	}

	public void setEmpMap(Map<String, Double> empMap) {
		this.empMap = empMap;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
