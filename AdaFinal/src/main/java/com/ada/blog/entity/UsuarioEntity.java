package com.ada.blog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Usuario")
public class UsuarioEntity implements Serializable{
	
	@GeneratedValue
	@Id
	@Column (name= "Id_Usuario")
	private long id;
	
	@Column (name="Usuario", unique = true)
	private String usuario;
	
	@Column (name="Contraseña")
	private String contraseña;
	
	@Column (name="Rol")
	private byte rol;
	
	@Column (name="Activo")
	private boolean activo;

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
