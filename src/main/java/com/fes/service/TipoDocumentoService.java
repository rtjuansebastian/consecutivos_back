package com.fes.service;

import java.util.List;

import com.fes.entity.TipoDocumento;

public interface TipoDocumentoService {
	
	TipoDocumento find(int id);
	
	boolean create(TipoDocumento tipoDocumento);
	
	List<TipoDocumento> read();
	
	TipoDocumento update(TipoDocumento tipoDocumento);
	
	void delete(int id);

}
