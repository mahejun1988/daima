package com.ware.token.warehouse.core.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.gqc.core.domain.AbstractGeneralQueryEntity;

/**
 * 入库商品信息表。
 *
 * @author mhj
 */
@Entity
@Table(name = "KG_Bill_GOODS")
public class BillGoods extends AbstractGeneralQueryEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6484170165325144702L;
	
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
	 * 商品条形码
	 */
	@Column(name = "GOODS_ID")
	private String goodsId;
	
	/**
	 * 商品名称
	 */
	@Column(name = "GOODS_NAME")
	private String goodsName;
	
	/**
	 * 商品规格
	 */
	@Column(name = "GOODS_TYPE")
	private String goodsType;
	
	/**
	 * 商品数量
	 */
	@Column(name = "GOODS_NUM")
	private String goodsNum;
	
	/**
	 * 商品单价（日元）
	 */
	@Column(name = "JPY_PRICE")
	private String jpyPrice;
	
	/**
	 * 商品单价（人民币）
	 */
	@Column(name = "CNY_PRICE")
	private String cnyPrice;
	
	/**
	 * 商品单价（美元）
	 */
	@Column(name = "USD_PRICE")
	private String usdPrice;
	
	/**
	 * 商品单价（欧元）
	 */
	@Column(name = "EUR_PRICE")
	private String eurPrice;
	
	/**
	 * 种类
	 */
	@Column(name = "BIG_TYPE")
	private String bigType;
	
	/**
	 * 细类
	 */
	@Column(name = "SMALL_TYPE")
	private String smallType;
	
	/**
	 * 品牌
	 */
	@Column(name = "MODEL")
	private String model;
	

	/**
	 * 原产国
	 */
	@Column(name = "COUNTRY")
	private String country;
	
	/**
	 * 成分
	 */
	@Column(name = "COMPOSITION")
	private String composition;
		
	/**
	 * 重量
	 */
	@Column(name = "WEIGHT")
	private String weight;
	
	/**
	 * 长度
	 */
	@Column(name = "LENGTH")
	private String length;
	
	/**
	 * 宽度
	 */
	@Column(name = "WIDTH")
	private String width;
	
	/**
	 * 高度
	 */
	@Column(name = "HEIGHT")
	private String height;
	
	/**
	 * 体积重
	 */
	@Column(name = "VOLUME")
	private String volume;
	
	/**
	 * 商品图片
	 */
	@Column(name = "IMAGE")
	private String image;
	
	
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

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getJpyPrice() {
		return jpyPrice;
	}

	public void setJpyPrice(String jpyPrice) {
		this.jpyPrice = jpyPrice;
	}

	public String getCnyPrice() {
		return cnyPrice;
	}

	public void setCnyPrice(String cnyPrice) {
		this.cnyPrice = cnyPrice;
	}

	public String getUsdPrice() {
		return usdPrice;
	}

	public void setUsdPrice(String usdPrice) {
		this.usdPrice = usdPrice;
	}

	public String getEurPrice() {
		return eurPrice;
	}

	public void setEurPrice(String eurPrice) {
		this.eurPrice = eurPrice;
	}

	public String getBigType() {
		return bigType;
	}

	public void setBigType(String bigType) {
		this.bigType = bigType;
	}

	public String getSmallType() {
		return smallType;
	}

	public void setSmallType(String smallType) {
		this.smallType = smallType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public static List<BillGoods> getByBoxId(String wayBillId, String boxId) {
		return getRepository().createCriteriaQuery(BillGoods.class).eq("waybillId",wayBillId).eq("boxId", boxId).list();
	}
	
}
