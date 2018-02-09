package com.fes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fes.entity.TipoDocumento;

@Transactional
@Repository
public class TipoDocumentoDaoImpl implements TipoDocumentoDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public TipoDocumento find(int id) {

		return entityManager.find(TipoDocumento.class, id);
	}

	@Override
	public void create(TipoDocumento tipoDocumento) {

		entityManager.merge(tipoDocumento);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoDocumento> read() {

		String hql="FROM TipoDocumento ORDER BY id";
		return (List<TipoDocumento>) entityManager.createQuery(hql).getResultList();		
	}

	@Override
	public TipoDocumento update(TipoDocumento tipoDocumento) {

		TipoDocumento tipoDoc=find(tipoDocumento.getId());
		tipoDoc.setNombre(tipoDocumento.getNombre());
		tipoDoc.setSiglas(tipoDocumento.getSiglas());
		tipoDoc.setIndividual(tipoDocumento.isIndividual());
		tipoDoc.setTitulo(tipoDocumento.isTitulo());
		entityManager.flush();
		
		return tipoDoc;
	}

	@Override
	public void delete(int id) {

		entityManager.remove(find(id));
	}

	@Override
	public boolean exist(String nombre) {

		String hql="FROM TipoDocumento WHERE nombre = ? ";
		int count=entityManager.createQuery(hql).setParameter(1, nombre).getResultList().size();
		
		return count > 0 ? true:false; 
	}

}
