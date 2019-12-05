package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Employee;
import com.service.EmployeeService;

@Controller
public class EmployeeController {

	
	EmployeeService service;
	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	
	@RequestMapping("/getAllEmps")
	public String emps(Map<String, Object> map){
		List<Employee> employees = service.getEmps();
		map.put("allEmps", employees);
		return "list";
	}
}
