package com.fes.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "documentos")
public class Documento implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "tipo_documento")
	private TipoDocumento tipoDocumento;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	public Documento() {

	}

	public Documento(int id, Usuario usuario, TipoDocumento tipoDocumento, String nombre, Date fecha) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.tipoDocumento = tipoDocumento;
		this.nombre = nombre;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
