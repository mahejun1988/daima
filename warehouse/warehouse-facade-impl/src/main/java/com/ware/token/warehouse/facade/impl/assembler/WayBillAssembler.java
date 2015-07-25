package com.ware.token.warehouse.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.core.domain.*;

public class WayBillAssembler {
	
	public static WayBillDTO  toDTO(WayBill  wayBill){
		if (wayBill == null) {
			return null;
		}
    	WayBillDTO result  = new WayBillDTO();
	    	result.setId (wayBill.getId());
     	    	result.setVersion (wayBill.getVersion());
     	    	result.setWaybillId (wayBill.getWaybillId());
     	    	result.setWayBillFrom (wayBill.getWayBillFrom());
     	    	result.setWayBillInternet (wayBill.getWayBillInternet());
     	    	result.setWayBillCoo (wayBill.getWayBillCoo());
     		    result.setJpyPrice (wayBill.getJpyPrice());
     		    result.setCnyPrice (wayBill.getCnyPrice());
     		    result.setUsdPrice (wayBill.getUsdPrice());
     		    result.setEurPrice (wayBill.getEurPrice()); 
     	    	result.setWayBillNum (wayBill.getWayBillNum());
     	    	result.setArrivalTime (wayBill.getArrivalTime());
     	    	result.setOutFlag (wayBill.getOutFlag());
	     	    if(wayBill.getOutFlag() != null && "2".equals(wayBill.getOutFlag())){
	     	    	result.setOutFlagName("YES");
	     	    }else{
	     	    	result.setOutFlagName ("NO");
	     	    }
     	    	result.setOutTime(wayBill.getOUT_Time());
     	    	result.setCreateTime (wayBill.getCreateTime());
     	    	result.setCreateUser (wayBill.getCreateUser());
     	    	result.setUpdateTime (wayBill.getUpdateTime());
     	    	result.setUpdateUser (wayBill.getUpdateUser());
     	    return result;
	 }
	
	public static List<WayBillDTO>  toDTOs(Collection<WayBill>  wayBills){
		if (wayBills == null) {
			return null;
		}
		List<WayBillDTO> results = new ArrayList<WayBillDTO>();
		for (WayBill each : wayBills) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static WayBill  toEntity(WayBillDTO  wayBillDTO){
	 	if (wayBillDTO == null) {
			return null;
		}
	 	WayBill result  = new WayBill();
        result.setId (wayBillDTO.getId());
         result.setVersion (wayBillDTO.getVersion());
         result.setWaybillId (wayBillDTO.getWaybillId());
         result.setWayBillFrom (wayBillDTO.getWayBillFrom());
         result.setWayBillInternet (wayBillDTO.getWayBillInternet());
         result.setWayBillCoo (wayBillDTO.getWayBillCoo());
         result.setWayBillNum (wayBillDTO.getWayBillNum());
         result.setArrivalTime (wayBillDTO.getArrivalTime());
	    result.setJpyPrice (wayBillDTO.getJpyPrice());
	    result.setCnyPrice (wayBillDTO.getCnyPrice());
	    result.setUsdPrice (wayBillDTO.getUsdPrice());
	    result.setEurPrice (wayBillDTO.getEurPrice());        
         
         
         result.setOutFlag (wayBillDTO.getOutFlag());
         result.setOUT_Time (wayBillDTO.getOutTime());
         result.setCreateTime (wayBillDTO.getCreateTime());
         result.setCreateUser (wayBillDTO.getCreateUser());
         result.setUpdateTime (wayBillDTO.getUpdateTime());
         result.setUpdateUser (wayBillDTO.getUpdateUser());
 	  	return result;
	 }
	
	public static List<WayBill> toEntities(Collection<WayBillDTO> wayBillDTOs) {
		if (wayBillDTOs == null) {
			return null;
		}
		
		List<WayBill> results = new ArrayList<WayBill>();
		for (WayBillDTO each : wayBillDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
