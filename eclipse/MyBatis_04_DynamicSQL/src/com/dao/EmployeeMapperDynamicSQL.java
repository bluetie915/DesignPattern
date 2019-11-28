package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bean.Employee;

public interface EmployeeMapperDynamicSQL {
	
	//携带了哪个字段就带上这个字段的值
	public List<Employee> getEmpsByConditionIf(Employee employee);
	
	public List<Employee> getEmpsByConditionTrim(Employee employee);
	
	public List<Employee> getEmpsByConditionChoose(Employee employee);
	
	public void updateEmp(Employee employee);
	
	public List<Employee> getEmpsByConditionForeach(@Param("ids")List<Integer> ids);
	
	public void addEmps(@Param("employees")List<Employee> employees);
}
