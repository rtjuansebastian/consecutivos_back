package com.fes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fes.entity.Usuario;

@Transactional
@Repository
public class UsuarioDaoImpl implements UsuarioDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Usuario find(int cedula) {

		return entityManager.find(Usuario.class, cedula);
	}

	@Override
	public void create(Usuario usuario) {

		entityManager.merge(usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> read() {

		String hql="FROM Usuario ORDER BY id";
		return (List<Usuario>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Usuario update(Usuario usuario) {
		Usuario usu=find(usuario.getCedula());
		usu.setNombre(usuario.getNombre());
		usu.setCorreo(usuario.getCorreo());
		usu.setEquipo(usuario.getEquipo());
		usu.setIniciales(usuario.getIniciales());
		entityManager.flush();
		
		return usu;
	}

	@Override
	public void delete(int cedula) {

		entityManager.remove(find(cedula));
	}

	@Override
	public boolean exist(String nombre) {

		String hql="FROM Usuario WHERE nombre = ? ";
		int count=entityManager.createQuery(hql).setParameter(1, nombre).getResultList().size();
		
		return count > 0 ? true:false; 
	}

}
