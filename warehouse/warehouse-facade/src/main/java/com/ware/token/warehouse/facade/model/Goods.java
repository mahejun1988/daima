package com.ware.token.warehouse.facade.model;

import java.util.Date;
import java.io.Serializable;

public class Goods extends BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1246953265223425375L;

			
	
	private Long id;
	private int version;
	private String waybillId;
	private String wayBillFrom;
	private String wayBillInternet;
	private String wayBillCoo;
	private String jpyPrice;
	private String cnyPrice;
	private String usdPrice;
	private String eurPrice;
	private String outFlag;
	private Date ArrivalTime;
	private Date ArrivalTimeEnd;
	private Date OUT_Time;
	private Date OUT_TimeEnd;
	private String wayBillNum;
	private Date createTime;
	private Date createTimeEnd;
	private String createUser;
	private String remark;
	private Date updateTime;
	private Date updateTimeEnd;	
	private String updateUser;
	
	private String boxId;
	private String weight;
	private String lenght;
	private String width;
	private String height;
	private String volume;
	private String goodsNum;
		
	private String goodsId;
	private String model;
	private String goodsWeight;
	private String smallType;
	private String goodsCnyPrice;
	private String goodsHeight;
	private String goodscomposition;
	private String goodsLength;
	private String goodsBigType;
	private String goodsType;
	private String goodsUsdPrice;
	private String goodsEurPrice;
	private String goodsWidth;
	private String image;
	private String country;
	private String goodsJpyPrice;
	private String goodsVolume;
	private String goodsName;
	private int page;
	private int pagesize;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getWaybillId() {
		return waybillId;
	}
	public void setWaybillId(String waybillId) {
		this.waybillId = waybillId;
	}
	public String getWayBillFrom() {
		return wayBillFrom;
	}
	public void setWayBillFrom(String wayBillFrom) {
		this.wayBillFrom = wayBillFrom;
	}
	public String getWayBillInternet() {
		return wayBillInternet;
	}
	public void setWayBillInternet(String wayBillInternet) {
		this.wayBillInternet = wayBillInternet;
	}
	public String getWayBillCoo() {
		return wayBillCoo;
	}
	public void setWayBillCoo(String wayBillCoo) {
		this.wayBillCoo = wayBillCoo;
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
	public String getOutFlag() {
		return outFlag;
	}
	public void setOutFlag(String outFlag) {
		this.outFlag = outFlag;
	}
	public Date getArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		ArrivalTime = arrivalTime;
	}
	public Date getArrivalTimeEnd() {
		return ArrivalTimeEnd;
	}
	public void setArrivalTimeEnd(Date arrivalTimeEnd) {
		ArrivalTimeEnd = arrivalTimeEnd;
	}
	public Date getOUT_Time() {
		return OUT_Time;
	}
	public void setOUT_Time(Date oUT_Time) {
		OUT_Time = oUT_Time;
	}
	public Date getOUT_TimeEnd() {
		return OUT_TimeEnd;
	}
	public void setOUT_TimeEnd(Date oUT_TimeEnd) {
		OUT_TimeEnd = oUT_TimeEnd;
	}
	public String getWayBillNum() {
		return wayBillNum;
	}
	public void setWayBillNum(String wayBillNum) {
		this.wayBillNum = wayBillNum;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}
	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getUpdateTimeEnd() {
		return updateTimeEnd;
	}
	public void setUpdateTimeEnd(Date updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
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
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getGoodsWeight() {
		return goodsWeight;
	}
	public void setGoodsWeight(String goodsWeight) {
		this.goodsWeight = goodsWeight;
	}
	public String getSmallType() {
		return smallType;
	}
	public void setSmallType(String smallType) {
		this.smallType = smallType;
	}
	public String getGoodsCnyPrice() {
		return goodsCnyPrice;
	}
	public void setGoodsCnyPrice(String goodsCnyPrice) {
		this.goodsCnyPrice = goodsCnyPrice;
	}
	public String getGoodsHeight() {
		return goodsHeight;
	}
	public void setGoodsHeight(String goodsHeight) {
		this.goodsHeight = goodsHeight;
	}
	public String getGoodscomposition() {
		return goodscomposition;
	}
	public void setGoodscomposition(String goodscomposition) {
		this.goodscomposition = goodscomposition;
	}
	public String getGoodsLength() {
		return goodsLength;
	}
	public void setGoodsLength(String goodsLength) {
		this.goodsLength = goodsLength;
	}
	public String getGoodsBigType() {
		return goodsBigType;
	}
	public void setGoodsBigType(String goodsBigType) {
		this.goodsBigType = goodsBigType;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getGoodsUsdPrice() {
		return goodsUsdPrice;
	}
	public void setGoodsUsdPrice(String goodsUsdPrice) {
		this.goodsUsdPrice = goodsUsdPrice;
	}
	public String getGoodsEurPrice() {
		return goodsEurPrice;
	}
	public void setGoodsEurPrice(String goodsEurPrice) {
		this.goodsEurPrice = goodsEurPrice;
	}
	public String getGoodsWidth() {
		return goodsWidth;
	}
	public void setGoodsWidth(String goodsWidth) {
		this.goodsWidth = goodsWidth;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGoodsJpyPrice() {
		return goodsJpyPrice;
	}
	public void setGoodsJpyPrice(String goodsJpyPrice) {
		this.goodsJpyPrice = goodsJpyPrice;
	}
	public String getGoodsVolume() {
		return goodsVolume;
	}
	public void setGoodsVolume(String goodsVolume) {
		this.goodsVolume = goodsVolume;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
}