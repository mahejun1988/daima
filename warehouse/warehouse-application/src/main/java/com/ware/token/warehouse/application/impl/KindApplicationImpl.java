package com.ware.token.warehouse.application.impl;

import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.ware.token.warehouse.application.KindApplication;
import com.ware.token.warehouse.core.domain.Kind;

@Named
@Transactional
public class KindApplicationImpl implements KindApplication {

	public Kind getKind(Long id) {
		return Kind.get(Kind.class, id);
	}
	
	public void creatKind(Kind kind) {
		kind.save();
	}
	
	public void updateKind(Kind kind) {
		kind .save();
	}
	
	public void removeKind(Kind kind) {
		if(kind != null){
			kind.remove();
		}
	}
	
	public void removeKinds(Set<Kind> kinds) {
		for (Kind kind : kinds) {
			kind.remove();
		}
	}
	
	public List<Kind> findAllKind() {
		return Kind.findAll(Kind.class);
	}

	@Override
	public int getMaxIdByCodeType(String codeType) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
