package com.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.EmpMapper;
import com.tarena.entity.Emp;

public class TestEmpMapper {

	@Test
	public void testFindAll() {
		//����Spring����
		//�������ȡapplicationContext.xml��
		//��ʵ���������ļ���������bean��Ȼ��
		//����bean�е����ã��Զ�ɨ��ָ��·����
		//��mapper.xml���Զ�ɨ��ָ��·���µ�
		//����ע��Ľӿ�/�࣬�˴��Ľӿ�������
		//�Զ���Ľӿڡ�
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		//����������Mapper
		EmpMapper mapper = 
			ctx.getBean(EmpMapper.class);
		List<Emp> list = mapper.findAll();
		for(Emp e : list) {
			System.out.println(
				e.getEmpno() + " " +
				e.getEname() + " " +
				e.getDeptno()
			);
		}
	}
	
}
