package com.ware.token.warehouse.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.WebDataBinder;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dayatang.utils.Page;

import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.facade.model.Goods;
import com.ware.token.warehouse.facade.BillGoodsFacade;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.service.GoodsService;

@Controller
@RequestMapping("/BillGoods")
public class BillGoodsController {
		
	@Inject
	private BillGoodsFacade billGoodsFacade;
	
	@Autowired
	private GoodsService goodsService;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(BillGoodsDTO billGoodsDTO) {
		return billGoodsFacade.creatBillGoods(billGoodsDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(BillGoodsDTO billGoodsDTO) {
		return billGoodsFacade.updateBillGoods(billGoodsDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(BillGoodsDTO billGoodsDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<BillGoodsDTO> all = billGoodsFacade.pageQueryBillGoods(billGoodsDTO, page, pagesize);
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
        return billGoodsFacade.removeBillGoodss(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return billGoodsFacade.getBillGoods(id);
	}
	
	@ResponseBody
	@RequestMapping("/exportExcel")
	public void exportExcel(Goods goods,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String language = "zh_CN";
		String[] excelHeader = new String[]{ "序号","运单号", "客户编码","物流公司", "购物来源","购物网站","日元","人民币","美元","到货日期","是否出货",
				"箱子重量","箱子长(cm)","箱子宽(cm)","箱子高(cm)","箱子体积重",
				"商品条形码","商品名称","商品规格","数量","单价(日元)","单价(人民币)","单价(美元)","单价(欧元)","种类","细类",
				"品牌","原产国","成分","商品重量(KG)","商品长(cm)","商品宽(cm)","商品高(cm)","商品体积重",
				"出货单号","物流公司","收货地址","客户姓名","是否合箱","箱子重量","箱子长(cm)","箱子宽(cm)","箱子高(cm)","箱子体积重"};
		
		
		if(request.getSession().getAttribute("locale") != null ){
			language = (String)request.getSession().getAttribute("locale");
			if(language.equals("ja_JP")){
				excelHeader = new String[]  {"1","2","3"};
			}else if(language.equals("en_US")){
				excelHeader = new String[] {"A","B","C"};
			}
		}
		
		goods.setPage(Page.getStartOfPage(0, 5000));// 限制5000条
		goods.setPagesize(5000);
		List<Map<String,String>> list = goodsService.QueryByPage(goods);
		
		HSSFWorkbook wb = billGoodsFacade.export(list,excelHeader);    
		response.setContentType("application/vnd.ms-excel");
		UUID filename = UUID.randomUUID();
        response.setHeader("Content-disposition", "attachment;filename="+filename+".xls");
        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
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
	
    public static  void  main(String[] args){
    	String a = "[{'id':'94','version':'2','waybillId':'1222222','wayBillCoo':'12321323','arrivalTime':'2015-07-25+00:00:00','wayBillFrom':'33','wayBillInternet':'','jpyPrice':'','cnyPrice':'','usdPrice':'','eurPrice':'3312','wayBillNum':'1','createTime':'2015-07-25+15:49:05.0','createUser':'koala','outTime':'','outFlag':'NO'}]";
    	System.out.println(a.replaceAll("[+]", " "));
    }
}
