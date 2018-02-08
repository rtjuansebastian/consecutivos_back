package com.fes.service;

import java.util.List;

import com.fes.entity.Equipo;

public interface EquipoService {
	
	Equipo find(int id);
	
	boolean create(Equipo equipo);
	
	List<Equipo> read();
	
	Equipo update(Equipo equipo);
	
	void delete(int id);

}
