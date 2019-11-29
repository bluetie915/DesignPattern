package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bean.Department;
import com.bean.Employee;
import com.dao.EmployeeMapperDynamicSQL;

public class MyBatisTest3 {

	public static SqlSessionFactory getFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sessionFactory;
	}
	
	@Test
	public void testDynamicSql1() throws IOException{
		SqlSessionFactory factory = getFactory();
		SqlSession openSession = factory.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee(null,"Tom","Tom@qq.com","0");
			List<Employee> employees = mapper.getEmpsByConditionIf(employee);
			for(Employee emp:employees){
				System.out.println(emp);
			}
			//查询的时候如果某些条件没带可能sql拼接会有问题
			//1、给where后面加上1=1，以后的条件都and xxx.
			//2、mybatis使用where标签来将所有的查询条件包括在内，
			//mybatis就会将where标签中拼装的sql，多出来的and或者or去掉
				//where只会去掉第一个多出来的and或者or
				//如果把and或者or放在每个选择后面就无法判断了
		} finally {
			openSession.close();
		}
	}
	
	
	@Test
	public void testDynamicSql2() throws IOException{
		SqlSessionFactory factory = getFactory();
		SqlSession openSession = factory.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee(null,"Tom","Tom@qq.com",null);
			List<Employee> employees = mapper.getEmpsByConditionTrim(employee);
			for(Employee emp:employees){
				System.out.println(emp);
			}
		} finally {
			openSession.close();
		}
	}
	
	
	@Test
	public void testDynamicSql3() throws IOException{
		SqlSessionFactory factory = getFactory();
		SqlSession openSession = factory.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee(null,null,null,null);
			List<Employee> employees = mapper.getEmpsByConditionChoose(employee);
			for(Employee emp:employees){
				System.out.println(emp);
			}
		} finally {
			openSession.close();
		}
	}
	
	@Test
	public void testDynamicSql4() throws IOException{
		SqlSessionFactory factory = getFactory();
		SqlSession openSession = factory.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee(4,"Admin","Admin@qq.com",null);
			mapper.updateEmp(employee);
			openSession.commit();
		} finally {
			openSession.close();
		}
	}
	
	@Test
	public void testDynamicSql5() throws IOException{
		SqlSessionFactory factory = getFactory();
		SqlSession openSession = factory.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
			List<Employee> employees = mapper.getEmpsByConditionForeach(Arrays.asList(1,2,3));
			for(Employee employee: employees){
				System.out.println(employee);
			}
		} finally {
			openSession.close();
		}
	}
	
	@Test
	public void testDynamicSql6() throws IOException{
		SqlSessionFactory factory = getFactory();
		SqlSession openSession = factory.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
			List<Employee> employees = new ArrayList<Employee>();
			employees.add(new Employee(null,"Smith","Smith@qq.com","0",new Department(1)));
			employees.add(new Employee(null,"Allen","Allen@qq.com","0",new Department(1)));
			mapper.addEmps(employees);
			openSession.commit();
		} finally {
			openSession.close();
		}
	}
	
	@Test
	public void testDynamicSql7() throws IOException{
		SqlSessionFactory factory = getFactory();
		SqlSession openSession = factory.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
			List<Employee> employees = mapper.getEmpsTestInnerParameter(null);
			for(Employee employee : employees){
				System.out.println(employee);
			}
		} finally {
			openSession.close();
		}
	}
	
	@Test
	public void testDynamicSql8() throws IOException{
		SqlSessionFactory factory = getFactory();
		SqlSession openSession = factory.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee();
			employee.setLastName("e");
			List<Employee> employees = mapper.getEmpsTestInnerParameter(employee);
			for(Employee emp : employees){
				System.out.println(emp);
			}
		} finally {
			openSession.close();
		}
	}
}
