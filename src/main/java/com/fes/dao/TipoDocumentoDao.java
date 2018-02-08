package com.fes.dao;

import java.util.List;

import com.fes.entity.TipoDocumento;

public interface TipoDocumentoDao {
	
	TipoDocumento find(int id);
	
	void create(TipoDocumento tipoDocumento);
	
	List<TipoDocumento> read();
	
	TipoDocumento update(TipoDocumento tipoDocumento);
	
	void delete(int id);
	
	boolean exist(String nombre);

}
