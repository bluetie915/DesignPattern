package com.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bean.Employee;

/*
 * 1.根据xml配置文件（全局配置文件）创建一个SqlSesstionFactory对象
 * 2.获取sqlSession实例，能直接执行已经映射的sql语句
 * sql的唯一标识
 * 
 */

public class MyBatisTest {

	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Employee employee = session.selectOne("com.EmployeeMapper.selectEmp", 1);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

}
