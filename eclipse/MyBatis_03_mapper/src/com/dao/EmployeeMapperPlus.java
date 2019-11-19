package com.dao;

import com.bean.Employee;

public interface EmployeeMapperPlus {

	public Employee getEmpById(Integer id);

	public Employee getEmpAndDept(Integer id);

	public Employee getEmpByIdStep(Integer id);
}
