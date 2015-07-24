package com.ware.token.warehouse.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import com.ware.token.warehouse.facade.dto.*;

public interface BoxFacade {

	public InvokeResult getBox(Long id);
	
	public InvokeResult creatBox(BoxDTO box);
	
	public InvokeResult updateBox(BoxDTO box);
	
	public InvokeResult removeBox(Long id);
	
	public InvokeResult removeBoxs(Long[] ids);
	
	public List<BoxDTO> findAllBox();
	
	public Page<BoxDTO> pageQueryBox(BoxDTO box, int currentPage, int pageSize);
	

}

