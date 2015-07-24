package com.ware.token.warehouse.application;


import java.util.List;
import java.util.Set;
import  com.ware.token.warehouse.core.domain.Goods;

public interface GoodsApplication {

	public Goods getGoods(Long id);
	
	public void creatGoods(Goods goods);
	
	public void updateGoods(Goods goods);
	
	public void removeGoods(Goods goods);
	
	public void removeGoodss(Set<Goods> goodss);
	
	public List<Goods> findAllGoods();
	
}

