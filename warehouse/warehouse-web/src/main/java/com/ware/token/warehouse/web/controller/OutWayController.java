package com.ware.token.warehouse.web.controller;

import javax.inject.Inject;

import org.springframework.web.bind.WebDataBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.dayatang.utils.Page;

import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.facade.OutWayFacade;
import com.ware.token.warehouse.facade.WayBillFacade;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;

@Controller
@RequestMapping("/OutWay")
public class OutWayController {
		
	@Inject
	private OutWayFacade outWayFacade;
	@Inject
	private WayBillFacade wayBillFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(OutWayDTO outWayDTO) {
		String str = outWayDTO.getWaybillId();
		String[] strarray = str.split(",");
		InvokeResult result = new InvokeResult();
	    for (int i = 0; i < strarray.length; i++){
	          	System.out.println(strarray[i]);
	          	outWayDTO.setWaybillId(strarray[i]);
				outWayDTO.setCreateTime(new Date());
				outWayDTO.setCreateUser(CurrentUser.getUserAccount());
				outWayDTO.setUpdateTime(new Date());
				outWayDTO.setUpdateUser(CurrentUser.getUserAccount());
				result = outWayFacade.creatOutWay(outWayDTO);
	    }
		// 更新运单表
		String[] value = outWayDTO.getWaybillId().split(",");
		wayBillFacade.outByWayBillId(value,CurrentUser.getUserAccount());
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(OutWayDTO outWayDTO) {
		return outWayFacade.updateOutWay(outWayDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(OutWayDTO outWayDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<OutWayDTO> all = outWayFacade.pageQueryOutWay(outWayDTO, page, pagesize);
		return all;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult remove(@RequestParam String ids) {
		String[] value = ids.split(",");
        Long[] idArrs = new Long[value.length];
        for (int i = 0; i < value.length; i ++) {
        	        					idArrs[i] = Long.parseLong(value[i]);
						        }
        return outWayFacade.removeOutWays(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return outWayFacade.getOutWay(id);
	}
	
		
    @InitBinder    
    public void initBinder(WebDataBinder binder) {  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
        dateFormat.setLenient(false);    
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
        //CustomDateEditor 可以换成自己定义的编辑器。  
        //注册一个Date 类型的绑定器 。
        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
    }
	
}
