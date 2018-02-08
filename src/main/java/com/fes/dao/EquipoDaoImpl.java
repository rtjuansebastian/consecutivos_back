package com.fes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fes.entity.Equipo;

@Transactional
@Repository
public class EquipoDaoImpl implements EquipoDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Equipo find(int id) {
		
		return entityManager.find(Equipo.class, id);
	}

	@Override
	public void create(Equipo equipo) {
		
		entityManager.merge(equipo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipo> read() {

		String hql="FROM Equipo ORDER BY id";
		return (List<Equipo>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Equipo update(Equipo equipo) {

		Equipo eqp=find(equipo.getId());
		eqp.setNombre(equipo.getNombre());
		eqp.setSiglas(equipo.getSiglas());
		entityManager.flush();
		
		return eqp;
	}

	@Override
	public void delete(int id) {

		entityManager.remove(find(id));
	}

	@Override
	public boolean exist(String nombre) {

		String hql="FROM Equipo WHERE nombre = ? ";
		int count=entityManager.createQuery(hql).setParameter(1, nombre).getResultList().size();
		
		return count > 0 ? true:false; 
	}

}
