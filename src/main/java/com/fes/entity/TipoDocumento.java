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

	public TipoDocumento() {

	}

	public TipoDocumento(int id, String nombre, String siglas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.siglas = siglas;
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
		
}
