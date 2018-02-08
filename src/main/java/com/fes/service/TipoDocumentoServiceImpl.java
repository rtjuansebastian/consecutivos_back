package com.fes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fes.dao.TipoDocumentoDao;
import com.fes.entity.TipoDocumento;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Autowired
	private TipoDocumentoDao tipoDocumentoDao;

	@Override
	public TipoDocumento find(int id) {

		TipoDocumento tipoDocumento = tipoDocumentoDao.find(id);
		return tipoDocumento;
	}

	@Override
	public boolean create(TipoDocumento tipoDocumento) {
		
		if (tipoDocumentoDao.exist(tipoDocumento.getNombre())) {
			return false;
		} else {
			tipoDocumentoDao.create(tipoDocumento);
			return true;
		}
	}

	@Override
	public List<TipoDocumento> read() {
		
		return tipoDocumentoDao.read();
	}

	@Override
	public TipoDocumento update(TipoDocumento tipoDocumento) {

		return tipoDocumentoDao.update(tipoDocumento);
	}

	@Override
	public void delete(int id) {
		
		tipoDocumentoDao.delete(id);
	}

}
