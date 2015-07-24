package com.ware.token.warehouse.facade.impl;

import java.util.Date;
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
import org.openkoala.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.facade.impl.assembler.BillGoodsAssembler;
import com.ware.token.warehouse.facade.impl.assembler.BoxAssembler;
import com.ware.token.warehouse.facade.impl.assembler.WayBillAssembler;
import com.ware.token.warehouse.facade.WayBillFacade;
import com.ware.token.warehouse.application.BillGoodsApplication;
import com.ware.token.warehouse.application.BoxApplication;
import com.ware.token.warehouse.application.WayBillApplication;
import com.ware.token.warehouse.core.domain.*;

@Named
public class WayBillFacadeImpl implements WayBillFacade {
	private static final Logger LOGGER = LoggerFactory.getLogger(WayBillFacadeImpl.class);
	@Inject
	private WayBillApplication  application;
	@Inject
	private BoxApplication  boxApplication;
	@Inject
	private BillGoodsApplication  billGoodsApplication;
	@Inject
	private GoodsService goodsService;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getWayBill(Long id) {
		WayBill wayBill = application.getWayBill(id);
		WayBillDTO wayBillDto = WayBillAssembler.toDTO(wayBill);
		
		
		List<Box> listBox = boxApplication.getBoxByWayBillId(wayBill.getWaybillId());
		List<BoxDTO> boxDto = BoxAssembler.toDTOs(listBox);
		for(BoxDTO dto: boxDto){
			List<BillGoods> listGoods = billGoodsApplication.getByBoxId(wayBill.getWaybillId(),dto.getBoxId());
			List<BillGoodsDTO> billGoodsDto = BillGoodsAssembler.toDTOs(listGoods);
			dto.setList(billGoodsDto);
		}
		
		wayBillDto.setList(boxDto);
		
		return InvokeResult.success(wayBillDto);
//		return InvokeResult.success(WayBillAssembler.toDTO(application.getWayBill(id)));
	}
	
