package com.ware.token.warehouse.application;


import java.util.List;
import java.util.Set;

import  com.ware.token.warehouse.core.domain.BillGoods;

public interface BillGoodsApplication {

	public BillGoods getBillGoods(Long id);
	
	public void creatBillGoods(BillGoods billGoods);
	
	public void updateBillGoods(BillGoods billGoods);
	
	public void removeBillGoods(BillGoods billGoods);
	
	public void removeBillGoodss(Set<BillGoods> billGoodss);
	
	public List<BillGoods> findAllBillGoods();

	public List<BillGoods> getByBoxId(String wayBillId, String boxId);
	
}

