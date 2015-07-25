package com.ware.token.warehouse.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.dayatang.utils.Page;

import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.facade.model.Goods;
import com.ware.token.warehouse.facade.BillGoodsFacade;
import com.ware.token.warehouse.facade.BoxFacade;
import com.ware.token.warehouse.facade.GoodsFacade;
import com.ware.token.warehouse.facade.WayBillFacade;

import org.openkoala.gqc.infra.util.JacksonUtil;
import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;
import org.openkoala.service.GoodsService;

@Controller
@RequestMapping("/WayBill")
public class WayBillController {
		
	@Inject
	private WayBillFacade wayBillFacade;
	@Inject
	private BoxFacade boxFacade;
	@Inject
	private BillGoodsFacade billGoodsFacade;
	@Inject
	private GoodsFacade goodsFacade;
	
	@Autowired
	private GoodsService goodsService;
	
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping("/addYd")
	public InvokeResult add(MultipartHttpServletRequest fileRequest,
							@RequestParam("ydArrJson")String ydArrJson,
							@RequestParam("xzArrJson")String xzArrJson,
							@RequestParam("spArrJson")String spArrJson,
							HttpServletRequest request) {
		InvokeResult result = new InvokeResult();
		System.out.println("ydArrJson....."+ydArrJson);
		System.out.println("xzArrJson....."+xzArrJson);
		System.out.println("spArrJson....."+spArrJson);
		try {
 			WayBillDTO wayBillDto = JacksonUtil.json2object(ydArrJson.replaceAll("[+]", " "), WayBillDTO[].class,true)[0];
 			WayBillDTO olddto = wayBillFacade.getByWaybillId(wayBillDto.getWaybillId());
 	        if (olddto != null) {
 	            return InvokeResult.failure("运单号：" + wayBillDto.getWaybillId() + "已经入库了，不需要再次出库！");
 	        }
 			
			wayBillDto.setCreateTime(new Date());
			wayBillDto.setCreateUser(CurrentUser.getUserAccount());
			wayBillDto.setUpdateTime(new Date());
			wayBillDto.setUpdateUser(CurrentUser.getUserAccount());
			wayBillFacade.creatWayBill(wayBillDto);
			
			List<BoxDTO> list = (List<BoxDTO>)JacksonUtil.json2List(xzArrJson, new TypeReference<List<BoxDTO>>() {},true);
			for(BoxDTO dto:list){
				dto.setCreateTime(new Date());
				dto.setCreateUser(CurrentUser.getUserAccount());
				dto.setUpdateTime(new Date());
				dto.setUpdateUser(CurrentUser.getUserAccount());
				boxFacade.creatBox(dto);
			}
			List<BillGoodsDTO> list2 = (List<BillGoodsDTO>)JacksonUtil.json2List(spArrJson, new TypeReference<List<BillGoodsDTO>>() {},true);
			
			int k = 0;
			List<MultipartFile> fileList = fileRequest.getFiles("file");
			
			for(BillGoodsDTO dto:list2){
				dto.setCreateTime(new Date());
				dto.setCreateUser(CurrentUser.getUserAccount());
				dto.setUpdateTime(new Date());
				dto.setUpdateUser(CurrentUser.getUserAccount());
				
				if(StringUtils.isNotEmpty(dto.getImage()) && fileList.size() > k){
					String image = uploadFile(fileList.get(k), request);
					dto.setImage(image);
					k++;
				}
				
				billGoodsFacade.creatBillGoods(dto);
			}
			
			List<GoodsDTO> list3 = (List<GoodsDTO>)JacksonUtil.json2List(spArrJson, new TypeReference<List<GoodsDTO>>() {},true);
			
			for(GoodsDTO dto:list3){
				// 判断商行品是否已经维护
				GoodsDTO goodsDTO = new GoodsDTO();
				goodsDTO.setGoodsId(dto.getGoodsId());
				int page = 0;
				int pagesize=1;
				Page<GoodsDTO> all = goodsFacade.getByGoodsId(goodsDTO, page, pagesize);
				if(all.getData().size()==1){
					continue;
				}
				dto.setCreateTime(new Date());
				dto.setCreateUser(CurrentUser.getUserAccount());
				dto.setUpdateTime(new Date());
				dto.setUpdateUser(CurrentUser.getUserAccount());
				
				goodsFacade.creatGoods(dto);
			}
			
			
//			ObjectMapper mapper = new ObjectMapper();  
//			List<BillGoodsDTO> beanList = mapper.readValue(spArrJson, new TypeReference<List<BillGoodsDTO>>() {});  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
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
	
//	@RequestMapping("/get/{id}")
//	public String get(@PathVariable Long id, Model model) {
	
	 @ResponseBody
	 @RequestMapping("/upload")
	 public String upload(@RequestParam("files") MultipartFile[] files, HttpServletRequest request, ModelMap model) {  
//	 public String upload(@PathVariable MultipartFile file, HttpServletRequest request, ModelMap model) {
	  
	        System.out.println("开始");  
	        String path = request.getSession().getServletContext().getRealPath("goodsImage");
	        int i = Integer.parseInt(request.getParameter("f"));
	        MultipartFile file =  files[i];; 
	        String fileName = file.getOriginalFilename();
	        String fileEnd = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
	        //创建文件唯一名称  
	        fileName = UUID.randomUUID().toString()+"."+fileEnd;
	        
//	        String fileName = new Date().getTime()+".jpg";  
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
	        model.addAttribute("fileUrl", request.getContextPath()+"/goodsImage/"+fileName);  
	  
	        return "/goodsImage/"+fileName;  
	    }  
	  
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(WayBillDTO wayBillDTO) {
		return wayBillFacade.updateWayBill(wayBillDTO);
	}
	
	@ResponseBody
	@RequestMapping("/query")
	public  Page<Map<String, String>> query(Goods goods, @RequestParam int page, @RequestParam int pagesize) {
		int totalCount = goodsService.countQuery(goods);
		goods.setPage(Page.getStartOfPage(page, pagesize));
		goods.setPagesize(pagesize);
		
		List<Map<String,String>> list = goodsService.QueryByPage(goods);
		Page<Map<String,String>> all = new Page<Map<String,String>>(Page.getStartOfPage(page, pagesize), totalCount, pagesize, list);
		return all;
	}
	
	@ResponseBody
	@RequestMapping("/getAllCoo")
	public List<WayBillDTO> getAllCoo() {
		return wayBillFacade.getAllCoo();
	}
	
	@ResponseBody
	@RequestMapping("/out")
	public InvokeResult out(WayBillDTO wayBillDTO) {
	   WayBillDTO olddto = wayBillFacade.getByWaybillId(wayBillDTO.getWaybillId());
 	   if (olddto == null) {
 	            return InvokeResult.failure("运单号：" + wayBillDTO.getWaybillId() + "还没有入库，不能出库！");
 	     }
		wayBillDTO.setOutFlag("2");
		wayBillDTO.setOutTime(new Date());
		wayBillDTO.setUpdateTime(new Date());
		wayBillDTO.setUpdateUser(CurrentUser.getUserAccount());
		return wayBillFacade.outWayBill(wayBillDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page<WayBillDTO> pageJson(WayBillDTO wayBillDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<WayBillDTO> all = wayBillFacade.pageQueryWayBill(wayBillDTO, page, pagesize);
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
        return wayBillFacade.removeWayBills(idArrs);
	}
	
	@RequestMapping("/get/{id}")
	public String get(@PathVariable Long id, Model model) {
		InvokeResult result = wayBillFacade.getWayBill(id);
		try {
			String json = JacksonUtil.object2json(result.getData());
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(json);
//			{"id":79,"version":0,"waybillId":"132","wayBillFrom":"","wayBillInternet":"","wayBillCoo":"123123","jpyPrice":"","cnyPrice":"","usdPrice":"","eurPrice":"123","outFlag":"NO","outTime":null,"outTimeEnd":null,"wayBillNum":"1","createTime":"2015-07-07 01:36:51","createTimeEnd":null,"createUser":"koala","remark":null,"updateTime":"2015-07-07 01:36:51","updateTimeEnd":null,"updateUser":"koala","list":[{"id":67,"version":0,"boxId":"1","createTime":"2015-07-07 01:36:52","createTimeEnd":null,"createUser":"koala","weight":"","height":"","updateTime":"2015-07-07 01:36:52","updateTimeEnd":null,"width":"","volume":"","goodsNum":"1","waybillId":"132","lenght":"","updateUser":"koala","list":[{"id":69,"version":0,"createTime":"2015-07-07 01:36:52","createTimeEnd":null,"goodsId":"3rff","model":"","weight":"","smallType":"","cnyPrice":"","height":"","composition":"","length":"","bigType":"","goodsType":"","boxId":"1","usdPrice":"","eurPrice":"","updateTime":"2015-07-07 01:36:52","updateTimeEnd":null,"width":"","image":"","waybillId":"132","goodsNum":"","country":"","jpyPrice":"","createUser":"koala","volume":"","goodsName":"","updateUser":"koala","page":0,"pagesize":0}]}],"arrivalTime":"2020-11-07","arrivalTimeEnd":null}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("result", result.getData());
		
		return "/domain/WayBill-update";
	}
	
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping("/updateYd")
	public InvokeResult update(MultipartHttpServletRequest fileRequest,
							@RequestParam("ydArrJson")String ydArrJson,
							@RequestParam("xzArrJson")String xzArrJson,
							@RequestParam("spArrJson")String spArrJson,
							HttpServletRequest request) {
		InvokeResult result = new InvokeResult();
		System.out.println("ydArrJson"+ydArrJson);
		System.out.println("xzArrJson"+xzArrJson);
		System.out.println("spArrJson"+spArrJson);
		
		try {
 			WayBillDTO wayBillDto = JacksonUtil.json2object(ydArrJson.replaceAll("[+]", " "), WayBillDTO[].class,true)[0];
 			WayBillDTO olddto = wayBillFacade.getByWaybillId(wayBillDto.getWaybillId());
 	        if (olddto == null) {
 	            return InvokeResult.failure("运单号：" + wayBillDto.getWaybillId() + "不存在！");
 	        }
 			
			wayBillDto.setUpdateTime(new Date());
			wayBillDto.setUpdateUser(CurrentUser.getUserAccount());
			wayBillFacade.updateWayBill(wayBillDto);
			
			List<BoxDTO> list = (List<BoxDTO>)JacksonUtil.json2List(xzArrJson.replaceAll("[+]", " "), new TypeReference<List<BoxDTO>>() {},true);
			for(BoxDTO dto:list){
				dto.setUpdateTime(new Date());
				dto.setUpdateUser(CurrentUser.getUserAccount());
				boxFacade.updateBox(dto);
			}
			List<BillGoodsDTO> list2 = (List<BillGoodsDTO>)JacksonUtil.json2List(spArrJson.replaceAll("[+]", " "), new TypeReference<List<BillGoodsDTO>>() {},true);
			
			int k = 0;
			List<MultipartFile> fileList = fileRequest.getFiles("file");
				
			for(BillGoodsDTO dto:list2){
				dto.setUpdateTime(new Date());
				dto.setUpdateUser(CurrentUser.getUserAccount());
				if(StringUtils.isNotEmpty(dto.getImgFlag()) && fileList.size() > k){
					
					String image = uploadFile(fileList.get(k), request);
					dto.setImage(image);
					k++;
				}
				billGoodsFacade.updateBillGoods(dto);
			}		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
		
//    @InitBinder    
//    public void initBinder(WebDataBinder binder) {  
//    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
//        dateFormat.setLenient(false);    
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
//        //CustomDateEditor 可以换成自己定义的编辑器。  
//        //注册一个Date 类型的绑定器 。
//        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
//    }
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
