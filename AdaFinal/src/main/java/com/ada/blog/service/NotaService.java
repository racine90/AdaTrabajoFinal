package com.ada.blog.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ada.blog.converter.Convertidor;
import com.ada.blog.entity.Nota;
import com.ada.blog.model.NotaModel;
import com.ada.blog.repository.NotaRepository;

@Service("servicio")
public class NotaService {
	@Autowired
	@Qualifier("repositorio")
	private NotaRepository repositorio;

	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	private static final Log logger = LogFactory.getLog(NotaService.class);

	public boolean crear(Nota nota) {
		logger.info("Creando nota");
		try {
			repositorio.save(nota);
			logger.info("Nota creada");
			return true;
		} catch (Exception e) {
			logger.error("Hubo en error creando la nota");
			return false;
		}
	}

	public boolean actualizar(Nota nota) {
		logger.info("Actualizar nota");
		try {
			repositorio.save(nota);
			logger.info("Nota actualizada");
			return true;
		} catch (Exception e) {
			logger.error("Hubo en error actualizando  la nota");
			return false;
		}
	}

	public boolean borrar(String nombre, long id) {
		try {
			logger.warn("Borrar nota");
			Nota nota = repositorio.findByNombreAndId(nombre, id);
			repositorio.delete(nota);
			logger.info("Nota borrada");
			return true;
		} catch (Exception e) {
			logger.error("No se puede borrar la nota");
			return false;
		}
	}

	public List <NotaModel> obtener(){
		logger.info("Obteniendo todas las notas");
		return convertidor.convertirLista(repositorio.findAll());

	}
	
	public NotaModel obtenerPorNombreTitulo(String nombre, String titulo) {
		return new NotaModel(repositorio.findByNombreAndTitulo(nombre, titulo));
	}
	
	public List<NotaModel> obtenerTitulo (String titulo){
		return convertidor.convertirLista(repositorio.findByTitulo(titulo));
	}
	
	public List <NotaModel> Paginacion(Pageable pageable){
		return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
	}
	
}
