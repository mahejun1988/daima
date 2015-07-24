package com.ware.token.warehouse.application.impl;

import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.ware.token.warehouse.application.BillGoodsApplication;
import com.ware.token.warehouse.core.domain.BillGoods;

@Named
@Transactional
public class BillGoodsApplicationImpl implements BillGoodsApplication {

	public BillGoods getBillGoods(Long id) {
		return BillGoods.get(BillGoods.class, id);
	}
	
	public void creatBillGoods(BillGoods billGoods) {
		billGoods.save();
	}
	
	public void updateBillGoods(BillGoods billGoods) {
		billGoods .save();
	}
	
	public void removeBillGoods(BillGoods billGoods) {
		if(billGoods != null){
			billGoods.remove();
		}
	}
	
	public void removeBillGoodss(Set<BillGoods> billGoodss) {
		for (BillGoods billGoods : billGoodss) {
			billGoods.remove();
		}
	}
	
	public List<BillGoods> findAllBillGoods() {
		return BillGoods.findAll(BillGoods.class);
	}

	@Override
	public List<BillGoods> getByBoxId(String wayBillId, String boxId) {
		return BillGoods.getByBoxId(wayBillId, boxId);
	}
	
}
