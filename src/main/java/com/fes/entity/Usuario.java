package com.fes.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@Column(name = "cedula")
	private int cedula;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "correo")
	private String correo;

	@ManyToOne
	@JoinColumn(name = "equipo")
	private Equipo equipo;

	@Column(name = "iniciales")
	private String iniciales;

	public Usuario() {

	}

	public Usuario(int cedula, String nombre, String correo, Equipo equipo, String iniciales) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.correo = correo;
		this.equipo = equipo;
		this.iniciales = iniciales;
	}

	public int getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public String getIniciales() {
		return iniciales;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}

}
