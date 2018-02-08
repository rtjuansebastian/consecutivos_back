package com.fes.dao;

import java.util.List;

import com.fes.entity.Usuario;

public interface UsuarioDao {

	Usuario find(int cedula);
	
	void create(Usuario usuario);
	
	List<Usuario> read();
	
	Usuario update(Usuario usuario);
	
	void delete(int cedula);
	
	boolean exist(String nombre);
}
