package com.ada.blog.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ada.blog.converter.UsuarioConvertidor;
import com.ada.blog.entity.UsuarioEntity;
import com.ada.blog.model.UsuarioModel;
import com.ada.blog.repository.UsuarioRepository;

@Service("usuarioServicio")
public class UsuarioEnService {

	@Autowired
	@Qualifier("usuarioRepositorio")
	private UsuarioRepository usuarioRepositorio;

	@Autowired
	@Qualifier("usuarioConvertidor")
	private UsuarioConvertidor usuarioConvertidor;

	private static final Log logger = LogFactory.getLog(UsuarioEnService.class);

	public boolean crear(UsuarioEntity usuario) {
		logger.info("Creando usuario");
		try {
			usuarioRepositorio.save(usuario);
			logger.info("Usuario creado");
			return true;
		} catch (Exception e) {
			logger.error("Hubo en error creando el usuario");
			return false;
		}
	}

	public boolean actualizar(UsuarioEntity usuario) {
		logger.info("Actualizar usuario");
		try {
			usuarioRepositorio.save(usuario);
			logger.info("Usuario actualizado");
			return true;
		} catch (Exception e) {
			logger.error("Hubo en error actualizando el usuario");
			return false;
		}
	}

	public boolean borrar(String usuario, long id) {
		try {
			logger.warn("Borrar usuario");
			UsuarioEntity usuarioentity = usuarioRepositorio.findByUsuarioAndId(usuario, id);
			usuarioRepositorio.delete(usuarioentity);
			logger.info("Usuario borrado");
			return true;
		} catch (Exception e) {
			logger.error("No se puede borrar el usuario");
			return false;
		}
	}

	public List <UsuarioModel> obtener() {
		logger.info("Obteniendo los usuarios");
		return usuarioConvertidor.convertirLista(usuarioRepositorio.findAll());

	}


}
