package com.ware.token.warehouse.core.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.gqc.core.domain.AbstractGeneralQueryEntity;


/**
 * 分类表
 *
 * @author mhj
 */
@Entity
@Table(name = "KG_KIND")
public class Kind  extends AbstractGeneralQueryEntity{

	private static final long serialVersionUID = 749171234487606L;	
	
	/**
	 * 类型
	 */
	@Column(name = "CODE_TYPE")
	private String codeType;
	
	/**
	 * 类型名称
	 */
	@Column(name = "TYPE_NAME")
	private String typeName;
	
	/**
	 * 父编码
	 */
	@Column(name = "UP_CODE")
	private String upCode;
	
	/**
	 * 编码
	 */
	@Column(name = "CODE")
	private String code;

	/**
	 * 名称
	 */
	@Column(name = "CODE_NAME")
	private String codeName;
	
	/**
	 * 描述
	 */
	@Column(name = "REMARK")
	private String remark;
	

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getUpCode() {
		return upCode;
	}

	public void setUpCode(String upCode) {
		this.upCode = upCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
