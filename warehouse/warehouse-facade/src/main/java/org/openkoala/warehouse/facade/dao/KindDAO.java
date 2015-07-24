package org.openkoala.warehouse.facade.dao;

import java.util.List;

import com.ware.token.warehouse.facade.model.Kind;

public interface KindDAO {

    /**
     * 根据查询最大code
     * @param kind
     * @return
     */
	public int getMaxIdByCodeType(Kind kind);

	   /**
     * 根据大类型查询子类型列表
     * @param kind
     * @return
     */
	public List<Kind> getByUpCode(Kind kind);

	public List<Kind> getUpName(Kind kind);

	public List<Kind> getByUpCodeName(Kind kind);
	
	public List<Kind> getKindByCode(Kind kind);
}
