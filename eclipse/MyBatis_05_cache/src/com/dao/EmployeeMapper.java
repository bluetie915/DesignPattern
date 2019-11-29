package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.bean.Employee;

public interface EmployeeMapper {

	
	//多条记录封装成一个map：Map<Integer,Employee>:
//		键是这条记录的主键，值是记录封装后的javaBean
	@MapKey("id")//告诉mybatis封装这个map的时候使用哪个属性作为map的key
	public Map<Integer, Employee> getEmpByLastNameLikeReturnMap(String lastName);
	  
	
	// 返回一条记录的map：
	// key就是列名，值就是对应的值
	public Map<String, Object> getEmpByIdReturnMap(Integer id);

	public List<Employee> getEmpsByLastNameLike(String lastName);

	public Employee getEmpByMap(Map<String, Object> map);

	public Employee getEmpByIdAndName(@Param("id") Integer id, @Param("lastName") String lastName);

	public Employee getEmpById(Integer id);

	public void addEmp(Employee employee);

	public boolean updateEmp(Employee employee);

	public void deleteEmpById(Integer id);
}
