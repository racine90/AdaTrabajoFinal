package com.ada.blog.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ada.blog.entity.UsuarioEntity;

@Repository("usuarioRepositorio")
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Serializable> {

	public abstract UsuarioEntity findByUsuario(String usuario);
	public abstract List<UsuarioEntity> findById(long id);
	public abstract UsuarioEntity findByUsuarioAndId(String usuario, long id);
	
	
	

}
