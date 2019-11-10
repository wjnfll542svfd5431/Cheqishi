package com.bdqn.service;

import java.util.List;

import com.bdqn.entity.Supplier;

public interface SupplierService {
	/**
	 * 根据id查询内容
	 * @param id
	 * @return
	 */
	List<Supplier> FindId(int id);
	/**
	 * 查询全部
	 * @return
	 */
	List<Supplier> FindAll();
}
