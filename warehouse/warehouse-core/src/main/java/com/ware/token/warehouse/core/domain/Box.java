package com.ware.token.warehouse.core.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.gqc.core.domain.AbstractGeneralQueryEntity;

/**
 * 箱子信息表
 *
 * @author mhj
 */
@Entity
@Table(name = "KG_BOX")
public class Box  extends AbstractGeneralQueryEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8979742582280808339L;
	
	
	/**
	 * 运单号
	 */
	@Column(name = "WAYBILL_ID")
	private String waybillId;
	
	
	/**
	 * 箱子序号
	 */
	@Column(name = "BOX_ID")
	private String boxId;
	
	/**
	 * 箱子重量
	 */
	@Column(name = "WEIGHT")
	private String weight;

	/**
	 * 箱子长度
	 */
	@Column(name = "LENGHT")
	private String lenght;
	
	/**
	 * 箱子宽度
	 */
	@Column(name = "WIDTH")
	private String width;
	
	/**
	 * 箱子高度
	 */
	@Column(name = "HEIGHT")
	private String height;
	
	/**
	 * 箱子体积重
	 */
	@Column(name = "VOLUME")
	private String volume;
	
	/**
	 * 商品数量
	 */
	@Column(name = "GOODSNUM")
	private String goodsNum;
	
	public String getWaybillId() {
		return waybillId;
	}

	public void setWaybillId(String waybillId) {
		this.waybillId = waybillId;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getLenght() {
		return lenght;
	}

	public void setLenght(String lenght) {
		this.lenght = lenght;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	/**
	 * 根据运单号获取箱子信息
	 * 
	 * @param wayBillId
	 * @return
	 */
	public static List<Box> getByBoxId(String waybillId) {
		 return getRepository().createCriteriaQuery(Box.class).eq("waybillId", waybillId).list();
	}
	
	

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
