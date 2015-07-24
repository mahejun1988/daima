package com.ware.token.warehouse.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.core.domain.*;

public class OutWayAssembler {
	
	public static OutWayDTO  toDTO(OutWay  outWay){
		if (outWay == null) {
			return null;
		}
    	OutWayDTO result  = new OutWayDTO();
	    	result.setId (outWay.getId());
     	    	result.setVersion (outWay.getVersion());
     	    	result.setCreateTime (outWay.getCreateTime());
     	    	result.setCreateUser (outWay.getCreateUser());
     	    	result.setUpdateTime (outWay.getUpdateTime());
     	    	result.setUpdateUser (outWay.getUpdateUser());
     	    	result.setWaybillId (outWay.getWaybillId());
     	    	result.setOutWayId (outWay.getOutWayId());
     	    	result.setOutWayCoo (outWay.getOutWayCoo());
     	    	result.setBoxCount (outWay.getBoxCount());
     	    	result.setMerge_Flag (outWay.getMerge_Flag());
     	    	result.setJpyPrice (outWay.getJpyPrice());
     	    	result.setCnyPrice (outWay.getCnyPrice());
     	    	result.setUsdPrice (outWay.getUsdPrice());
     	    	result.setEurPrice (outWay.getEurPrice());
     	    	result.setWeight (outWay.getWeight());
     	    	result.setLength (outWay.getLength());
     	    	result.setWidth (outWay.getWidth());
     	    	result.setHeight (outWay.getHeight());
     	    	result.setVolume (outWay.getVolume());
     	    	result.setPickup_Addr (outWay.getPickup_Addr());
     	    	result.setReciever_Addr (outWay.getReciever_Addr());
     	    	result.setCustomer_ID (outWay.getCustomer_ID());
     	    	result.setCustomer_Name (outWay.getCustomer_Name());
     	    return result;
	 }
	
	public static List<OutWayDTO>  toDTOs(Collection<OutWay>  outWays){
		if (outWays == null) {
			return null;
		}
		List<OutWayDTO> results = new ArrayList<OutWayDTO>();
		for (OutWay each : outWays) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static OutWay  toEntity(OutWayDTO  outWayDTO){
	 	if (outWayDTO == null) {
			return null;
		}
	 	OutWay result  = new OutWay();
        result.setId (outWayDTO.getId());
         result.setVersion (outWayDTO.getVersion());
         result.setCreateTime (outWayDTO.getCreateTime());
         result.setCreateUser (outWayDTO.getCreateUser());
         result.setUpdateTime (outWayDTO.getUpdateTime());
         result.setUpdateUser (outWayDTO.getUpdateUser());
         result.setWaybillId (outWayDTO.getWaybillId());
         result.setOutWayId (outWayDTO.getOutWayId());
         result.setOutWayCoo (outWayDTO.getOutWayCoo());
         result.setBoxCount (outWayDTO.getBoxCount());
         result.setMerge_Flag (outWayDTO.getMerge_Flag());
         result.setJpyPrice (outWayDTO.getJpyPrice());
         result.setCnyPrice (outWayDTO.getCnyPrice());
         result.setUsdPrice (outWayDTO.getUsdPrice());
         result.setEurPrice (outWayDTO.getEurPrice());
         result.setWeight (outWayDTO.getWeight());
         result.setLength (outWayDTO.getLength());
         result.setWidth (outWayDTO.getWidth());
         result.setHeight (outWayDTO.getHeight());
         result.setVolume (outWayDTO.getVolume());
         result.setPickup_Addr (outWayDTO.getPickup_Addr());
         result.setReciever_Addr (outWayDTO.getReciever_Addr());
         result.setCustomer_ID (outWayDTO.getCustomer_ID());
         result.setCustomer_Name (outWayDTO.getCustomer_Name());
 	  	return result;
	 }
	
	public static List<OutWay> toEntities(Collection<OutWayDTO> outWayDTOs) {
		if (outWayDTOs == null) {
			return null;
		}
		
		List<OutWay> results = new ArrayList<OutWay>();
		for (OutWayDTO each : outWayDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
