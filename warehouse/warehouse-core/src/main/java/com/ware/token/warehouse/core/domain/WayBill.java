package com.ware.token.warehouse.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.openkoala.gqc.core.domain.AbstractGeneralQueryEntity;


/**
 * 运单信息表。
 *
 * @author mhj
 */
@Entity
@Table(name = "KG_WAY_BILL")
public class WayBill  extends AbstractGeneralQueryEntity{

	private static final long serialVersionUID = 7492758389282287606L;
	
	/**
	 * 运单号
	 */
	@Column(name = "WAYBILL_ID")
	private String waybillId;
	
	/**
	 * 购物来源
	 */
	@Column(name = "WAYBILL_FROM")
	private String wayBillFrom;

	/**
	 * 购物网站
	 */
	@Column(name = "WAYBILL_INTERNET")
	private String wayBillInternet;
	
	/**
	 * 物流公司
	 */
	@Column(name = "WAY_BILL_COO")
	private String wayBillCoo;
	
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
	 * 箱子数量
	 */
	@Column(name = "WAY_BILL_NUM")
	private String wayBillNum;
	
	/**
	 * 到货日期
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ARRIVAL_Time")
	private Date ArrivalTime;
	
	
	/**
	 * 是否出库
	 */
	@Column(name = "OUT_FLAG")
	private String outFlag;
	
	/**
	 * 出库日期
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OUT_Time")
	private Date OUT_Time;

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

	public String getWayBillNum() {
		return wayBillNum;
	}

	public void setWayBillNum(String wayBillNum) {
		this.wayBillNum = wayBillNum;
	}

	public Date getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		ArrivalTime = arrivalTime;
	}

	public String getWayBillCoo() {
		return wayBillCoo;
	}

	public void setWayBillCoo(String wayBillCoo) {
		this.wayBillCoo = wayBillCoo;
	}

	public String getOutFlag() {
		return outFlag;
	}

	public void setOutFlag(String outFlag) {
		this.outFlag = outFlag;
	}

	public Date getOUT_Time() {
		return OUT_Time;
	}

	public void setOUT_Time(Date oUT_Time) {
		OUT_Time = oUT_Time;
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

	/**
	 * 根据运单号获取
	 * 
	 * @param dataSourceId
	 * @return
	 */
	public static WayBill getByWaybillId(String waybillId) {
		return getRepository().createCriteriaQuery(WayBill.class).eq("waybillId", waybillId).singleResult();
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
