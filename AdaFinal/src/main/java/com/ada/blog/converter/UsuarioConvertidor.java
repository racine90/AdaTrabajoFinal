package com.ada.blog.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ada.blog.entity.UsuarioEntity;
import com.ada.blog.model.UsuarioModel;

@Component("usuarioConvertidor")
public class UsuarioConvertidor {
	
	public List<UsuarioModel>convertirLista(List<UsuarioEntity>usuarios){
		List<UsuarioModel> usuariomodel=new ArrayList<>();
		
		for (UsuarioEntity usuarioentity:usuarios) {
			usuariomodel.add(new UsuarioModel(usuarioentity));
		}
	
		return usuariomodel;
	}

	

}
