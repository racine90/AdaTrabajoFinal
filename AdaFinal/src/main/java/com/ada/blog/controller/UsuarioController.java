package com.ada.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.blog.entity.Nota;
import com.ada.blog.entity.UsuarioEntity;
import com.ada.blog.service.UsuarioEnService;

@RestController
@RequestMapping("/v1")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioServicio")
	UsuarioEnService usuarioServicio;

	@PostMapping("/usuario")
	public boolean agregarUsuario(@RequestBody @Valid UsuarioEntity usuarioEntity) {
		return usuarioServicio.crear(usuarioEntity);

	}

	@PutMapping("/usuario")
	public boolean actualizarUsuario(@RequestBody @Valid UsuarioEntity usuarioEntity) {
		return usuarioServicio.actualizar(usuarioEntity);

	}

	@DeleteMapping("/usuario/{id}/{usuaio}")
	public boolean borrarNota(@PathVariable("id") long id, @PathVariable("usuario") String usuario) {
		return usuarioServicio.borrar(usuario, id);

	}
}
