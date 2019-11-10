package com.dao;

import com.bean.Employee;

public interface EmployeeMapper {

	public Employee getEmpByIdAndLastName(Integer id, String lastName);

	public Employee getEmpById(Integer id);

	public void addEmp(Employee employee);

	public boolean updateEmp(Employee employee);

	public void deleteEmpById(Integer id);
}
