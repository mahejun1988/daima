package com.ware.token.warehouse.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openkoala.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;

import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.core.domain.*;

public class GoodsAssembler {
	
	public static GoodsDTO  toDTO(Goods  goods){
		if (goods == null) {
			return null;
		}
    	GoodsDTO result  = new GoodsDTO();
	    	result.setId (goods.getId());
     	    	
     	    	result.setGoodsId (goods.getGoodsId());
     	    	result.setGoodsName (goods.getGoodsName());
     	    	result.setGoodsType (goods.getGoodsType());
     	    	result.setGoodsNum (goods.getGoodsNum());
     	    	result.setJpyPrice (goods.getJpyPrice());
     	    	result.setCnyPrice (goods.getCnyPrice());
     	    	result.setUsdPrice (goods.getUsdPrice());
     	    	result.setEurPrice (goods.getEurPrice());
     	    	result.setBigType (goods.getBigType());
     	    	result.setBigtypeID(goods.getBigtypeID());
     	    	result.setSmallType (goods.getSmallType());
     	    	result.setSmallTypeID(goods.getSmallTypeID());
     	    	result.setModel (goods.getModel());
     	    	result.setCountry (goods.getCountry());
     	    	result.setCountryID(goods.getCountryID());
     	    	
     	    	result.setComposition (goods.getComposition());
     	    	result.setWeight (goods.getWeight());
     	    	result.setLength (goods.getLength());
     	    	result.setWidth (goods.getWidth());
     	    	result.setHeight (goods.getHeight());
     	    	result.setVolume (goods.getVolume());
     	    	result.setImage (goods.getImage());
     	    	
     	    	result.setVersion (goods.getVersion());
     	    	result.setCreateTime (goods.getCreateTime());
     	    	result.setCreateUser (goods.getCreateUser());
     	    	result.setUpdateTime (goods.getUpdateTime());
     	    	result.setUpdateUser (goods.getUpdateUser());
     	    return result;
	 }
	
	public static List<GoodsDTO>  toDTOs(Collection<Goods>  goodss){
		if (goodss == null) {
			return null;
		}
		List<GoodsDTO> results = new ArrayList<GoodsDTO>();
		for (Goods each : goodss) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static Goods  toEntity(GoodsDTO  goodsDTO){
	 	if (goodsDTO == null) {
			return null;
		}
	 	Goods result  = new Goods();
        result.setId (goodsDTO.getId());
         result.setVersion (goodsDTO.getVersion());
         result.setCreateTime (goodsDTO.getCreateTime());
         result.setCreateUser (goodsDTO.getCreateUser());
         result.setUpdateTime (goodsDTO.getUpdateTime());
         result.setUpdateUser (goodsDTO.getUpdateUser());
         result.setGoodsId (goodsDTO.getGoodsId());
         result.setGoodsName (goodsDTO.getGoodsName());
         result.setGoodsType (goodsDTO.getGoodsType());
         result.setGoodsNum (goodsDTO.getGoodsNum());
         result.setJpyPrice (goodsDTO.getJpyPrice());
         result.setCnyPrice (goodsDTO.getCnyPrice());
         result.setUsdPrice (goodsDTO.getUsdPrice());
         result.setEurPrice (goodsDTO.getEurPrice());
         result.setBigType (goodsDTO.getBigType());
         result.setSmallType (goodsDTO.getSmallType());
         result.setModel (goodsDTO.getModel());
         result.setCountry (goodsDTO.getCountry());
         result.setComposition (goodsDTO.getComposition());
         result.setWeight (goodsDTO.getWeight());
         result.setLength (goodsDTO.getLength());
         result.setWidth (goodsDTO.getWidth());
         result.setHeight (goodsDTO.getHeight());
         result.setVolume (goodsDTO.getVolume());
         result.setImage (goodsDTO.getImage());
 	  	return result;
	 }
	
	public static List<Goods> toEntities(Collection<GoodsDTO> goodsDTOs) {
		if (goodsDTOs == null) {
			return null;
		}
		
		List<Goods> results = new ArrayList<Goods>();
		for (GoodsDTO each : goodsDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
