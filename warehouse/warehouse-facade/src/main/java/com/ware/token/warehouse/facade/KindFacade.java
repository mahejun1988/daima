package com.ware.token.warehouse.facade;

import java.util.List;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import com.ware.token.warehouse.facade.dto.*;

public interface KindFacade {

	public InvokeResult getKind(Long id);
	
	public InvokeResult creatKind(KindDTO kind);
	
	public InvokeResult updateKind(KindDTO kind);
	
	public InvokeResult removeKind(Long id);
	
	public InvokeResult removeKinds(Long[] ids);
	
	public List<KindDTO> findAllKind();
	
	public Page<KindDTO> pageQueryKind(KindDTO kind, int currentPage, int pageSize);

	public int getMaxIdByCodeType(KindDTO kindDTO);
	

}

