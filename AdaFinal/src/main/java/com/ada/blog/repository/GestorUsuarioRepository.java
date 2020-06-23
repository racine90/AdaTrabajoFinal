package com.ada.blog.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ada.blog.entity.UsuarioEntity;

@Repository("gestorusuario")
public interface GestorUsuarioRepository extends JpaRepository<UsuarioEntity, Serializable> {
	public abstract UsuarioEntity findByUsuario(String usuario);

}
