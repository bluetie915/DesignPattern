package com.dao;

import java.util.List;

import com.bean.Employee;

public interface EmployeeMapper {

	public Employee getEmpById(Integer id);
	
	public List<Employee> getEmps();
}
