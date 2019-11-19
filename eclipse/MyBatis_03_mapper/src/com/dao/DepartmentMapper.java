package com.dao;

import com.bean.Department;

public interface DepartmentMapper {

	public Department getDeptById(Integer id);

	public Department getDepByIdPlus(Integer id);

	public Department getDeptByIdStep(Integer id);
}
