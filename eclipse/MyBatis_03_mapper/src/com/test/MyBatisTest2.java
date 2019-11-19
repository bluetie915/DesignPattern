package com.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bean.Employee;
import com.dao.EmployeeMapperPlus;

public class MyBatisTest2 {

	public static SqlSessionFactory getFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sessionFactory;
	}

	@Test
	public void test01() throws IOException {
		SqlSession session = getFactory().openSession();
		try {
			EmployeeMapperPlus mapper = session.getMapper(EmployeeMapperPlus.class);
			Employee employee = mapper.getEmpById(1);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

	@Test
	public void test02() throws IOException {
		SqlSession session = getFactory().openSession();
		try {
			EmployeeMapperPlus mapper = session.getMapper(EmployeeMapperPlus.class);
			Employee employee = mapper.getEmpAndDept(1);
			System.out.println(employee);
			System.out.println(employee.getDept());
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test03() throws IOException {
		SqlSession session = getFactory().openSession();
		try {
			EmployeeMapperPlus mapper = session.getMapper(EmployeeMapperPlus.class);
			Employee employee = mapper.getEmpByIdStep(1);
			System.out.println(employee.getLastName());
			System.out.println(employee.getDept().getDepartmentName());
		} finally {
			session.close();
		}
	}
}
