package com.ware.token.warehouse.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import com.ware.token.warehouse.application.GoodsApplication;
import com.ware.token.warehouse.core.domain.Goods;

@Named
@Transactional
public class GoodsApplicationImpl implements GoodsApplication {

	public Goods getGoods(Long id) {
		return Goods.get(Goods.class, id);
	}
	
	public void creatGoods(Goods goods) {
		goods.save();
	}
	
	public void updateGoods(Goods goods) {
		goods .save();
	}
	
	public void removeGoods(Goods goods) {
		if(goods != null){
			goods.remove();
		}
	}
	
	public void removeGoodss(Set<Goods> goodss) {
		for (Goods goods : goodss) {
			goods.remove();
		}
	}
	
	public List<Goods> findAllGoods() {
		return Goods.findAll(Goods.class);
	}
	
}
