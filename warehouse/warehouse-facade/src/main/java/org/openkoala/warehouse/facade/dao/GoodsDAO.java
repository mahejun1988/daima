package org.openkoala.warehouse.facade.dao;

import java.util.List;
import java.util.Map;

import com.ware.token.warehouse.facade.model.Goods;

public interface GoodsDAO{

	public int countQuery(Goods goods);

	public List<Map<String,String>> QueryByPage(Goods goods);

	public int deleteBox(String wayBillId);

	public int deleteGoods(String wayBillId);
			
	
}
