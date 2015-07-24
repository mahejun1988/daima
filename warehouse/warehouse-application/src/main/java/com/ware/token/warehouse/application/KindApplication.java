package com.ware.token.warehouse.application;


import java.util.List;
import java.util.Set;

import  com.ware.token.warehouse.core.domain.Kind;

public interface KindApplication {

	public Kind getKind(Long id);
	
	public void creatKind(Kind kind);
	
	public void updateKind(Kind kind);
	
	public void removeKind(Kind kind);
	
	public void removeKinds(Set<Kind> kinds);
	
	public List<Kind> findAllKind();

	public int getMaxIdByCodeType(String codeType);
	
}

