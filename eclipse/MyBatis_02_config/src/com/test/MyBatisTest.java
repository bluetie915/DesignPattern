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

/*
 * 1.根据xml配置文件（全局配置文件）创建一个SqlSesstionFactory对象
 * 2.获取sqlSession实例，能直接执行已经映射的sql语句
 * 3.将sql映射文件注册全局配置文件中
 * 4.写代码：
 * 		1.根据全局配置文件得到SqlSessionFactory
 * 		2.使用sqlSession工厂，获取到sqlSession对象使用它来执行CRUD
 * 			一个sqlSession就是代表和数据库的一次会话，用完关闭
 * 		3.使用sql的唯一标识告诉MyBatis执行哪个sql，sql都是保存在sql映射文件中的
 * 
 */
/*
	1.接口式编程
		原生：		Dao  	==>  DaoImpl
		mybatis:	Mapper  ==>  **Mapper.xml
	2.SqlSession代表和数据库的一次会话，用完必须关闭
	3.SqlSession和connection一样都是非线程安全的，每次使用都应该获取新的对象
	4.mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象
		将接口和xml进行绑定
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
	5.两个重要的配置文件：
		mybatis的全局配置文件：包含数据库的连接池信息，事务管理器信息等，系统运行环境信息
		sql映射文件：保存了每个sql语句的映射信息
			将sql抽取出来
	
*/
public class MyBatisTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void test() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Employee employee = session.selectOne("com.EmployeeMapper.selectEmp", 1);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

	@Test
	public void test01() throws IOException {
		// 1.获取SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//2.获取sqlSession对象
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			//3.获取接口的实现类对象
			//会为接口自动创建一个代理对象，代理对象去执行CRUD方法
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			System.out.println(mapper.getClass());
			Employee employee = mapper.getEmpById(1);
			System.out.println(employee);
		}finally {
			openSession.close();
		}
	}

}
