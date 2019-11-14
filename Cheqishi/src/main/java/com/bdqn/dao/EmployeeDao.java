package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.Employee;

public interface EmployeeDao {
	/**
	 * 查询所有
	 * @return
	 */
	List<Employee> allQuery();
	
	/**
	 * 外键
	 * @param id
	 * @return
	 */
	Employee findId(int id);
	
}
 