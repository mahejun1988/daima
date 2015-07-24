package org.openkoala.service.impl;

import java.util.List;

import org.openkoala.service.KindService;
import org.openkoala.warehouse.facade.dao.KindDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ware.token.warehouse.facade.model.Kind;
@Service
public class KindServiceImpl implements KindService {

    @Autowired
    private KindDAO kindDAO;
    
	@Override
	public int getMaxIdByCodeType(Kind kind) {
		return kindDAO.getMaxIdByCodeType(kind);
	}

	@Override
	public List<Kind> getByUpCode(Kind kind) {
		return kindDAO.getByUpCode(kind);
	}

	@Override
	public List<Kind> getUpName(Kind kind) {
		return kindDAO.getUpName(kind);
	}

	@Override
	public List<Kind> getByUpCodeName(Kind kind) {
		return kindDAO.getByUpCodeName(kind);
	}

	@Override
	public List<Kind> getKindByCode(Kind kind) {
		return kindDAO.getKindByCode(kind);
	}

}
