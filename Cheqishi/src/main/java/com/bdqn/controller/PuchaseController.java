package com.bdqn.controller;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bdqn.entity.Puchase;
import com.bdqn.service.PuchaseService;
import com.bdqn.service.SupplierService;
import com.bdqn.util.PageUtil;

/**
 * 采购配件控制器
 * @author 王江南
 *
 */
@Controller
@RequestMapping("/Puchase")
public class PuchaseController {
	@Autowired
	PuchaseService puchaseService;//自动创建PuchaseService代理对象
	@Autowired
	SupplierService supplierService;//自动创建SupplierService代理对象
	@Autowired
	StringRedisTemplate srt;
	@Autowired
	RedisTemplate<String,Object> rt;

	/**
	 * 链接跳转到添加和修改页面
	 * @return
	 */
	@RequestMapping(value="/pu",method=RequestMethod.GET)
	public String Puchase(Model model,@RequestParam(defaultValue="0",required=false)int id) {
		if(id==0) {//添加
			model.addAttribute("supplier", supplierService.FindAll());//供应商信息
			return "Puchase";
		}else {//修改
			model.addAttribute("supplier", supplierService.FindAll());//供应商信息
			model.addAttribute("puchase", puchaseService.FindPuchase(id));//返回要修对象
			System.out.println(puchaseService.FindPuchase(id));
			return "Puchase";
		}
		
	}
	
	/**
	 * 链接跳转到添加和修改页面
	 * @return
	 */ 
	@RequestMapping(value="/pu",method=RequestMethod.POST)
	public String Puchase(Model model,@Validated Puchase puchase,BindingResult br) {
		System.out.println("修改添加"+puchase);
		if(puchase.getPurchaseId()==0) {//添加
			if(br.hasErrors()) {
				for (FieldError error :br.getFieldErrors()) {
					model.addAttribute(error.getField(), error.getDefaultMessage());
					model.addAttribute("supplier", supplierService.FindAll());
					model.addAttribute("puchase", puchase);//将添加数据传到页面
				}
				return "Puchase";
			}else {
				puchaseService.AddPuchase(puchase);
				return "redirect:pageInfo";
			}
		}else {//修改
			if(br.hasErrors()) {
				for (FieldError error :br.getFieldErrors()) {
					model.addAttribute(error.getField(), error.getDefaultMessage());
					model.addAttribute("supplier", supplierService.FindAll());
					model.addAttribute("puchase", puchase);//将添加数据传到页面
				}
				return "Puchase";
			}else {
				puchaseService.ModifyPuchase(puchase);
				return "redirect:pageInfo";
			}
		}
	}

	/**
	 * 
	 * @param supplierId 供应商编号
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param pageIndex 当前页
	 * @param pageSize  页大小
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/pageInfo")
	public String pageInfo(@RequestParam(defaultValue="0",required=false)int supplierId, String startDate,//
			String endDate,@RequestParam(defaultValue="1",required=false)int pageIndex,//
			@RequestParam(defaultValue="12",required=false)int pageSize,Model model,HttpServletRequest request
			) {
		HttpSession session = request.getSession();
		//供应商id
		System.out.println(supplierId);
		if(supplierId!=-1) {
			session.setAttribute("supplierId",supplierId);
		}else {
			if(session.getAttribute("supplierId")!=null) {
				supplierId=(int) session.getAttribute("supplierId");
			}
		}
		System.out.println("/////////////////"+supplierId);
		//开始时间
		if(startDate!=null) {
			session.setAttribute("startDate", startDate);
		}else {
			if(session.getAttribute("startDate")!=null) {
				startDate= (String)session.getAttribute("startDate");
			}
		}

		//结束时间
		if(endDate!=null) {
			session.setAttribute("endDate", endDate);
		}else {
			if(session.getAttribute("endDate")!=null) {
				endDate= (String)session.getAttribute("endDate");
			}
		}
		
		System.out.println("开始"+startDate+"结束"+endDate);
		
		PageUtil<Puchase> pageUtil=puchaseService.PageQuery(supplierId, startDate, endDate, pageIndex, pageSize);//分页数据
		
		
		/*if(rt.persist("PuchaseInfo"+pageIndex+startDate+endDate)){//key值存在就中redis缓存中取出，如果不存在就存入redis中
			System.out.println("从Redis 缓存中取数据..");
			pageUtil=(PageUtil<Puchase>) rt.opsForValue().get("PuchaseInfo"+pageIndex+startDate+endDate);
		}else{
			System.out.println("从数据库中取数据，并存入缓存..");
			rt.opsForValue().set("PuchaseInfo"+pageIndex+startDate+endDate, pageUtil, 120,TimeUnit.SECONDS);
		}*/
		
		
		model.addAttribute("pageUtil", pageUtil);
		model.addAttribute("supplierId", session.getAttribute("supplierId"));
		model.addAttribute("supplierInfo", supplierService.FindAll());//供应商信息
		
		return "PuchaseInfo";
	}
}
