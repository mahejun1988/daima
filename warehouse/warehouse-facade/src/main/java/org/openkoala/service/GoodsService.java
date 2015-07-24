package org.openkoala.service;

import java.util.List;
import java.util.Map;

import com.ware.token.warehouse.facade.model.Goods;

public interface GoodsService {

	int countQuery(Goods goodsDTO);

	List<Map<String,String>> QueryByPage(Goods goodsDTO);

	int deleteBox(String wayBillId);

	int deleteGoods(String wayBillId);

}
