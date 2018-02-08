package com.fes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fes.dao.DocumentoDao;
import com.fes.entity.Documento;

@Service
public class DocumentoServiceImpl implements DocumentoService {
	
	@Autowired
	private DocumentoDao documentoDao;

	@Override
	public Documento find(int id) {
		Documento documento = documentoDao.find(id);
		return documento;
	}

	@Override
	public boolean create(Documento documento) {

		if (documentoDao.exist(documento.getNombre())) {
			return false;
		} else {
			documentoDao.create(documento);
			return true;
		}
	}

	@Override
	public List<Documento> read() {
		
		return documentoDao.read();
	}

	@Override
	public Documento update(Documento documento) {
		
		return documentoDao.update(documento);
	}

	@Override
	public void delete(int id) {
		
		documentoDao.delete(id);
	}

}