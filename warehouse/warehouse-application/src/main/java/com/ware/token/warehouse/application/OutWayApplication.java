package com.ware.token.warehouse.application;


import java.util.List;
import java.util.Set;
import  com.ware.token.warehouse.core.domain.OutWay;

public interface OutWayApplication {

	public OutWay getOutWay(Long id);
	
	public void creatOutWay(OutWay outWay);
	
	public void updateOutWay(OutWay outWay);
	
	public void removeOutWay(OutWay outWay);
	
	public void removeOutWays(Set<OutWay> outWays);
	
	public List<OutWay> findAllOutWay();
	
}

