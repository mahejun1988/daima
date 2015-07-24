package com.ware.token.warehouse.application.impl;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.ware.token.warehouse.application.BillGoodsApplication;
import com.ware.token.warehouse.application.BoxApplication;
import com.ware.token.warehouse.core.domain.Box;

@Named
@Transactional
public class BoxApplicationImpl implements BoxApplication {

	public Box getBox(Long id) {
		return Box.get(Box.class, id);
	}
	
	public void creatBox(Box box) {
		box.save();
	}
	
	public void updateBox(Box box) {
		box .save();
	}
	
	public void removeBox(Box box) {
		if(box != null){
			box.remove();
		}
	}
	
	public void removeBoxs(Set<Box> boxs) {
		for (Box box : boxs) {
			box.remove();
		}
	}
	
	public List<Box> findAllBox() {
		return Box.findAll(Box.class);
	}

	@Override
	public List<Box> getBoxByWayBillId(String id) {
		List<Box> boxList = Box.getByBoxId(id);
		return boxList;
	}
	
}
