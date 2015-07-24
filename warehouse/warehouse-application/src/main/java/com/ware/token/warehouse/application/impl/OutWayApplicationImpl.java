package com.ware.token.warehouse.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import com.ware.token.warehouse.application.OutWayApplication;
import com.ware.token.warehouse.core.domain.OutWay;

@Named
@Transactional
public class OutWayApplicationImpl implements OutWayApplication {

	public OutWay getOutWay(Long id) {
		return OutWay.get(OutWay.class, id);
	}
	
	public void creatOutWay(OutWay outWay) {
		outWay.save();
	}
	
	public void updateOutWay(OutWay outWay) {
		outWay .save();
	}
	
	public void removeOutWay(OutWay outWay) {
		if(outWay != null){
			outWay.remove();
		}
	}
	
	public void removeOutWays(Set<OutWay> outWays) {
		for (OutWay outWay : outWays) {
			outWay.remove();
		}
	}
	
	public List<OutWay> findAllOutWay() {
		return OutWay.findAll(OutWay.class);
	}
	
}
