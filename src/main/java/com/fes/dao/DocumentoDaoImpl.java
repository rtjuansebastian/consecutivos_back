package com.fes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fes.entity.Documento;

@Transactional
@Repository
public class DocumentoDaoImpl implements DocumentoDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Documento find(int id) {

		return entityManager.find(Documento.class, id);
	}

	@Override
	public void create(Documento documento) {

		entityManager.merge(documento);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Documento> read() {

		String hql="FROM Documento ORDER BY id";
		return (List<Documento>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Documento update(Documento documento) {
		
		Documento doc=find(documento.getId());
		doc.setUsuario(documento.getUsuario());
		doc.setTipoDocumento(documento.getTipoDocumento());
		doc.setNombre(documento.getNombre());
		doc.setFecha(documento.getFecha());
		entityManager.flush();
		
		return doc;
	}

	@Override
	public void delete(int id) {
		
		entityManager.remove(find(id));
	}

	@Override
	public boolean exist(String nombre) {

		String hql="FROM Documento WHERE nombre = ? ";
		int count=entityManager.createQuery(hql).setParameter(1, nombre).getResultList().size();
		
		return count > 0 ? true:false; 
	}

}
