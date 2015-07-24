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
import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.facade.impl.assembler.BoxAssembler;
import com.ware.token.warehouse.facade.BoxFacade;
import com.ware.token.warehouse.application.BoxApplication;

import com.ware.token.warehouse.core.domain.*;

@Named
public class BoxFacadeImpl implements BoxFacade {

	@Inject
	private BoxApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getBox(Long id) {
		return InvokeResult.success(BoxAssembler.toDTO(application.getBox(id)));
	}
	
	public InvokeResult creatBox(BoxDTO boxDTO) {
		application.creatBox(BoxAssembler.toEntity(boxDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateBox(BoxDTO boxDTO) {
		application.updateBox(BoxAssembler.toEntity(boxDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeBox(Long id) {
		application.removeBox(application.getBox(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeBoxs(Long[] ids) {
		Set<Box> boxs= new HashSet<Box>();
		for (Long id : ids) {
			boxs.add(application.getBox(id));
		}
		application.removeBoxs(boxs);
		return InvokeResult.success();
	}
	
	public List<BoxDTO> findAllBox() {
		return BoxAssembler.toDTOs(application.findAllBox());
	}
	
	public Page<BoxDTO> pageQueryBox(BoxDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _box from Box _box   where 1=1 ");
	   	if (queryVo.getCreateTime() != null) {
	   		jpql.append(" and _box.createTime between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTime());
	   		conditionVals.add(queryVo.getCreateTimeEnd());
	   	}	
	   	if (queryVo.getCreateUser() != null && !"".equals(queryVo.getCreateUser())) {
	   		jpql.append(" and _box.createUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateUser()));
	   	}		
	   	if (queryVo.getUpdateTime() != null) {
	   		jpql.append(" and _box.updateTime between ? and ? ");
	   		conditionVals.add(queryVo.getUpdateTime());
	   		conditionVals.add(queryVo.getUpdateTimeEnd());
	   	}	
	   	if (queryVo.getUpdateUser() != null && !"".equals(queryVo.getUpdateUser())) {
	   		jpql.append(" and _box.updateUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getUpdateUser()));
	   	}		
	   	if (queryVo.getWaybillId() != null && !"".equals(queryVo.getWaybillId())) {
	   		jpql.append(" and _box.waybillId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWaybillId()));
	   	}		
	   	if (queryVo.getBoxId() != null && !"".equals(queryVo.getBoxId())) {
	   		jpql.append(" and _box.boxId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getBoxId()));
	   	}		
	   	if (queryVo.getWeight() != null && !"".equals(queryVo.getWeight())) {
	   		jpql.append(" and _box.weight like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWeight()));
	   	}		
	   	if (queryVo.getLenght() != null && !"".equals(queryVo.getLenght())) {
	   		jpql.append(" and _box.lenght like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLenght()));
	   	}		
	   	if (queryVo.getWidth() != null && !"".equals(queryVo.getWidth())) {
	   		jpql.append(" and _box.width like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWidth()));
	   	}		
	   	if (queryVo.getHeight() != null && !"".equals(queryVo.getHeight())) {
	   		jpql.append(" and _box.height like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getHeight()));
	   	}		
	   	if (queryVo.getVolume() != null && !"".equals(queryVo.getVolume())) {
	   		jpql.append(" and _box.volume like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getVolume()));
	   	}		
	   	if (queryVo.getGoodsNum() != null && !"".equals(queryVo.getGoodsNum())) {
	   		jpql.append(" and _box.goodsNum like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getGoodsNum()));
	   	}		
        Page<Box> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<BoxDTO>(pages.getStart(), pages.getResultCount(),pageSize, BoxAssembler.toDTOs(pages.getData()));
	}
	
	
}
