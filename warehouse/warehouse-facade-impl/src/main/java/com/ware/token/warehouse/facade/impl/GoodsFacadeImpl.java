package com.ware.token.warehouse.facade.impl;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;

import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.facade.impl.assembler.GoodsAssembler;
import com.ware.token.warehouse.facade.model.Kind;
import com.ware.token.warehouse.facade.GoodsFacade;
import com.ware.token.warehouse.application.GoodsApplication;
import com.ware.token.warehouse.core.domain.*;

@Named
public class GoodsFacadeImpl implements GoodsFacade {

	@Inject
	private GoodsApplication  application;

	private QueryChannelService queryChannel;
	
	@Autowired
	private KindService kindService;
	

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getGoods(Long id) {
		Goods goods = application.getGoods(id);
		getKindByGoods(goods); 
		return InvokeResult.success(GoodsAssembler.toDTO(goods));
	}
	
	public InvokeResult creatGoods(GoodsDTO goodsDTO) {
		application.creatGoods(GoodsAssembler.toEntity(goodsDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateGoods(GoodsDTO goodsDTO) {
		application.updateGoods(GoodsAssembler.toEntity(goodsDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeGoods(Long id) {
		application.removeGoods(application.getGoods(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeGoodss(Long[] ids) {
		Set<Goods> goodss= new HashSet<Goods>();
		for (Long id : ids) {
			goodss.add(application.getGoods(id));
		}
		application.removeGoodss(goodss);
		return InvokeResult.success();
	}
	
	public List<GoodsDTO> findAllGoods() {
		return GoodsAssembler.toDTOs(application.findAllGoods());
	}
	
	@SuppressWarnings("unchecked")
	public Page<GoodsDTO> pageQueryGoods(GoodsDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _goods from Goods _goods   where 1=1 ");
	   	if (queryVo.getCreateTime() != null) {
	   		jpql.append(" and _goods.createTime between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTime());
	   		conditionVals.add(queryVo.getCreateTimeEnd());
	   	}	
	   	if (queryVo.getCreateUser() != null && !"".equals(queryVo.getCreateUser())) {
	   		jpql.append(" and _goods.createUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateUser()));
	   	}		
	   	if (queryVo.getUpdateTime() != null) {
	   		jpql.append(" and _goods.updateTime between ? and ? ");
	   		conditionVals.add(queryVo.getUpdateTime());
	   		conditionVals.add(queryVo.getUpdateTimeEnd());
	   	}	
	   	if (queryVo.getUpdateUser() != null && !"".equals(queryVo.getUpdateUser())) {
	   		jpql.append(" and _goods.updateUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getUpdateUser()));
	   	}		
	   	if (queryVo.getGoodsId() != null && !"".equals(queryVo.getGoodsId())) {
	   		jpql.append(" and _goods.goodsId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getGoodsId()));
	   	}		
	   	if (queryVo.getGoodsName() != null && !"".equals(queryVo.getGoodsName())) {
	   		jpql.append(" and _goods.goodsName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getGoodsName()));
	   	}
	   	if (queryVo.getGoodsNum() != null && !"".equals(queryVo.getGoodsNum())) {
	   		jpql.append(" and _goods.goodsNum like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getGoodsName()));
	   	}
	   	if (queryVo.getGoodsType() != null && !"".equals(queryVo.getGoodsType())) {
	   		jpql.append(" and _goods.goodsType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getGoodsType()));
	   	}		
	   	if (queryVo.getJpyPrice() != null && !"".equals(queryVo.getJpyPrice())) {
	   		jpql.append(" and _goods.jpyPrice like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getJpyPrice()));
	   	}		
	   	if (queryVo.getCnyPrice() != null && !"".equals(queryVo.getCnyPrice())) {
	   		jpql.append(" and _goods.cnyPrice like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCnyPrice()));
	   	}		
	   	if (queryVo.getUsdPrice() != null && !"".equals(queryVo.getUsdPrice())) {
	   		jpql.append(" and _goods.usdPrice like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getUsdPrice()));
	   	}		
	   	if (queryVo.getEurPrice() != null && !"".equals(queryVo.getEurPrice())) {
	   		jpql.append(" and _goods.eurPrice like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEurPrice()));
	   	}		
	   	if (queryVo.getBigType() != null && !"".equals(queryVo.getBigType())) {
	   		jpql.append(" and _goods.bigType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getBigType()));
	   	}		
	   	if (queryVo.getSmallType() != null && !"".equals(queryVo.getSmallType())) {
	   		jpql.append(" and _goods.smallType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSmallType()));
	   	}		
	   	if (queryVo.getModel() != null && !"".equals(queryVo.getModel())) {
	   		jpql.append(" and _goods.model like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getModel()));
	   	}		
	   	if (queryVo.getCountry() != null && !"".equals(queryVo.getCountry())) {
	   		jpql.append(" and _goods.country like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCountry()));
	   	}		
	   	if (queryVo.getComposition() != null && !"".equals(queryVo.getComposition())) {
	   		jpql.append(" and _goods.composition like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getComposition()));
	   	}		
	   	if (queryVo.getWeight() != null && !"".equals(queryVo.getWeight())) {
	   		jpql.append(" and _goods.weight like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWeight()));
	   	}		
	   	if (queryVo.getLength() != null && !"".equals(queryVo.getLength())) {
	   		jpql.append(" and _goods.length like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLength()));
	   	}		
	   	if (queryVo.getWidth() != null && !"".equals(queryVo.getWidth())) {
	   		jpql.append(" and _goods.width like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWidth()));
	   	}		
	   	if (queryVo.getHeight() != null && !"".equals(queryVo.getHeight())) {
	   		jpql.append(" and _goods.height like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getHeight()));
	   	}		
	   	if (queryVo.getVolume() != null && !"".equals(queryVo.getVolume())) {
	   		jpql.append(" and _goods.volume like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getVolume()));
	   	}		
	   	if (queryVo.getImage() != null && !"".equals(queryVo.getImage())) {
	   		jpql.append(" and _goods.image like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getImage()));
	   	}		
        Page<Goods> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
        getKind(pages); 
        return new Page<GoodsDTO>(pages.getStart(), pages.getResultCount(),pageSize, GoodsAssembler.toDTOs(pages.getData()));
	}
	
	@SuppressWarnings("unchecked")
	public Page<GoodsDTO> getByGoodsId(GoodsDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _goods from Goods _goods   where 1=1 ");
	   	if (queryVo.getGoodsId() != null && !"".equals(queryVo.getGoodsId())) {
	   		jpql.append(" and _goods.goodsId = ?");
	   		conditionVals.add(MessageFormat.format("{0}", queryVo.getGoodsId()));
	   	}		
	   		
        Page<Goods> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
        
        getKind(pages);
        return new Page<GoodsDTO>(pages.getStart(), pages.getResultCount(),pageSize, GoodsAssembler.toDTOs(pages.getData()));
	}
	
	public void getKind(Page<Goods> page){
		for(Goods goods : page.getData()){
 	    	Kind kind = new Kind();
 	    	kind.setCodeType("kind");
 	    	kind.setCode(goods.getBigType());
 	    	List<Kind> list = kindService.getKindByCode(kind);
 	    	if(list.size() > 0){
 	    		goods.setBigType(list.get(0).getCodeName());
 	    	}
 	    	
 	    	Kind kind2 = new Kind();
 	    	kind2.setCodeType("kind");
 	    	kind2.setCode(goods.getSmallType());
 	    	List<Kind> list2 = kindService.getKindByCode(kind2);
 	    	if(list2.size() > 0){
 	    		goods.setSmallType(list2.get(0).getCodeName());
 	    	}
 	    	
 	    	Kind kind3 = new Kind();
 	    	kind3.setCodeType("country");
 	    	kind3.setCode(goods.getCountry());
 	    	List<Kind> list3 = kindService.getKindByCode(kind3);
 	    	if(list3.size() > 0){
 	    		goods.setCountry(list3.get(0).getCodeName());
 	    	}
		}
	}
		
	public void getKindByGoods(Goods goods){
		
			goods.setBigtypeID(goods.getBigType());
			goods.setSmallTypeID(goods.getSmallType());
			goods.setCountryID(goods.getCountry());
			
	    	Kind kind = new Kind();
	    	kind.setCodeType("kind");
	    	kind.setCode(goods.getBigType());
	    	List<Kind> list = kindService.getKindByCode(kind);
	    	if(list.size() > 0){
	    		goods.setBigType(list.get(0).getCodeName());
	    	}
	    	
	    	
	    	Kind kind2 = new Kind();
	    	kind2.setCodeType("kind");
	    	kind2.setCode(goods.getSmallType());
	    	List<Kind> list2 = kindService.getKindByCode(kind2);
	    	if(list2.size() > 0){
	    		goods.setSmallType(list2.get(0).getCodeName());
	    	}
	    	
	    	
	    	Kind kind3 = new Kind();
	    	kind3.setCodeType("country");
	    	kind3.setCode(goods.getCountry());
	    	List<Kind> list3 = kindService.getKindByCode(kind3);
	    	if(list3.size() > 0){
	    		goods.setCountry(list3.get(0).getCodeName());
	    	}
	    	
	}
	
}