	public InvokeResult creatWayBill(WayBillDTO wayBillDTO) {
		application.creatWayBill(WayBillAssembler.toEntity(wayBillDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateWayBill(WayBillDTO wayBillDTO) {
		application.updateWayBill(WayBillAssembler.toEntity(wayBillDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeWayBill(Long id) {
		WayBill wayBill = application.getWayBill(id);
		application.removeWayBill(wayBill);
		goodsService.deleteBox(wayBill.getWaybillId());
		goodsService.deleteGoods(wayBill.getWaybillId());
		return InvokeResult.success();
	}
	
	public InvokeResult removeWayBills(Long[] ids) {
		Set<WayBill> wayBills= new HashSet<WayBill>();
		for (Long id : ids) {
			WayBill wayBill = application.getWayBill(id);
			wayBills.add(wayBill);
			goodsService.deleteBox(wayBill.getWaybillId());
			goodsService.deleteGoods(wayBill.getWaybillId());
		}
		application.removeWayBills(wayBills);
		
		
		return InvokeResult.success();
	}
	
	public List<WayBillDTO> findAllWayBill() {
		return WayBillAssembler.toDTOs(application.findAllWayBill());
	}
	
	public Page<WayBillDTO> pageQueryWayBill(WayBillDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _wayBill from WayBill _wayBill   where 1=1 ");
	   	if (queryVo.getWaybillId() != null && !"".equals(queryVo.getWaybillId())) {
	   		jpql.append(" and _wayBill.waybillId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWaybillId()));
	   	}		
	   	if (queryVo.getWayBillFrom() != null && !"".equals(queryVo.getWayBillFrom())) {
	   		jpql.append(" and _wayBill.wayBillFrom like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWayBillFrom()));
	   	}		
	   	if (queryVo.getWayBillInternet() != null && !"".equals(queryVo.getWayBillInternet())) {
	   		jpql.append(" and _wayBill.wayBillInternet like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWayBillInternet()));
	   	}		
	   	if (queryVo.getWayBillCoo() != null && !"".equals(queryVo.getWayBillCoo())) {
	   		jpql.append(" and _wayBill.wayBillCoo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWayBillCoo()));
	   	}		
	   	if (queryVo.getWayBillNum() != null && !"".equals(queryVo.getWayBillNum())) {
	   		jpql.append(" and _wayBill.wayBillNum like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWayBillNum()));
	   	}		
	   	if (queryVo.getArrivalTime() != null) {
	   		jpql.append(" and _wayBill.ArrivalTime between ? and ? ");
	   		conditionVals.add(queryVo.getArrivalTime());
	   		conditionVals.add(queryVo.getArrivalTimeEnd());
	   	}	
	   	if (queryVo.getOutFlag() != null && !"".equals(queryVo.getOutFlag())) {
	   		jpql.append(" and _wayBill.outFlag like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOutFlag()));
	   	}		
	   	if (queryVo.getOutTime() != null) {
	   		jpql.append(" and _wayBill.OUT_Time between ? and ? ");
	   		conditionVals.add(queryVo.getOutTime());
	   		conditionVals.add(queryVo.getOutTimeEnd());
	   	}	
	   	if (queryVo.getCreateTime() != null) {
	   		jpql.append(" and _wayBill.createDate between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTime());
	   		conditionVals.add(queryVo.getCreateTimeEnd());
	   	}	
	   	if (queryVo.getCreateUser() != null && !"".equals(queryVo.getCreateUser())) {
	   		jpql.append(" and _wayBill.createUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateUser()));
	   	}		
	   	if (queryVo.getUpdateTime() != null) {
	   		jpql.append(" and _wayBill.updateDate between ? and ? ");
	   		conditionVals.add(queryVo.getUpdateTime());
	   		conditionVals.add(queryVo.getUpdateTimeEnd());
	   	}	
	   	if (queryVo.getUpdateUser() != null && !"".equals(queryVo.getUpdateUser())) {
	   		jpql.append(" and _wayBill.updateUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getUpdateUser()));
	   	}

	   	// 增加排序
	   	jpql.append(" ORDER BY out_flag ,create_time ");
	   	
        Page<WayBill> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<WayBillDTO>(pages.getStart(), pages.getResultCount(),pageSize, WayBillAssembler.toDTOs(pages.getData()));
	}

	@Override
	public InvokeResult outWayBill(WayBillDTO wayBillDTO) {
	        try {
	        	WayBill wayBill = application.getByWaybillId(wayBillDTO.getWaybillId());
	            if (wayBill.getOutFlag() != null && wayBill.getOutFlag().equals(2)) {
	                return InvokeResult.failure("运单号：" + wayBill.getWaybillId() + "已经出库完了，不需要再次出库！");
	            }
	            wayBill.setOutFlag("2");
	            wayBill.setOUT_Time(new Date());
	            wayBill.setUpdateTime(new Date());
	            wayBill.setUpdateUser(wayBillDTO.getUpdateUser());
	            application.updateWayBill(wayBill);
	            return InvokeResult.success();
	        } catch (Exception e) {
	            LOGGER.error(e.getMessage(), e);
	            return InvokeResult.failure("快速出库失败"+e);
	        }
	}
	
	@Override
	public List<WayBillDTO> getAllCoo() {
		return WayBillAssembler.toDTOs(application.findAllWayBill());
	}

	@Override
	public InvokeResult outByWayBillId(String[] idArrs,String user) {
		for (String id : idArrs) {
			WayBill bill = new WayBill();
			bill = application.getByWaybillId(id);
			bill.setOUT_Time(new Date());
			bill.setOutFlag("2");
			bill.setUpdateTime(new Date());
			bill.setUpdateUser(user);
			application.updateWayBill(bill);
		}
		
		return InvokeResult.success();
	}

	@Override
	public WayBillDTO getByWaybillId(String waybillId) {
		WayBillDTO dto = null;
		WayBill wayBill = application.getByWaybillId(waybillId);
		if(wayBill != null){
			dto =  new WayBillDTO();
			dto.setWaybillId(wayBill.getWaybillId());
		}
        return dto;
	}
	
	
}
