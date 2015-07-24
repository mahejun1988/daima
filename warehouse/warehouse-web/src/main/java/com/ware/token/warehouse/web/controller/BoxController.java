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
import com.ware.token.warehouse.facade.BoxFacade;

import org.openkoala.koala.commons.InvokeResult;

@Controller
@RequestMapping("/Box")
public class BoxController {
		
	@Inject
	private BoxFacade boxFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(BoxDTO boxDTO) {
		return boxFacade.creatBox(boxDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(BoxDTO boxDTO) {
		return boxFacade.updateBox(boxDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(BoxDTO boxDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<BoxDTO> all = boxFacade.pageQueryBox(boxDTO, page, pagesize);
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
        return boxFacade.removeBoxs(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return boxFacade.getBox(id);
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
