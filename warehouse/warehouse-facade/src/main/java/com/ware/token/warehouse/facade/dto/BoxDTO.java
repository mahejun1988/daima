package com.ware.token.warehouse.facade.dto;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

public class BoxDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6073873410783435440L;

	private Long id;

	private int version;

			
		private String boxId;
		
				
		private Date createTime;
		
		private Date createTimeEnd;
				
		private String createUser;
		
				
		private String weight;
		
				
		private String height;
		
				
		private Date updateTime;
		
		private Date updateTimeEnd;
				
		private String width;
		
				
		private String volume;
		
				
		private String goodsNum;
		
				
		private String waybillId;
		
				
		private String lenght;
		
				
		private String updateUser;
		
		private List<BillGoodsDTO> list;
		
			
	
	public void setBoxId(String boxId) { 
		this.boxId = boxId;
	}

	public String getBoxId() {
		return this.boxId;
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
			
	
	public void setCreateUser(String createUser) { 
		this.createUser = createUser;
	}

	public String getCreateUser() {
		return this.createUser;
	}
		
			
	
	public void setWeight(String weight) { 
		this.weight = weight;
	}

	public String getWeight() {
		return this.weight;
	}
		
			
	
	public void setHeight(String height) { 
		this.height = height;
	}

	public String getHeight() {
		return this.height;
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
		
			
	
	public void setVolume(String volume) { 
		this.volume = volume;
	}

	public String getVolume() {
		return this.volume;
	}
		
			
	
	public void setGoodsNum(String goodsNum) { 
		this.goodsNum = goodsNum;
	}

	public String getGoodsNum() {
		return this.goodsNum;
	}
		
			
	
	public void setWaybillId(String waybillId) { 
		this.waybillId = waybillId;
	}

	public String getWaybillId() {
		return this.waybillId;
	}
		
			
	
	public void setLenght(String lenght) { 
		this.lenght = lenght;
	}

	public String getLenght() {
		return this.lenght;
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
		BoxDTO other = (BoxDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<BillGoodsDTO> getList() {
		return list;
	}

	public void setList(List<BillGoodsDTO> list) {
		this.list = list;
	}
}