package com.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bean.Employee;
import com.dao.EmployeeMapper;

public class MyBatisTest4 {

	public static SqlSessionFactory getFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sessionFactory;
	}

	/*
	 * 两级缓存 
	 * 一级缓存：（本场缓存） 
	 * 		即sqlSession级别的缓存，一级缓存一直是开启的，sqlSession级别的一个map
	 * 		与数据库同一次会话期间查询到的数据会放在本场缓存中 
	 * 		以后如果需要获取相同的，直接从缓存中拿，没必要再去查询数据库
	 * 
	 * 		一级缓存失效情况（没有使用到当前一级缓存的情况，效果就是，还需要再向数据库发出查询）
	 * 		1、sqlSession不同
	 * 		2、sqlSession相同，查询条件不同（当前一级缓存中还没有这个数据）
	 * 		3、sqlSession相同，两次查询之间执行了增删改操作（这次增删改可能就会改变当前数据）
	 * 		4、sqlSession相同，手动清除了一级缓存（缓存清空）
	 * 二级缓存：（全局缓存）
	 * 		基于namespace级别的缓存：一个namespace对应一个二级缓存
	 * 		工作机制：
	 * 		1、查询一条数据，这个数据就会被放在当前会话的一级缓存
	 * 		2、如果会话关闭，一级缓存中的数据会被保存到二级缓存
	 * 			新的会话查询信息就可以参照二级缓存中的内容
	 * 		3、sqlSession===>EmployeeMapper===>Employee
	 * 						 DepartmentMapper===>Department
	 * 						不同的namespace查出的数据会放在自己对应的缓存中（map）
	 * 		使用：
	 * 			1、开启全局二级缓存配置：
	 * 			2、去mapper.xml中配置使用二级缓存
	 * 			3、我们的POJO序列需要实现序列化接口
	 */
	@Test
	public void testFirstLevelCache() throws IOException {
		SqlSessionFactory factory = getFactory();
		SqlSession session = factory.openSession();
		try {
			//同一个sqlSession，同一个查询语句
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpById(1);
			System.out.println(employee);
			Employee employee2 = mapper.getEmpById(1);
			System.out.println(employee2);
			System.out.println(employee == employee2);
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testFirstLevelCache1() throws IOException {
		SqlSessionFactory factory = getFactory();
		SqlSession session = factory.openSession();
		try {
			//不同的sqlSession，同一个查询语句
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpById(1);
			System.out.println(employee);
			
			SqlSession session2 = factory.openSession();
			EmployeeMapper mapper2 = session2.getMapper(EmployeeMapper.class);
			Employee employee2 = mapper2.getEmpById(1);
			System.out.println(employee2);
			System.out.println(employee == employee2);
		} finally {
			session.close();
		}
	}

	@Test
	public void testFirstLevelCache2() throws IOException {
		SqlSessionFactory factory = getFactory();
		SqlSession session = factory.openSession();
		try {
			//同一个sqlSession，不同的查询语句
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpById(1);
			System.out.println(employee);
			
			Employee employee2 = mapper.getEmpById(2);
			System.out.println(employee2);
			System.out.println(employee == employee2);
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testFirstLevelCache3() throws IOException {
		SqlSessionFactory factory = getFactory();
		SqlSession session = factory.openSession();
		try {
			//同一个sqlSession，不同的查询语句
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpById(1);
			System.out.println(employee);
			
			mapper.addEmp(new Employee(null,"testChche","testChache@qq.com","1"));
			System.out.println("数据添加成功");
			
			Employee employee2 = mapper.getEmpById(1);
			System.out.println(employee2);
			System.out.println(employee == employee2);
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testFirstLevelCache4() throws IOException {
		SqlSessionFactory factory = getFactory();
		SqlSession session = factory.openSession();
		try {
			//同一个sqlSession，不同的查询语句
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpById(1);
			System.out.println(employee);
			
			session.clearCache();
			
			Employee employee2 = mapper.getEmpById(1);
			System.out.println(employee2);
			System.out.println(employee == employee2);
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testSecondLevelCache() throws IOException {
		SqlSessionFactory factory = getFactory();
		SqlSession session1 = factory.openSession();
		SqlSession session2 = factory.openSession();
		try {
			//同一个sqlSession，不同的查询语句
			EmployeeMapper mapper1 = session1.getMapper(EmployeeMapper.class);
			EmployeeMapper mapper2 = session2.getMapper(EmployeeMapper.class);
			Employee employee1 = mapper1.getEmpById(1);
			System.out.println(employee1);
			session1.close();
		} finally {
		}
	}
}
