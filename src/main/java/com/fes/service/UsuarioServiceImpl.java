package com.fes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fes.dao.UsuarioDao;
import com.fes.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public Usuario find(int cedula) {
		Usuario usuario = usuarioDao.find(cedula);
		return usuario;
	}

	@Override
	public boolean create(Usuario usuario) {
		
		if (usuarioDao.exist(usuario.getNombre())) {
			return false;
		} else {
			usuarioDao.create(usuario);
			return true;
		}
	}

	@Override
	public List<Usuario> read() {
		
		return usuarioDao.read();
	}

	@Override
	public Usuario update(Usuario usuario) {

		return usuarioDao.update(usuario);
	}

	@Override
	public void delete(int cedula) {

		usuarioDao.delete(cedula);
		
	}

}
