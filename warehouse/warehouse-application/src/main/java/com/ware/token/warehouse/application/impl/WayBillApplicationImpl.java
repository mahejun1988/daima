package com.ware.token.warehouse.application.impl;

import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.ware.token.warehouse.application.WayBillApplication;
import com.ware.token.warehouse.core.domain.WayBill;

@Named
@Transactional
public class WayBillApplicationImpl implements WayBillApplication {

	public WayBill getWayBill(Long id) {
		return WayBill.get(WayBill.class, id);
	}
	
	public void creatWayBill(WayBill wayBill) {
		wayBill.save();
	}
	
	public void updateWayBill(WayBill wayBill) {
		wayBill .save();
	}
	
	public void removeWayBill(WayBill wayBill) {
		if(wayBill != null){
			wayBill.remove();
		}
	}
	
	public void removeWayBills(Set<WayBill> wayBills) {
		for (WayBill wayBill : wayBills) {
			wayBill.remove();
		}
	}
	
	public List<WayBill> findAllWayBill() {
		return WayBill.findAll(WayBill.class);
	}

	@Override
	public WayBill getByWaybillId(String waybillId) {
		return WayBill.getByWaybillId(waybillId);
	}
	
}
