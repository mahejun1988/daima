package com.ware.token.warehouse.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class OutWayDTO implements Serializable {

	private Long id;

	private int version;

			
		private String pickup_Addr;
		
				
		private String usdPrice;
		
		@JsonSerialize(using = CustomDateSerializer.class)		
		private Date createTime;
		
		private Date createTimeEnd;
				
		private String eurPrice;
		
				
		private String weight;
		
				
		private String reciever_Addr;
		
				
		private String boxCount;
		
		@JsonSerialize(using = CustomDateSerializer.class)		
		private Date updateTime;
		
		private Date updateTimeEnd;
				
		private String Merge_Flag;
		
				
		private String outWayId;
		
				
		private String width;
		
				
		private String outWayCoo;
		
				
		private String cnyPrice;
		
				
		private String waybillId;
		
				
		private String jpyPrice;
		
				
		private String Customer_Name;
		
				
		private String createUser;
		
				
		private String height;
		
				
		private String length;
		
				
		private String volume;
		
				
		private String Customer_ID;
		
				
		private String updateUser;
		
			
	
	public void setPickup_Addr(String pickup_Addr) { 
		this.pickup_Addr = pickup_Addr;
	}

	public String getPickup_Addr() {
		return this.pickup_Addr;
	}
		
			
	
	public void setUsdPrice(String usdPrice) { 
		this.usdPrice = usdPrice;
	}

	public String getUsdPrice() {
		return this.usdPrice;
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
		
			
	
	public void setWeight(String weight) { 
		this.weight = weight;
	}

	public String getWeight() {
		return this.weight;
	}
		
			
	
	public void setReciever_Addr(String reciever_Addr) { 
		this.reciever_Addr = reciever_Addr;
	}

	public String getReciever_Addr() {
		return this.reciever_Addr;
	}
		
			
	
	public void setBoxCount(String boxCount) { 
		this.boxCount = boxCount;
	}

	public String getBoxCount() {
		return this.boxCount;
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
			
	
	public void setMerge_Flag(String Merge_Flag) { 
		this.Merge_Flag = Merge_Flag;
	}

	public String getMerge_Flag() {
		return this.Merge_Flag;
	}
		
			
	
	public void setOutWayId(String outWayId) { 
		this.outWayId = outWayId;
	}

	public String getOutWayId() {
		return this.outWayId;
	}
		
			
	
	public void setWidth(String width) { 
		this.width = width;
	}

	public String getWidth() {
		return this.width;
	}
		
			
	
	public void setOutWayCoo(String outWayCoo) { 
		this.outWayCoo = outWayCoo;
	}

	public String getOutWayCoo() {
		return this.outWayCoo;
	}
		
			
	
	public void setCnyPrice(String cnyPrice) { 
		this.cnyPrice = cnyPrice;
	}

	public String getCnyPrice() {
		return this.cnyPrice;
	}
		
			
	
	public void setWaybillId(String waybillId) { 
		this.waybillId = waybillId;
	}

	public String getWaybillId() {
		return this.waybillId;
	}
		
			
	
	public void setJpyPrice(String jpyPrice) { 
		this.jpyPrice = jpyPrice;
	}

	public String getJpyPrice() {
		return this.jpyPrice;
	}
		
			
	
	public void setCustomer_Name(String Customer_Name) { 
		this.Customer_Name = Customer_Name;
	}

	public String getCustomer_Name() {
		return this.Customer_Name;
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
		
			
	
	public void setLength(String length) { 
		this.length = length;
	}

	public String getLength() {
		return this.length;
	}
		
			
	
	public void setVolume(String volume) { 
		this.volume = volume;
	}

	public String getVolume() {
		return this.volume;
	}
		
			
	
	public void setCustomer_ID(String Customer_ID) { 
		this.Customer_ID = Customer_ID;
	}

	public String getCustomer_ID() {
		return this.Customer_ID;
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
		OutWayDTO other = (OutWayDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}