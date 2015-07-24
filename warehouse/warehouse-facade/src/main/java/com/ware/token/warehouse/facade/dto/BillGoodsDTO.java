package com.ware.token.warehouse.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class BillGoodsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -68092557200038049L;

	private Long id;

	private int version;

		@JsonSerialize(using = CustomDateSerializer.class)	
		private Date createTime;
		
		private Date createTimeEnd;
				
		private String goodsId;
		
				
		private String model;
		
				
		private String weight;
		
				
		private String smallType;
		
				
		private String cnyPrice;
		
				
		private String height;
		
				
		private String composition;
		
				
		private String length;
		
				
		private String bigType;
		
				
		private String goodsType;
		
				
		private String boxId;
		
				
		private String usdPrice;
		
				
		private String eurPrice;
		
		@JsonSerialize(using = CustomDateSerializer.class)		
		private Date updateTime;
		
		private Date updateTimeEnd;
				
		private String width;
		
				
		private String image;
		
				
		private String waybillId;
		
				
		private String goodsNum;
		
				
		private String country;
		
				
		private String jpyPrice;
		
				
		private String createUser;
		
				
		private String volume;
		
				
		private String goodsName;
		
				
		private String updateUser;
		private int page;
		private int pagesize;
			
	
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
			
	
	public void setGoodsId(String goodsId) { 
		this.goodsId = goodsId;
	}

	public String getGoodsId() {
		return this.goodsId;
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
		
			
	
	public void setHeight(String height) { 
		this.height = height;
	}

	public String getHeight() {
		return this.height;
	}
		
			
	
	public void setComposition(String composition) { 
		this.composition = composition;
	}

	public String getComposition() {
		return this.composition;
	}
		
			
	
	public void setLength(String length) { 
		this.length = length;
	}

	public String getLength() {
		return this.length;
	}
		
			
	
	public void setBigType(String bigType) { 
		this.bigType = bigType;
	}

	public String getBigType() {
		return this.bigType;
	}
		
			
	
	public void setGoodsType(String goodsType) { 
		this.goodsType = goodsType;
	}

	public String getGoodsType() {
		return this.goodsType;
	}
		
			
	
	public void setBoxId(String boxId) { 
		this.boxId = boxId;
	}

	public String getBoxId() {
		return this.boxId;
	}
		
			
	
	public void setUsdPrice(String usdPrice) { 
		this.usdPrice = usdPrice;
	}

	public String getUsdPrice() {
		return this.usdPrice;
	}
		
			
	
	public void setEurPrice(String eurPrice) { 
		this.eurPrice = eurPrice;
	}

	public String getEurPrice() {
		return this.eurPrice;
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
		
			
	
	public void setWaybillId(String waybillId) { 
		this.waybillId = waybillId;
	}

	public String getWaybillId() {
		return this.waybillId;
	}
		
			
	
	public void setGoodsNum(String goodsNum) { 
		this.goodsNum = goodsNum;
	}

	public String getGoodsNum() {
		return this.goodsNum;
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
		
			
	
	public void setVolume(String volume) { 
		this.volume = volume;
	}

	public String getVolume() {
		return this.volume;
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
		BillGoodsDTO other = (BillGoodsDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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