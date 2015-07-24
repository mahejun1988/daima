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
import com.ware.token.warehouse.facade.impl.assembler.KindAssembler;
import com.ware.token.warehouse.facade.KindFacade;
import com.ware.token.warehouse.application.KindApplication;
import com.ware.token.warehouse.core.domain.*;

@Named
public class KindFacadeImpl implements KindFacade {

	@Inject
	private KindApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getKind(Long id) {
		return InvokeResult.success(KindAssembler.toDTO(application.getKind(id)));
	}
	
	public InvokeResult creatKind(KindDTO kindDTO) {
		application.creatKind(KindAssembler.toEntity(kindDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateKind(KindDTO kindDTO) {
		application.updateKind(KindAssembler.toEntity(kindDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeKind(Long id) {
		application.removeKind(application.getKind(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeKinds(Long[] ids) {
		Set<Kind> kinds= new HashSet<Kind>();
		for (Long id : ids) {
			kinds.add(application.getKind(id));
		}
		application.removeKinds(kinds);
		return InvokeResult.success();
	}
	
	public List<KindDTO> findAllKind() {
		return KindAssembler.toDTOs(application.findAllKind());
	}
	
	public Page<KindDTO> pageQueryKind(KindDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _kind from Kind _kind   where 1=1 ");
	   	if (queryVo.getCreateTime() != null) {
	   		jpql.append(" and _kind.createTime between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTime());
	   		conditionVals.add(queryVo.getCreateTimeEnd());
	   	}	
	   	if (queryVo.getCreateUser() != null && !"".equals(queryVo.getCreateUser())) {
	   		jpql.append(" and _kind.createUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateUser()));
	   	}		
	   	if (queryVo.getUpdateTime() != null) {
	   		jpql.append(" and _kind.updateTime between ? and ? ");
	   		conditionVals.add(queryVo.getUpdateTime());
	   		conditionVals.add(queryVo.getUpdateTimeEnd());
	   	}	
	   	if (queryVo.getUpdateUser() != null && !"".equals(queryVo.getUpdateUser())) {
	   		jpql.append(" and _kind.updateUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getUpdateUser()));
	   	}		
	   	if (queryVo.getCodeType() != null && !"".equals(queryVo.getCodeType())) {
	   		jpql.append(" and _kind.codeType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCodeType()));
	   	}		
	   	if (queryVo.getTypeName() != null && !"".equals(queryVo.getTypeName())) {
	   		jpql.append(" and _kind.typeName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTypeName()));
	   	}		
	   	if (queryVo.getUpCode() != null && !"".equals(queryVo.getUpCode())) {
	   		jpql.append(" and _kind.upCode like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getUpCode()));
	   	}		
	   	if (queryVo.getCode() != null && !"".equals(queryVo.getCode())) {
	   		jpql.append(" and _kind.code like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCode()));
	   	}		
	   	if (queryVo.getCodeName() != null && !"".equals(queryVo.getCodeName())) {
	   		jpql.append(" and _kind.codeName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCodeName()));
	   	}		
	   	if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
	   		jpql.append(" and _kind.remark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
	   	}		
        @SuppressWarnings("unchecked")
		Page<Kind> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<KindDTO>(pages.getStart(), pages.getResultCount(),pageSize, KindAssembler.toDTOs(pages.getData()));
	}

	@Override
	public int getMaxIdByCodeType(KindDTO kindDTO) {
		int id = application.getMaxIdByCodeType(kindDTO.getCodeType());
		return id;
	}
	
	
}
