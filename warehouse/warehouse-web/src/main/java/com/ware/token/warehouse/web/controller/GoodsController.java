package com.ware.token.warehouse.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.WebDataBinder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.dayatang.utils.Page;

import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.facade.model.User;
import com.ware.token.warehouse.facade.GoodsFacade;

import org.openkoala.gqc.infra.util.JacksonUtil;
import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;
import org.openkoala.service.UserService;

@Controller
@RequestMapping("/Goods")
public class GoodsController {
		
	@Autowired
	private UserService userService;
	
	@Inject
	private GoodsFacade goodsFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(MultipartFile file, GoodsDTO goodsDTO, HttpServletRequest request) {
		if(file != null){
			String image = uploadFile(file, request);
			goodsDTO.setImage(image);
		}
		goodsDTO.setCreateTime(new Date());
		goodsDTO.setCreateUser(CurrentUser.getUserAccount());
		goodsDTO.setUpdateTime(new Date());
		goodsDTO.setUpdateUser(CurrentUser.getUserAccount());
		return goodsFacade.creatGoods(goodsDTO);
	}
	
	@ResponseBody
	@RequestMapping("/test")
	public InvokeResult test(@RequestParam("formData")String formData) {
		System.out.println(formData);
		try {
			GoodsDTO cooperation = JacksonUtil.json2object(formData, GoodsDTO.class,true);
			cooperation.getHeight();
			
			User user = new User();
	        user.setNickname("你好");
	        user.setState(2);
	        System.out.println(userService.insertUser(user));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(MultipartFile file, GoodsDTO goodsDTO, HttpServletRequest request) {
		if(file != null){
			String image = uploadFile(file, request);
			goodsDTO.setImage(image);
		}
		goodsDTO.setUpdateTime(new Date());
		goodsDTO.setUpdateUser(CurrentUser.getUserAccount());
		return goodsFacade.updateGoods(goodsDTO);
	}
	
	private String uploadFile(MultipartFile file,HttpServletRequest request ){
		 System.out.println("开始");  
	        String path = request.getSession().getServletContext().getRealPath("goodsImage");
	        String fileName = file.getOriginalFilename();
	        String fileEnd = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
	        //创建文件唯一名称  
	        fileName = UUID.randomUUID().toString()+"."+fileEnd;
	        
	        System.out.println(path);  
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	  
	        //保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	       return request.getContextPath()+"/goodsImage/"+fileName; 
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page<GoodsDTO> pageJson(GoodsDTO goodsDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<GoodsDTO> all = goodsFacade.pageQueryGoods(goodsDTO, page, pagesize);
		
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
        return goodsFacade.removeGoodss(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return goodsFacade.getGoods(id);
	}
	
	/**
	 * 根据条形码获取商品信息
	 * @param goodsId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getByGoodsId")
	public GoodsDTO getByGoodsId(String goodsId) {
		GoodsDTO goodsDTO = new GoodsDTO();
		goodsDTO.setGoodsId(goodsId);
		int page = 0;
		int pagesize=1;
		Page<GoodsDTO> all = goodsFacade.getByGoodsId(goodsDTO, page, pagesize);
		if(all.getData().size()==1){
			goodsDTO = all.getData().get(0);
		}
		return goodsDTO;
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
