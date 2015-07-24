package com.ware.token.warehouse.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.core.domain.*;

public class BillGoodsAssembler {
	
	public static BillGoodsDTO  toDTO(BillGoods  billGoods){
		if (billGoods == null) {
			return null;
		}
    	BillGoodsDTO result  = new BillGoodsDTO();
	    	result.setId (billGoods.getId());
     	    	result.setVersion (billGoods.getVersion());
     	    	result.setCreateTime (billGoods.getCreateTime());
     	    	result.setCreateUser (billGoods.getCreateUser());
     	    	result.setUpdateTime (billGoods.getUpdateTime());
     	    	result.setUpdateUser (billGoods.getUpdateUser());
     	    	result.setWaybillId (billGoods.getWaybillId());
     	    	result.setBoxId (billGoods.getBoxId());
     	    	result.setGoodsId (billGoods.getGoodsId());
     	    	result.setGoodsName (billGoods.getGoodsName());
     	    	result.setGoodsType (billGoods.getGoodsType());
     	    	result.setGoodsNum (billGoods.getGoodsNum());
     	    	result.setJpyPrice (billGoods.getJpyPrice());
     	    	result.setCnyPrice (billGoods.getCnyPrice());
     	    	result.setUsdPrice (billGoods.getUsdPrice());
     	    	result.setEurPrice (billGoods.getEurPrice());
     	    	result.setBigType (billGoods.getBigType());
     	    	result.setSmallType (billGoods.getSmallType());
     	    	result.setModel (billGoods.getModel());
     	    	result.setCountry (billGoods.getCountry());
     	    	result.setComposition (billGoods.getComposition());
     	    	result.setWeight (billGoods.getWeight());
     	    	result.setLength (billGoods.getLength());
     	    	result.setWidth (billGoods.getWidth());
     	    	result.setHeight (billGoods.getHeight());
     	    	result.setVolume (billGoods.getVolume());
     	    	result.setImage (billGoods.getImage());
     	    return result;
	 }
	
	public static List<BillGoodsDTO>  toDTOs(Collection<BillGoods>  billGoodss){
		if (billGoodss == null) {
			return null;
		}
		List<BillGoodsDTO> results = new ArrayList<BillGoodsDTO>();
		for (BillGoods each : billGoodss) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static BillGoods  toEntity(BillGoodsDTO  billGoodsDTO){
	 	if (billGoodsDTO == null) {
			return null;
		}
	 	BillGoods result  = new BillGoods();
        result.setId (billGoodsDTO.getId());
         result.setVersion (billGoodsDTO.getVersion());
         result.setCreateTime (billGoodsDTO.getCreateTime());
         result.setCreateUser (billGoodsDTO.getCreateUser());
         result.setUpdateTime (billGoodsDTO.getUpdateTime());
         result.setUpdateUser (billGoodsDTO.getUpdateUser());
         result.setWaybillId (billGoodsDTO.getWaybillId());
         result.setBoxId (billGoodsDTO.getBoxId());
         result.setGoodsId (billGoodsDTO.getGoodsId());
         result.setGoodsName (billGoodsDTO.getGoodsName());
         result.setGoodsType (billGoodsDTO.getGoodsType());
         result.setGoodsNum (billGoodsDTO.getGoodsNum());
         result.setJpyPrice (billGoodsDTO.getJpyPrice());
         result.setCnyPrice (billGoodsDTO.getCnyPrice());
         result.setUsdPrice (billGoodsDTO.getUsdPrice());
         result.setEurPrice (billGoodsDTO.getEurPrice());
         result.setBigType (billGoodsDTO.getBigType());
         result.setSmallType (billGoodsDTO.getSmallType());
         result.setModel (billGoodsDTO.getModel());
         result.setCountry (billGoodsDTO.getCountry());
         result.setComposition (billGoodsDTO.getComposition());
         result.setWeight (billGoodsDTO.getWeight());
         result.setLength (billGoodsDTO.getLength());
         result.setWidth (billGoodsDTO.getWidth());
         result.setHeight (billGoodsDTO.getHeight());
         result.setVolume (billGoodsDTO.getVolume());
         result.setImage (billGoodsDTO.getImage());
 	  	return result;
	 }
	
	public static List<BillGoods> toEntities(Collection<BillGoodsDTO> billGoodsDTOs) {
		if (billGoodsDTOs == null) {
			return null;
		}
		
		List<BillGoods> results = new ArrayList<BillGoods>();
		for (BillGoodsDTO each : billGoodsDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
