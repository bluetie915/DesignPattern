package com.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.bean.Employee;
import com.bean.EmployeeExample;
import com.bean.EmployeeExample.Criteria;
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
public class MyBatisTest1 {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testMbg() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("mbg.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}

	@Test
	public void testMyBatis3Simple() throws IOException {
		SqlSessionFactory factory = getSqlSessionFactory();
		SqlSession session = factory.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			List<Employee> employees = mapper.selectByExample(null);
			for(Employee employee : employees){
				System.out.println(employee.getId());
			}
		} finally {
			session.close();
		}
	}
	
	//查询所有
	@Test
	public void testMyBatis3() throws IOException{
		SqlSessionFactory factory = getSqlSessionFactory();
		SqlSession session = factory.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			List<Employee> employees = mapper.selectByExample(null);
			for(Employee employee : employees){
				System.out.println(employee.getId());
			}
		} finally {
			session.close();
		}
	}
	
	//查询名字中有e字母的，和员工性别是1的
	@Test
	public void testMyBatis3_2() throws IOException{
		SqlSessionFactory factory = getSqlSessionFactory();
		SqlSession session = factory.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			//2、查询员工名字中有e字母的，和员工性别是1的
			//封装员工查询条件的example
			EmployeeExample example = new EmployeeExample();
			//创建一个Criteria，这个Criteria就是拼装查询条件
			//select id, last_name, email, gender, d_id from tbl_employee 
			//WHERE ( last_name like ? and gender = ? ) or email like "%e%"
			Criteria criteria = example.createCriteria();
			criteria.andLastNameLike("%e%");
			criteria.andGenderEqualTo("1");
			
			Criteria criteria2 = example.createCriteria();
			criteria2.andEmailLike("%e%");
			example.or(criteria2);
			List<Employee> employees = mapper.selectByExample(example);
			for(Employee employee : employees){
				System.out.println(employee.getId());
			}
		} finally {
			session.close();
		}
	}

}
