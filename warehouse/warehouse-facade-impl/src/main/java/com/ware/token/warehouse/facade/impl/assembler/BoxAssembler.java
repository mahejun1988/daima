package com.ware.token.warehouse.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.core.domain.*;

public class BoxAssembler {
	
	public static BoxDTO  toDTO(Box  box){
		if (box == null) {
			return null;
		}
    	BoxDTO result  = new BoxDTO();
	    	result.setId (box.getId());
     	    	result.setVersion (box.getVersion());
     	    	result.setCreateTime (box.getCreateTime());
     	    	result.setCreateUser (box.getCreateUser());
     	    	result.setUpdateTime (box.getUpdateTime());
     	    	result.setUpdateUser (box.getUpdateUser());
     	    	result.setWaybillId (box.getWaybillId());
     	    	result.setBoxId (box.getBoxId());
     	    	result.setWeight (box.getWeight());
     	    	result.setLenght (box.getLenght());
     	    	result.setWidth (box.getWidth());
     	    	result.setHeight (box.getHeight());
     	    	result.setVolume (box.getVolume());
     	    	result.setGoodsNum (box.getGoodsNum());
     	    return result;
	 }
	
	public static List<BoxDTO>  toDTOs(Collection<Box>  boxs){
		if (boxs == null) {
			return null;
		}
		List<BoxDTO> results = new ArrayList<BoxDTO>();
		for (Box each : boxs) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static Box  toEntity(BoxDTO  boxDTO){
	 	if (boxDTO == null) {
			return null;
		}
	 	Box result  = new Box();
        result.setId (boxDTO.getId());
         result.setVersion (boxDTO.getVersion());
         result.setCreateTime (boxDTO.getCreateTime());
         result.setCreateUser (boxDTO.getCreateUser());
         result.setUpdateTime (boxDTO.getUpdateTime());
         result.setUpdateUser (boxDTO.getUpdateUser());
         result.setWaybillId (boxDTO.getWaybillId());
         result.setBoxId (boxDTO.getBoxId());
         result.setWeight (boxDTO.getWeight());
         result.setLenght (boxDTO.getLenght());
         result.setWidth (boxDTO.getWidth());
         result.setHeight (boxDTO.getHeight());
         result.setVolume (boxDTO.getVolume());
         result.setGoodsNum (boxDTO.getGoodsNum());
 	  	return result;
	 }
	
	public static List<Box> toEntities(Collection<BoxDTO> boxDTOs) {
		if (boxDTOs == null) {
			return null;
		}
		
		List<Box> results = new ArrayList<Box>();
		for (BoxDTO each : boxDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
