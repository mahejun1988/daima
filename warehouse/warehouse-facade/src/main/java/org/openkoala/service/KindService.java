package org.openkoala.service;

import java.util.List;

import com.ware.token.warehouse.facade.model.Kind;

public interface KindService {

	public int getMaxIdByCodeType(Kind kind);

	public List<Kind> getByUpCode(Kind kind);
	
	public List<Kind> getUpName(Kind kind);

	public List<Kind> getByUpCodeName(Kind kind);

	public List<Kind> getKindByCode(Kind kind);

}
