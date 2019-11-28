package com.dao;

import java.util.List;

import com.bean.Employee;

public interface EmployeeMapperDynamicSQL {
	
	//携带了哪个字段就带上这个字段的值
	public List<Employee> getEmpsByConditionIf(Employee employee);
}
