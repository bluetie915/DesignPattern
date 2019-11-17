package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bean.Employee;

public interface EmployeeMapper {

	public List<Employee> getEmpsByLastNameLike(String lastName);
	
	public Employee getEmpByMap(Map<String, Object> map);
	
	public Employee getEmpByIdAndName(@Param("id") Integer id, @Param("lastName") String lastName);

	public Employee getEmpById(Integer id);

	public void addEmp(Employee employee);

	public boolean updateEmp(Employee employee);

	public void deleteEmpById(Integer id);
}
