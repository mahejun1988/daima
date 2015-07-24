package com.ware.token.warehouse.facade;

import java.util.List;
import java.util.Map;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import com.ware.token.warehouse.facade.dto.*;

public interface GoodsFacade {

	public InvokeResult getGoods(Long id);
	
	public InvokeResult creatGoods(GoodsDTO goods);
	
	public InvokeResult updateGoods(GoodsDTO goods);
	
	public InvokeResult removeGoods(Long id);
	
	public InvokeResult removeGoodss(Long[] ids);
	
	public List<GoodsDTO> findAllGoods();
	
	public Page<GoodsDTO> pageQueryGoods(GoodsDTO goods, int currentPage, int pageSize);

	public Page<GoodsDTO> getByGoodsId(GoodsDTO goodsDTO, int page, int pagesize);
	

}

