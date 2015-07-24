package com.ware.token.warehouse.facade.dto;

import java.util.Date;
import java.util.List;
import java.io.Serializable;


import org.codehaus.jackson.map.annotate.JsonSerialize;

public class WayBillDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4527153423857567599L;
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
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date outTime;
	private Date outTimeEnd;
	private String wayBillNum;
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date createTime;
	private Date createTimeEnd;
	private String createUser;
	private String remark;
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date updateTime;
	private Date updateTimeEnd;	
	private String updateUser;
	
	private List<BoxDTO> list;
	
	
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

	public void setWayBillInternet(String wayBillInternet) { 
		this.wayBillInternet = wayBillInternet;
	}

	public String getWayBillInternet() {
		return this.wayBillInternet;
	}
		
			
	
	public void setOutFlag(String outFlag) { 
		this.outFlag = outFlag;
	}

	public String getOutFlag() {
		return this.outFlag;
	}
		
			
	
	public void setOutTime(Date outTime) { 
		this.outTime = outTime;
	}

	public Date getOutTime() {
		return this.outTime;
	}
		
			
	
	public void setWaybillId(String waybillId) { 
		this.waybillId = waybillId;
	}

	public String getWaybillId() {
		return this.waybillId;
	}
		
			
	
	public void setWayBillNum(String wayBillNum) { 
		this.wayBillNum = wayBillNum;
	}

	public String getWayBillNum() {
		return this.wayBillNum;
	}		
	
	public void setWayBillFrom(String wayBillFrom) { 
		this.wayBillFrom = wayBillFrom;
	}

	public String getWayBillFrom() {
		return this.wayBillFrom;
	}
			
	
	public void setWayBillCoo(String wayBillCoo) { 
		this.wayBillCoo = wayBillCoo;
	}

	public String getWayBillCoo() {
		return this.wayBillCoo;
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
		WayBillDTO other = (WayBillDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
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

	public Date getOutTimeEnd() {
		return outTimeEnd;
	}

	public void setOutTimeEnd(Date outTimeEnd) {
		this.outTimeEnd = outTimeEnd;
	}

	public List<BoxDTO> getList() {
		return list;
	}

	public void setList(List<BoxDTO> list) {
		this.list = list;
	}
}