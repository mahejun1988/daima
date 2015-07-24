package com.ware.token.warehouse.facade.model;

import java.io.Serializable;

/**
 * 分类表
 *
 * @author mhj
 */
public class Kind  extends BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 219030748963623090L;

	/**
	 * 类型
	 */
	private String codeType;
	
	/**
	 * 类型名称
	 */
	private String typeName;
	
	/**
	 * 父编码
	 */
	private String upCode;
	
	/**
	 * 编码
	 */
	private String code;

	/**
	 * 名称
	 */
	private String codeName;
	
	/**
	 * 描述
	 */
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
	
}
