package com.ware.token.warehouse.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.core.domain.*;

public class KindAssembler {
	
	public static KindDTO  toDTO(Kind  kind){
		if (kind == null) {
			return null;
		}
    	KindDTO result  = new KindDTO();
	    	result.setId (kind.getId());
     	    	result.setVersion (kind.getVersion());
     	    	result.setCreateTime (kind.getCreateTime());
     	    	result.setCreateUser (kind.getCreateUser());
     	    	result.setUpdateTime (kind.getUpdateTime());
     	    	result.setUpdateUser (kind.getUpdateUser());
     	    	result.setCodeType (kind.getCodeType());
     	    	result.setTypeName (kind.getTypeName());
     	    	result.setUpCode (kind.getUpCode());
     	    	result.setCode (kind.getCode());
     	    	result.setCodeName (kind.getCodeName());
     	    	result.setRemark (kind.getRemark());
     	    return result;
	 }
	
	public static List<KindDTO>  toDTOs(Collection<Kind>  kinds){
		if (kinds == null) {
			return null;
		}
		List<KindDTO> results = new ArrayList<KindDTO>();
		for (Kind each : kinds) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static Kind  toEntity(KindDTO  kindDTO){
	 	if (kindDTO == null) {
			return null;
		}
	 	Kind result  = new Kind();
        result.setId (kindDTO.getId());
         result.setVersion (kindDTO.getVersion());
         result.setCreateTime (kindDTO.getCreateTime());
         result.setCreateUser (kindDTO.getCreateUser());
         result.setUpdateTime (kindDTO.getUpdateTime());
         result.setUpdateUser (kindDTO.getUpdateUser());
         result.setCodeType (kindDTO.getCodeType());
         result.setTypeName (kindDTO.getTypeName());
         result.setUpCode (kindDTO.getUpCode());
         result.setCode (kindDTO.getCode());
         result.setCodeName (kindDTO.getCodeName());
         result.setRemark (kindDTO.getRemark());
 	  	return result;
	 }
	
	public static List<Kind> toEntities(Collection<KindDTO> kindDTOs) {
		if (kindDTOs == null) {
			return null;
		}
		
		List<Kind> results = new ArrayList<Kind>();
		for (KindDTO each : kindDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
