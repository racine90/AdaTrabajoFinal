package com.ada.blog.model;

import java.util.Date;

import com.ada.blog.entity.Nota;

public class NotaModel {

	private long id;
	private String nombre;
	private String titulo;
	private String contenido;
	private Date fecha;

	public NotaModel() {
		
	}
public NotaModel(Nota nota) {
	this.id = nota.getId();
	this.nombre = nota.getNombre();
	this.titulo = nota.getTitulo();
	this.contenido = nota.getContenido();
	this.fecha=nota.getFecha();
		
	}
	

	public NotaModel(long id, String nombre, String titulo, String contenido, Date fecha) {
		this.id = id;
		this.nombre = nombre;
		this.titulo = titulo;
		this.contenido = contenido;
		this.setFecha(fecha);
	}

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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
