package com.fes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fes.entity.Documento;
import com.fes.entity.TipoDocumento;
import com.fes.entity.Usuario;

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
	public Documento create(Documento documento) {
		
		int consecutivo;
		String hqlTipoDocumento="FROM TipoDocumento WHERE id = ?";
		TipoDocumento tipoDocumento=(TipoDocumento)entityManager.createQuery(hqlTipoDocumento).setParameter(1,documento.getTipoDocumento().getId()).getSingleResult();
		String hqlUsuario="FROM Usuario WHERE cedula = ?";
		Usuario usuario= (Usuario)entityManager.createQuery(hqlUsuario).setParameter(1,documento.getUsuario().getCedula()).getSingleResult();
		
		if(tipoDocumento.isIndividual()) {
			String hql="FROM Documento WHERE tipoDocumento = ? AND usuario = ?";
			consecutivo=entityManager.createQuery(hql).setParameter(1, tipoDocumento).setParameter(2,usuario).getResultList().size();
		}else {
			String hql="SELECT doc.id FROM Documento AS doc INNER JOIN doc.usuario AS us WHERE doc.tipoDocumento= ? AND us.equipo= ? GROUP BY doc.id";
			consecutivo=entityManager.createQuery(hql).setParameter(1,tipoDocumento).setParameter(2, usuario.getEquipo()).getResultList().size();
		}
		
		documento.setConsecutivo(consecutivo+1);
		entityManager.merge(documento);
		
		return documento;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Documento> read() {

		String hql="FROM Documento ORDER BY id DESC";
		return (List<Documento>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Documento update(Documento documento) {
		
		Documento doc=find(documento.getId());
		doc.setUsuario(documento.getUsuario());
		doc.setTipoDocumento(documento.getTipoDocumento());
		doc.setNombre(documento.getNombre());
		doc.setFecha(documento.getFecha());
		doc.setConsecutivo(documento.getConsecutivo());
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
