package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bean.Employee;
import com.dao.EmployeeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Page<Object> page = PageHelper.startPage(1, 2);
			List<Employee> employees = mapper.getEmps();
			//传入要连续显示多少页
			PageInfo<Employee> info = new PageInfo<>(employees,5);
			for (Employee employee : employees) {
				System.out.println(employee);
			}
//			System.out.println("当前页码" + page.getPageNum());
//			System.out.println("总记录数" + page.getTotal());
//			System.out.println("每页的记录数" + page.getPageSize());
//			System.out.println("总页码" + page.getPages());
			
			System.out.println("当前页码:" + info.getPageNum());
			System.out.println("总记录数:" + info.getTotal());
			System.out.println("每页的记录数:" + info.getPageSize());
			System.out.println("总页码:" + info.getPages());
			System.out.println("是否第一页:" + info.isIsFirstPage());
		} finally {
			session.close();
		}
	}

}
