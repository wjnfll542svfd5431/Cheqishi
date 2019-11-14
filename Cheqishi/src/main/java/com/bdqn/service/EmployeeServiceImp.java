package com.bdqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.dao.EmployeeDao;
import com.bdqn.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService{
	@Autowired
	EmployeeDao dao;
	@Override
	public List<Employee> allQuery() {
		// TODO Auto-generated method stub
		return dao.allQuery();
	}

	@Override
	public Employee findId(int id) {
		// TODO Auto-generated method stub
		return dao.findId(id);
	}
	
}
