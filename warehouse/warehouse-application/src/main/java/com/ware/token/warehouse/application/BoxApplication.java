package com.ware.token.warehouse.application;


import java.util.List;
import java.util.Set;

import  com.ware.token.warehouse.core.domain.Box;

public interface BoxApplication {

	public Box getBox(Long id);
	
	public void creatBox(Box box);
	
	public void updateBox(Box box);
	
	public void removeBox(Box box);
	
	public void removeBoxs(Set<Box> boxs);
	
	public List<Box> findAllBox();

	public List<Box> getBoxByWayBillId(String id);
	
}

