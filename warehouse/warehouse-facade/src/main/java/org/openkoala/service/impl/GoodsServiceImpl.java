package org.openkoala.service.impl;

import java.util.List;
import java.util.Map;

import org.openkoala.service.GoodsService;
import org.openkoala.warehouse.facade.dao.GoodsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ware.token.warehouse.facade.model.Goods;


@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDAO goodsDAO;

	@Override
	public int countQuery(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDAO.countQuery(goods);
	}

	@Override
	public List<Map<String,String>> QueryByPage(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDAO.QueryByPage(goods);
	}

	@Override
	public int deleteBox(String wayBillId) {
		// TODO Auto-generated method stub
		return goodsDAO.deleteBox(wayBillId);
	}

	@Override
	public int deleteGoods(String wayBillId) {
		// TODO Auto-generated method stub
		return goodsDAO.deleteGoods(wayBillId);
	}

}
