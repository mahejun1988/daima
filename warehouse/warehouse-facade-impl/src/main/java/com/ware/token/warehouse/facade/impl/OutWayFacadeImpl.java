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
import com.ware.token.warehouse.facade.impl.assembler.OutWayAssembler;
import com.ware.token.warehouse.facade.OutWayFacade;
import com.ware.token.warehouse.application.OutWayApplication;

import com.ware.token.warehouse.core.domain.*;

@Named
public class OutWayFacadeImpl implements OutWayFacade {

	@Inject
	private OutWayApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getOutWay(Long id) {
		return InvokeResult.success(OutWayAssembler.toDTO(application.getOutWay(id)));
	}
	
	public InvokeResult creatOutWay(OutWayDTO outWayDTO) {
		application.creatOutWay(OutWayAssembler.toEntity(outWayDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateOutWay(OutWayDTO outWayDTO) {
		application.updateOutWay(OutWayAssembler.toEntity(outWayDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeOutWay(Long id) {
		application.removeOutWay(application.getOutWay(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeOutWays(Long[] ids) {
		Set<OutWay> outWays= new HashSet<OutWay>();
		for (Long id : ids) {
			outWays.add(application.getOutWay(id));
		}
		application.removeOutWays(outWays);
		return InvokeResult.success();
	}
	
	public List<OutWayDTO> findAllOutWay() {
		return OutWayAssembler.toDTOs(application.findAllOutWay());
	}
	
	public Page<OutWayDTO> pageQueryOutWay(OutWayDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _outWay from OutWay _outWay   where 1=1 ");
	   	if (queryVo.getCreateTime() != null) {
	   		jpql.append(" and _outWay.createTime between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTime());
	   		conditionVals.add(queryVo.getCreateTimeEnd());
	   	}	
	   	if (queryVo.getCreateUser() != null && !"".equals(queryVo.getCreateUser())) {
	   		jpql.append(" and _outWay.createUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateUser()));
	   	}		
	   	if (queryVo.getUpdateTime() != null) {
	   		jpql.append(" and _outWay.updateTime between ? and ? ");
	   		conditionVals.add(queryVo.getUpdateTime());
	   		conditionVals.add(queryVo.getUpdateTimeEnd());
	   	}	
	   	if (queryVo.getUpdateUser() != null && !"".equals(queryVo.getUpdateUser())) {
	   		jpql.append(" and _outWay.updateUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getUpdateUser()));
	   	}		
	   	if (queryVo.getWaybillId() != null && !"".equals(queryVo.getWaybillId())) {
	   		jpql.append(" and _outWay.waybillId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWaybillId()));
	   	}		
	   	if (queryVo.getOutWayId() != null && !"".equals(queryVo.getOutWayId())) {
	   		jpql.append(" and _outWay.outWayId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOutWayId()));
	   	}		
	   	if (queryVo.getOutWayCoo() != null && !"".equals(queryVo.getOutWayCoo())) {
	   		jpql.append(" and _outWay.outWayCoo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOutWayCoo()));
	   	}		
	   	if (queryVo.getBoxCount() != null && !"".equals(queryVo.getBoxCount())) {
	   		jpql.append(" and _outWay.boxCount like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getBoxCount()));
	   	}		
	   	if (queryVo.getMerge_Flag() != null && !"".equals(queryVo.getMerge_Flag())) {
	   		jpql.append(" and _outWay.Merge_Flag like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getMerge_Flag()));
	   	}		
	   	if (queryVo.getJpyPrice() != null && !"".equals(queryVo.getJpyPrice())) {
	   		jpql.append(" and _outWay.jpyPrice like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getJpyPrice()));
	   	}		
	   	if (queryVo.getCnyPrice() != null && !"".equals(queryVo.getCnyPrice())) {
	   		jpql.append(" and _outWay.cnyPrice like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCnyPrice()));
	   	}		
	   	if (queryVo.getUsdPrice() != null && !"".equals(queryVo.getUsdPrice())) {
	   		jpql.append(" and _outWay.usdPrice like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getUsdPrice()));
	   	}		
	   	if (queryVo.getEurPrice() != null && !"".equals(queryVo.getEurPrice())) {
	   		jpql.append(" and _outWay.eurPrice like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEurPrice()));
	   	}		
	   	if (queryVo.getWeight() != null && !"".equals(queryVo.getWeight())) {
	   		jpql.append(" and _outWay.weight like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWeight()));
	   	}		
	   	if (queryVo.getLength() != null && !"".equals(queryVo.getLength())) {
	   		jpql.append(" and _outWay.length like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLength()));
	   	}		
	   	if (queryVo.getWidth() != null && !"".equals(queryVo.getWidth())) {
	   		jpql.append(" and _outWay.width like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWidth()));
	   	}		
	   	if (queryVo.getHeight() != null && !"".equals(queryVo.getHeight())) {
	   		jpql.append(" and _outWay.height like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getHeight()));
	   	}		
	   	if (queryVo.getVolume() != null && !"".equals(queryVo.getVolume())) {
	   		jpql.append(" and _outWay.volume like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getVolume()));
	   	}		
	   	if (queryVo.getPickup_Addr() != null && !"".equals(queryVo.getPickup_Addr())) {
	   		jpql.append(" and _outWay.pickup_Addr like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPickup_Addr()));
	   	}		
	   	if (queryVo.getReciever_Addr() != null && !"".equals(queryVo.getReciever_Addr())) {
	   		jpql.append(" and _outWay.reciever_Addr like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getReciever_Addr()));
	   	}		
	   	if (queryVo.getCustomer_ID() != null && !"".equals(queryVo.getCustomer_ID())) {
	   		jpql.append(" and _outWay.Customer_ID like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCustomer_ID()));
	   	}		
	   	if (queryVo.getCustomer_Name() != null && !"".equals(queryVo.getCustomer_Name())) {
	   		jpql.append(" and _outWay.Customer_Name like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCustomer_Name()));
	   	}		
        Page<OutWay> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<OutWayDTO>(pages.getStart(), pages.getResultCount(),pageSize, OutWayAssembler.toDTOs(pages.getData()));
	}
	
	
}
