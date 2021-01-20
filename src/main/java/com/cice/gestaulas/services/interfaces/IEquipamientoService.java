package com.cice.gestaulas.services.interfaces;

import java.util.List;

import com.cice.gestaulas.entities.Equipamiento;

/**
 * Interface para los servicios de la clase Equipamiento
 *
 */
public interface IEquipamientoService {

	/**
	 * Método del service para guardar un Equipamiento en la BBDD
	 * @param e de la clase Equipamiento
	 */
	public void create(Equipamiento e);
	
	/**
	 * Metodo del service para buscar un Equipamiento por su Id en la BBDD
	 * @param id int identificador del Equipamiento
	 * @return Equipamiento encontrado
	 */
	public Equipamiento findById(int id);
	
	/**
	 * Método para obtener una lista con todos los Equipamientos de la BBDD
	 * @return List de Equipamientos
	 */
	public List<Equipamiento> findAll();
	
	/**
	 * Método para actualizar un Equipamiento en la BBDD
	 * @param e de la clase Equipamiento
	 */
	public void update(Equipamiento e);
	
	/**
	 * Método para borrar un Equipamiento por su id de la BBDD
	 * @param id identificador del Equipamiento
	 */
	public void delete(int id);
	
	/**
	 * Método para borrar un Equipamiento por Entidad
	 * @param e de la clase Equipamiento
	 */
	public void delete(Equipamiento e);
	
}
