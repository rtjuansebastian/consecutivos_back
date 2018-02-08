package com.fes.dao;

import java.util.List;

import com.fes.entity.Documento;

public interface DocumentoDao {
	
	Documento find(int id);
	
	void create(Documento documento);
	
	List<Documento> read();
	
	Documento update(Documento documento);
	
	void delete(int id);
	
	boolean exist(String nombre);

}
