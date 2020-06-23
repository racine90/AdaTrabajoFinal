package com.ada.blog.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.ada.blog.entity.Nota;
import com.ada.blog.model.NotaModel;

@Component("convertidor")
public class Convertidor {
	
	//Creacion de Notas en una lista de NotasModel//
	
	public List<NotaModel> convertirLista(List <Nota> notas){
	List<NotaModel> notasmodel = new ArrayList<>();
	
	for (Nota nota : notas) {
		notasmodel.add(new NotaModel(nota));
	}
	
	return notasmodel;
	}
	

}
