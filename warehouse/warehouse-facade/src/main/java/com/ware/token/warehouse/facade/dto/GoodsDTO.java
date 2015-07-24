package com.ware.token.warehouse.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

public class GoodsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1246953265223425375L;

	private Long id;

	private int version;

			
		private String usdPrice;
		
				
		private String goodsId;
		
		private String goodsNum;
		
		@JsonSerialize(using = CustomDateSerializer.class)
		private Date createTime;
		
		private Date createTimeEnd;
				
		private String eurPrice;
		
				
		private String model;
		
				
		private String weight;
		
		@JsonSerialize(using = CustomDateSerializer.class)		
		private Date updateTime;
		
		private Date updateTimeEnd;
				
		private String width;
		
				
		private String image;
		private String bigType;
				
		private String smallType;
		
				
		private String cnyPrice;
		
				
		private String country;
		
				
		private String jpyPrice;
		
				
		private String createUser;
		
				
		private String height;
		
				
		private String volume;
		
				
		private String length;
		
				
		private String composition;
		
				
				
		private String goodsName;
		
				
		private String updateUser;
		
				
		private String goodsType;
		
		private String bigtypeID;
		private String smallTypeID;
		private String countryID;
		
		private int page;
		private int pagesize;
			
	
	public void setUsdPrice(String usdPrice) { 
		this.usdPrice = usdPrice;
	}

	public String getUsdPrice() {
		return this.usdPrice;
	}
		
			
	
	public void setGoodsId(String goodsId) { 
		this.goodsId = goodsId;
	}

	public String getGoodsId() {
		return this.goodsId;
	}
		
			
	
	public void setCreateTime(Date createTime) { 
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}
		
		public void setCreateTimeEnd(Date createTimeEnd) { 
		this.createTimeEnd = createTimeEnd;
	}

	public Date getCreateTimeEnd() {
		return this.createTimeEnd;
	}
			
	
	public void setEurPrice(String eurPrice) { 
		this.eurPrice = eurPrice;
	}

	public String getEurPrice() {
		return this.eurPrice;
	}
		
			
	
	public void setModel(String model) { 
		this.model = model;
	}

	public String getModel() {
		return this.model;
	}
		
			
	
	public void setWeight(String weight) { 
		this.weight = weight;
	}

	public String getWeight() {
		return this.weight;
	}
		
			
	
	public void setUpdateTime(Date updateTime) { 
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}
		
		public void setUpdateTimeEnd(Date updateTimeEnd) { 
		this.updateTimeEnd = updateTimeEnd;
	}

	public Date getUpdateTimeEnd() {
		return this.updateTimeEnd;
	}
			
	
	public void setWidth(String width) { 
		this.width = width;
	}

	public String getWidth() {
		return this.width;
	}
		
			
	
	public void setImage(String image) { 
		this.image = image;
	}

	public String getImage() {
		return this.image;
	}
		
			
	
	public void setSmallType(String smallType) { 
		this.smallType = smallType;
	}

	public String getSmallType() {
		return this.smallType;
	}
		
			
	
	public void setCnyPrice(String cnyPrice) { 
		this.cnyPrice = cnyPrice;
	}

	public String getCnyPrice() {
		return this.cnyPrice;
	}
		
			
	
	public void setCountry(String country) { 
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}
		
			
	
	public void setJpyPrice(String jpyPrice) { 
		this.jpyPrice = jpyPrice;
	}

	public String getJpyPrice() {
		return this.jpyPrice;
	}
		
			
	
	public void setCreateUser(String createUser) { 
		this.createUser = createUser;
	}

	public String getCreateUser() {
		return this.createUser;
	}
		
			
	
	public void setHeight(String height) { 
		this.height = height;
	}

	public String getHeight() {
		return this.height;
	}
		
			
	
	public void setVolume(String volume) { 
		this.volume = volume;
	}

	public String getVolume() {
		return this.volume;
	}
		
			
	
	public void setLength(String length) { 
		this.length = length;
	}

	public String getLength() {
		return this.length;
	}
		
			
	
	public void setComposition(String composition) { 
		this.composition = composition;
	}

	public String getComposition() {
		return this.composition;
	}
		
			
	
	public void setBigType(String bigType) { 
		this.bigType = bigType;
	}

	public String getBigType() {
		return this.bigType;
	}
		
			
	
	public void setGoodsName(String goodsName) { 
		this.goodsName = goodsName;
	}

	public String getGoodsName() {
		return this.goodsName;
	}
		
			
	
	public void setUpdateUser(String updateUser) { 
		this.updateUser = updateUser;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}
		
			
	
	public void setGoodsType(String goodsType) { 
		this.goodsType = goodsType;
	}

	public String getGoodsType() {
		return this.goodsType;
	}
		
		
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

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodsDTO other = (GoodsDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
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

	public String getBigtypeID() {
		return bigtypeID;
	}

	public void setBigtypeID(String bigtypeID) {
		this.bigtypeID = bigtypeID;
	}

	public String getSmallTypeID() {
		return smallTypeID;
	}

	public void setSmallTypeID(String smallTypeID) {
		this.smallTypeID = smallTypeID;
	}

	public String getCountryID() {
		return countryID;
	}

	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}
}