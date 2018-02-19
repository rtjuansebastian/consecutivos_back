package com.fes.service;

import java.util.List;

import com.fes.entity.Documento;

public interface DocumentoService {

	Documento find(int id);
	
	Documento create(Documento documento);
	
	List<Documento> read();
	
	Documento update(Documento documento);
	
	void delete(int id);	
	
}
