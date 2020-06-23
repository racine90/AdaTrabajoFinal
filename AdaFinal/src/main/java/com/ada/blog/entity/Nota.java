package com.ada.blog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Nota")
@Entity
public class Nota implements Serializable {

	@GeneratedValue
	@Id
	@Column(name = "Id_nota")
	private long id;
	
	@ManyToOne
	@JoinColumn(name= "Id_Usuario")
	UsuarioEntity usuarioEntity;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Titulo")
	private String titulo;
	
	@Column(name = "Fecha")
	private Date fecha;
	

	public Nota(long id, String nombre, String titulo, String contenido, Date fecha) {
		this.id = id;
		this.nombre = nombre;
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecha= fecha;
	}

	public Nota() {

	}

	@Column(name = "Contenido")
	private String contenido;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
