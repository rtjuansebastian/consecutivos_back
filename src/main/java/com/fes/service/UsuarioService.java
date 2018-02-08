package com.fes.service;

import java.util.List;

import com.fes.entity.Usuario;


public interface UsuarioService {
	
	Usuario find(int cedula);
	
	boolean create(Usuario usuario);
	
	List<Usuario> read();
	
	Usuario update(Usuario usuario);
	
	void delete(int cedula);	

}
