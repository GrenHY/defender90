package com.tarena.test;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope("prototype")
@Component("demo")
public class DemoBean implements Serializable {
	
	//@Resource//Spring会在组件扫描时候，在Spring
	//的容器中找ID为 dataBean 的Bean对象
	//找到以后，将Bean对象引用注入到dataBean属性
	//名字规则匹配失败以后会按照类型匹配！
	//@Resource(name="dataBean")//只是有ID匹配规则
	//注入方式选择：尽量使用默认规则。
	//@Autowired 
	//@Qualifier("dataBean")
	//@Inject
	//@Named("dataBean")
	private DataBean dataBean;
	//反射机制（Java API），为属性注入值的
	//反射API可以动态（运行期）的管理对象
	//Spring就是利用反射API动态(运行期)的
	// 管理Bean对象
	//Spring 不仅可以为对象属性注入，还可以
	//为Bean属性进行注入
	//@Resource//如果注解写在Bean属性方法前
	//就来利用Bean属性方法进行注入
	@Autowired
	public void setDataBean(
			@Qualifier("dataBean") DataBean dataBean) {
		System.out.println("Call setDataBean()"); 
		//if(。。。。) 
		//while（。。。。）
		this.dataBean = dataBean;
	}
	
	@Value("#{jdbc.driver}")
	//Spring 在运行期间，找一个ID为jdbc的bean
	//在Bean中查找 driver对应的属性。读取这个
	//属性的值，注入到当前的对象属性driver
	private String driver;
	
	public DemoBean() {
	}
	public String toString() {
		return "DemoBean:"+dataBean+driver;
	}
}




