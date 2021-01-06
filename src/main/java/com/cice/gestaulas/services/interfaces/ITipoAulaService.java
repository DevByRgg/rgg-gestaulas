package com.cice.gestaulas.services.interfaces;

import java.util.List;

import com.cice.gestaulas.entities.TipoAula;

/**
 * Interface para los servicios de la clase TipoAula
 *
 */
public interface ITipoAulaService {
	
	/**
	 * Método del service para guardar un TipoAula en la BBDD
	 * @param t de la clase TipoAula
	 */
	public void create(TipoAula t);
	
	/**
	 * Método del service para buscar un TipoAula por su Id en la BBDD
	 * @param id int identificador del TipoAula
	 * @return TipoAula encontrada
	 */
	public TipoAula findById(int id);
	
	/**
	 * Método para obtener una lista con todas los TipoAula de la BBDD
	 * @return List de TipoAula
	 */
	public List<TipoAula> findAll();
	
	/**
	 * Método para actualizar un TipoAula en la BBDD
	 * @param t de la clase TipoAula
	 */
	public void update(TipoAula t);
	
	/**
	 * Método para borrar un TipoAula por su id de la BBDD
	 * @param id identificador del TipoAula
	 */
	public void delete(int id);
	
	/**
	 * Método para borrar un TipoAula por Entidad
	 * @param t de la clase TipoAula
	 */
	public void delete(TipoAula t);
	
}
