package com.ware.token.warehouse.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class KindDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5832252643934333016L;

	private Long id;

	private int version;

			
		private String typeName;
		
				
		private String codeName;
		
		@JsonSerialize(using = CustomDateSerializer.class)		
		private Date createTime;
		
		private Date createTimeEnd;
				
		private String createUser;
		
				
		private String remark;
		
		@JsonSerialize(using = CustomDateSerializer.class)		
		private Date updateTime;
		
		private Date updateTimeEnd;
				
		private String codeType;
		
				
		private String code;
		
				
		private String upCode;
		
		private String upCodeName;
		
				
		private String updateUser;
		
			
	
	public void setTypeName(String typeName) { 
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}
		
			
	
	public void setCodeName(String codeName) { 
		this.codeName = codeName;
	}

	public String getCodeName() {
		return this.codeName;
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
		
			
	
	public void setRemark(String remark) { 
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
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
			
	
	public void setCodeType(String codeType) { 
		this.codeType = codeType;
	}

	public String getCodeType() {
		return this.codeType;
	}
		
			
	
	public void setCode(String code) { 
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
		
			
	
	public void setUpCode(String upCode) { 
		this.upCode = upCode;
	}

	public String getUpCode() {
		return this.upCode;
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
		KindDTO other = (KindDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getUpCodeName() {
		return upCodeName;
	}

	public void setUpCodeName(String upCodeName) {
		this.upCodeName = upCodeName;
	}
}