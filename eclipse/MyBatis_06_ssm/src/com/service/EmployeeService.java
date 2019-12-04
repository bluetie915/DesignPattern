package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper mapper;
	
	public List<Employee> getEmps(){
		return mapper.getEmployees();
	}
}
