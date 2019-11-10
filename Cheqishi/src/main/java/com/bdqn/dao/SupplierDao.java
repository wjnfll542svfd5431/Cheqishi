package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.Supplier;

/**
 * 供应商
 * @author 王江南
 *
 */
public interface SupplierDao {
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
