package com.bdqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.dao.SupplierDao;
import com.bdqn.entity.Supplier;

/**
 * 供应商业务层实现
 * @author 王江南
 *
 */
@Service
public class SupplierServiceimp implements SupplierService{
	@Autowired
	SupplierDao dao;
	
	@Override
	public List<Supplier> FindId(int id) {
		// TODO Auto-generated method stub
		return dao.FindId(id);
	}

	@Override
	public List<Supplier> FindAll() {
		// TODO Auto-generated method stub
		return dao.FindAll();
	}
	
}
