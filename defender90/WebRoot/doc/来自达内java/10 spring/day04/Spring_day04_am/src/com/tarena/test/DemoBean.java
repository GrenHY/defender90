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
	
	//@Resource//Spring�������ɨ��ʱ����Spring
	//����������IDΪ dataBean ��Bean����
	//�ҵ��Ժ󣬽�Bean��������ע�뵽dataBean����
	//���ֹ���ƥ��ʧ���Ժ�ᰴ������ƥ�䣡
	//@Resource(name="dataBean")//ֻ����IDƥ�����
	//ע�뷽ʽѡ�񣺾���ʹ��Ĭ�Ϲ���
	//@Autowired 
	//@Qualifier("dataBean")
	//@Inject
	//@Named("dataBean")
	private DataBean dataBean;
	//������ƣ�Java API����Ϊ����ע��ֵ��
	//����API���Զ�̬�������ڣ��Ĺ������
	//Spring�������÷���API��̬(������)��
	// ����Bean����
	//Spring ��������Ϊ��������ע�룬������
	//ΪBean���Խ���ע��
	//@Resource//���ע��д��Bean���Է���ǰ
	//��������Bean���Է�������ע��
	@Autowired
	public void setDataBean(
			@Qualifier("dataBean") DataBean dataBean) {
		System.out.println("Call setDataBean()"); 
		//if(��������) 
		//while������������
		this.dataBean = dataBean;
	}
	
	@Value("#{jdbc.driver}")
	//Spring �������ڼ䣬��һ��IDΪjdbc��bean
	//��Bean�в��� driver��Ӧ�����ԡ���ȡ���
	//���Ե�ֵ��ע�뵽��ǰ�Ķ�������driver
	private String driver;
	
	public DemoBean() {
	}
	public String toString() {
		return "DemoBean:"+dataBean+driver;
	}
}




