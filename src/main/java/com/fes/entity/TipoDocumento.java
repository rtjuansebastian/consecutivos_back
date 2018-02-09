package com.fes.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tipo_documento")
public class TipoDocumento implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="siglas")
	private String siglas;
	
	@Column(name="individual")
	private boolean individual;
	
	@Column(name="titulo")
	private boolean titulo;

	public TipoDocumento() {

	}

	public TipoDocumento(int id, String nombre, String siglas, boolean individual, boolean titulo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.siglas = siglas;
		this.individual = individual;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public boolean isIndividual() {
		return individual;
	}

	public void setIndividual(boolean individual) {
		this.individual = individual;
	}

	public boolean isTitulo() {
		return titulo;
	}

	public void setTitulo(boolean titulo) {
		this.titulo = titulo;
	}		
		
}
