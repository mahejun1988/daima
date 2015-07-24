package com.ware.token.warehouse.facade;

import java.util.List;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import com.ware.token.warehouse.facade.dto.*;

public interface WayBillFacade {

	public InvokeResult getWayBill(Long id);
	
	public InvokeResult creatWayBill(WayBillDTO wayBill);
	
	public InvokeResult updateWayBill(WayBillDTO wayBill);
	
	public InvokeResult removeWayBill(Long id);
	
	public InvokeResult removeWayBills(Long[] ids);
	
	public List<WayBillDTO> findAllWayBill();
	
	public Page<WayBillDTO> pageQueryWayBill(WayBillDTO wayBill, int currentPage, int pageSize);

	public InvokeResult outWayBill(WayBillDTO wayBillDTO);

	public List<WayBillDTO> getAllCoo();

	public InvokeResult outByWayBillId(String[] idArrs,String user);

	public WayBillDTO getByWaybillId(String waybillId);
	

}

