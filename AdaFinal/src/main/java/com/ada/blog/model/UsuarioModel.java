package com.ada.blog.model;

import com.ada.blog.entity.UsuarioEntity;

public class UsuarioModel {

	private long id;
	private String usuario;
	private String contraseña;
	private byte rol;
	private boolean activo;
	
	public UsuarioModel() {
	}

	public UsuarioModel(UsuarioEntity usuarioEntity) {
		this.id=usuarioEntity.getId();
		this.usuario=usuarioEntity.getUsuario();
		this.contraseña=usuarioEntity.getContraseña();
		this.rol=usuarioEntity.getRol();
		this.activo=usuarioEntity.isActivo();
		
		
	}
	
	public UsuarioModel(long id, String usuario, String contraseña, byte rol, boolean activo) {
		this.id = id;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.rol = rol;
		this.activo = activo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public byte getRol() {
		return rol;
	}

	public void setRol(byte rol) {
		this.rol = rol;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

}
