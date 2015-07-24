package com.ware.token.warehouse.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.openkoala.gqc.core.domain.AbstractGeneralQueryEntity;


/**
 * 运单出库信息表。
 *
 * @author mhj
 */
@Entity
@Table(name = "KG_OUT_WAY")
public class OutWay extends AbstractGeneralQueryEntity{
private static final long serialVersionUID = 7492758389282287606L;
	
	/**
	 * 运单号
	 */
	@Column(name = "WAYBILL_ID")
	private String waybillId;
	
	/**
	 * 出货单号，预留字段
	 */
	@Column(name = "OUT_WAY_ID")
	private String outWayId;
	
	/**
	 * 物流公司
	 */
	@Column(name = "OUT_WAY_COO")
	private String outWayCoo;
	
	/**
	 * 箱子数来那个，预留字段
	 */
	@Column(name = "BOX_COUNT")
	private String boxCount;
	
	/**
	 * 是否合箱
	 */
	@Column(name = "MERGE_FLAG")
	private String Merge_Flag;
	
	/**
	 * 单价（日元）
	 */
	@Column(name = "JPY_PRICE")
	private String jpyPrice;
	
	/**
	 * 单价（人民币）
	 */
	@Column(name = "CNY_PRICE")
	private String cnyPrice;
	
	/**
	 * 单价（美元）
	 */
	@Column(name = "USD_PRICE")
	private String usdPrice;
	
	/**
	 * 单价（欧元）
	 */
	@Column(name = "EUR_PRICE")
	private String eurPrice;
	
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
	 * 提货地址
	 */
	@Column(name = "PICUP_ADDR")
	private String pickup_Addr;
	
	/**
	 * 送达日期
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "SEND_DATE")
	private Date send_Date;
	
	/**
	 * 收货地址
	 */
	@Column(name = "RECIEVER_ADDR")
	private String reciever_Addr;
	
	/**
	 * 客户编码
	 */
	@Column(name = "CUSTOMER_ID")
	private String Customer_ID;
	
	/**
	 * 客户姓名
	 */
	@Column(name = "CUSTOMER_NAME")
	private String Customer_Name;
	

	public String getWaybillId() {
		return waybillId;
	}

	public void setWaybillId(String waybillId) {
		this.waybillId = waybillId;
	}

	public String getOutWayId() {
		return outWayId;
	}

	public void setOutWayId(String outWayId) {
		this.outWayId = outWayId;
	}

	public String getOutWayCoo() {
		return outWayCoo;
	}

	public void setOutWayCoo(String outWayCoo) {
		this.outWayCoo = outWayCoo;
	}

	public String getBoxCount() {
		return boxCount;
	}

	public void setBoxCount(String boxCount) {
		this.boxCount = boxCount;
	}

	public String getMerge_Flag() {
		return Merge_Flag;
	}

	public void setMerge_Flag(String merge_Flag) {
		Merge_Flag = merge_Flag;
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

	public String getPickup_Addr() {
		return pickup_Addr;
	}

	public void setPickup_Addr(String pickup_Addr) {
		this.pickup_Addr = pickup_Addr;
	}

	public String getReciever_Addr() {
		return reciever_Addr;
	}

	public void setReciever_Addr(String reciever_Addr) {
		this.reciever_Addr = reciever_Addr;
	}

	public Date getSend_Date() {
		return send_Date;
	}

	public void setSend_Date(Date send_Date) {
		this.send_Date = send_Date;
	}

	public String getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(String customer_ID) {
		Customer_ID = customer_ID;
	}

	public String getCustomer_Name() {
		return Customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
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
