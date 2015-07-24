package com.ware.token.warehouse.facade;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import com.ware.token.warehouse.facade.dto.*;

public interface BillGoodsFacade {

	public InvokeResult getBillGoods(Long id);
	
	public InvokeResult creatBillGoods(BillGoodsDTO billGoods);
	
	public InvokeResult updateBillGoods(BillGoodsDTO billGoods);
	
	public InvokeResult removeBillGoods(Long id);
	
	public InvokeResult removeBillGoodss(Long[] ids);
	
	public List<BillGoodsDTO> findAllBillGoods();
	
	public Page<BillGoodsDTO> pageQueryBillGoods(BillGoodsDTO billGoods, int currentPage, int pageSize);

	public HSSFWorkbook export(List<Map<String, String>> list,String[] excelHeader);
	

}

