package com.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bean.Department;
import com.bean.Employee;
import com.dao.DepartmentMapper;
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
			Employee employee = mapper.getEmpByIdStep(5);
			System.out.println(employee);
			System.out.println(employee.getDept());
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test04() throws IOException{
		SqlSession session = getFactory().openSession();
		try {
			DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
			Department department = mapper.getDepByIdPlus(1);
			System.out.println(department);
			System.out.println(department.getEmps());
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test05() throws IOException{
		SqlSession session = getFactory().openSession();
		try {
			DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
			Department department = mapper.getDeptByIdStep(1);
			System.out.println(department);
			System.out.println(department.getEmps());
		} finally {
			session.close();
		}
	}
}
