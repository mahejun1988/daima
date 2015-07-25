package com.ware.token.warehouse.web.controller;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.dayatang.utils.Page;

import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.facade.model.Kind;
import com.ware.token.warehouse.facade.KindFacade;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;
import org.openkoala.service.KindService;

@Controller
@RequestMapping("/Kind")
public class KindController {
		
	@Autowired
	private KindService kindService;
	
	@Inject
	private KindFacade kindFacade;
	
	@RequestMapping("test")
	public String test(Model model){
		model.addAttribute("tt", "31231方法");
		
		return "/domain/Kind-list";
	}

	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(KindDTO kindDTO) {
		//查询最大code值
		Kind kind = new Kind();
		kind.setCodeType(kindDTO.getCodeType());
		int maxId = kindService.getMaxIdByCodeType(kind);
		kindDTO.setCode(String.valueOf(maxId+1));
		if(kindDTO.getUpCode() == null || "".equals(kindDTO.getUpCode())){
			kindDTO.setUpCode("0");
		}
		kindDTO.setCreateTime(new Date());
		kindDTO.setCreateUser(CurrentUser.getUserAccount());
		kindDTO.setUpdateTime(new Date());
		kindDTO.setUpdateUser(CurrentUser.getUserAccount());
		return kindFacade.creatKind(kindDTO);
	}
	
	@ResponseBody
	@RequestMapping("/getByUpCode")
	public List<Kind> getByUpCode(String upCode) {
		Kind kind = new Kind();
		kind.setUpCode(upCode);
		List<Kind> list = kindService.getByUpCode(kind);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/getByCodeName")
	public List<Kind> getByUpCodeName(Kind kind) {
		List<Kind> list = kindService.getByUpCodeName(kind);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/getCodeList")
	public List<Kind> getByUpCode(Kind kind ) {
		List<Kind> list = kindService.getUpName(kind);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(KindDTO kindDTO) {
		KindDTO tKind = (KindDTO) kindFacade.getKind(kindDTO.getId()).getData();
		tKind.setCodeName(kindDTO.getCodeName());
		tKind.setRemark(kindDTO.getRemark());
		tKind.setUpdateTime(new Date());
		tKind.setUpdateUser(CurrentUser.getUserAccount());
		return kindFacade.updateKind(tKind);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(KindDTO kindDTO, @RequestParam int page, @RequestParam int pagesize) {
//		kindDTO.setUpCode("0");
		Page<KindDTO> all = kindFacade.pageQueryKind(kindDTO, page, pagesize);
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
        return kindFacade.removeKinds(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return kindFacade.getKind(id);
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
