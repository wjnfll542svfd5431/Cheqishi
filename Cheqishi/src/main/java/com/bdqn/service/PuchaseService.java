package com.bdqn.service;

import java.util.List;
import java.util.Map;

import com.bdqn.entity.Puchase;
import com.bdqn.util.PageUtil;

/**
 * 采购配件业务层
 * @author 王江南
 *
 */
public interface PuchaseService {
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	PageUtil<Puchase> PageQuery(int supplierId,String startDate,String endDate,int pageIndex,int pageSize);
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
