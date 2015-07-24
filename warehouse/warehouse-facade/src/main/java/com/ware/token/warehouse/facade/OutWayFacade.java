package com.ware.token.warehouse.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import com.ware.token.warehouse.facade.dto.*;

public interface OutWayFacade {

	public InvokeResult getOutWay(Long id);
	
	public InvokeResult creatOutWay(OutWayDTO outWay);
	
	public InvokeResult updateOutWay(OutWayDTO outWay);
	
	public InvokeResult removeOutWay(Long id);
	
	public InvokeResult removeOutWays(Long[] ids);
	
	public List<OutWayDTO> findAllOutWay();
	
	public Page<OutWayDTO> pageQueryOutWay(OutWayDTO outWay, int currentPage, int pageSize);
	

}

