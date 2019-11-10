package com.bdqn.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.bdqn.dao.PuchaseDao;
import com.bdqn.entity.Puchase;
import com.bdqn.util.PageUtil;

/**
 * 采购配件业务层实现
 * @author 王江南
 *
 */
@Service
public class PuchaseServiceimp implements PuchaseService
{
	@Autowired
	PuchaseDao dao;//动态创建代理对象
	
	
	@Override
	public PageUtil<Puchase> PageQuery(int supplierId,String startDate,String endDate,int pageIndex,int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String,Object>();//map集合
		map.put("pageIndex",(pageIndex-1)*pageSize);
		map.put("pageSize",pageSize);
		
		if(supplierId!=0) {
			map.put("supplierId", supplierId);
		}
		
		if(startDate!=null&&startDate!="") {
			map.put("startDate",startDate);
		}
		
		if(endDate!=null&&endDate!="") {
			map.put("endDate",endDate);
		}
		
		PageUtil<Puchase> pageUtil=new PageUtil<Puchase>();
		pageUtil.setPagedata(dao.PageQuery(map));//页数据
		pageUtil.setPageIndex(pageIndex);//当前页
		pageUtil.setPageSize(pageSize);//页大小
		pageUtil.setTotaCount(dao.Count(map));//总记录数
		if(pageUtil.getTotaCount()%pageUtil.getPageSize()==0) {//总页数
			pageUtil.setTotaPageNumber(pageUtil.getTotaCount()/pageUtil.getPageSize());
		}else {
			pageUtil.setTotaPageNumber(pageUtil.getTotaCount()/pageUtil.getPageSize()+1);
		}
		return pageUtil;
	}

	@Override
	public int AddPuchase(Puchase puchase) {
		// TODO Auto-generated method stub
		return dao.AddPuchase(puchase);
	}

	@Override
	public int ModifyPuchase(Puchase puchase) {
		// TODO Auto-generated method stub
		return dao.ModifyPuchase(puchase);
	}

	@Override
	public Puchase FindPuchase(int id) {
		// TODO Auto-generated method stub
		return dao.FindPuchase(id);
	}
	
}
