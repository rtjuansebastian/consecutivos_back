package com.fes.dao;

import java.util.List;

import com.fes.entity.Equipo;

public interface EquipoDao {

	Equipo find(int id);
	
	void create (Equipo equipo);
	
	List<Equipo> read();
	
	Equipo update(Equipo equipo);
	
	void delete(int id);
	
	boolean exist(String nombre);
}
