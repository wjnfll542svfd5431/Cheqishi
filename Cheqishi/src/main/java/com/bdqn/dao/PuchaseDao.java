package com.bdqn.dao;

import java.util.List;
import java.util.Map;

import com.bdqn.entity.Puchase;
/**
 * 采购配件持久层
 * @author 王江南
 *
 */
public interface PuchaseDao {
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	List<Puchase> PageQuery(Map map);
	/**
	 * 查询总记录数
	 * @param map
	 * @return
	 */
	int Count(Map map);
	/**
	 * 采购配件
	 * @param puchase
	 * @return
	 */
	int AddPuchase(Puchase puchase);
	/**
	 * 修改采购信息
	 * @param puchase
	 * @return
	 */
	int ModifyPuchase(Puchase puchase);
	
	/**
	 * 查询要修改的信息
	 * @param id
	 * @return
	 */
	Puchase FindPuchase(int id);
	
}
