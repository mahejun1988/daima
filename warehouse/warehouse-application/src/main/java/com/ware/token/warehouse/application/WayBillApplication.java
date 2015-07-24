package com.ware.token.warehouse.application;


import java.util.List;
import java.util.Set;

import  com.ware.token.warehouse.core.domain.WayBill;

public interface WayBillApplication {

	public WayBill getWayBill(Long id);
	
	public void creatWayBill(WayBill wayBill);
	
	public void updateWayBill(WayBill wayBill);
	
	public void removeWayBill(WayBill wayBill);
	
	public void removeWayBills(Set<WayBill> wayBills);
	
	public List<WayBill> findAllWayBill();

	public WayBill getByWaybillId(String waybillId);
	
}

