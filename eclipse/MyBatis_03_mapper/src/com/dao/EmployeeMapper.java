package com.dao;

import com.bean.Employee;

public interface EmployeeMapper {

	public Employee getEmpById(Integer id);
	
	public void addEmp(Employee employee);
	
	public void updateEmp(Employee employee);
	
	public void deleteEmpById(Integer id);
}
