package com.cice.gestaulas.services.interfaces;

import java.util.List;

import com.cice.gestaulas.entities.Ordenador;

/**
 * Interface para los servicios de la clase Ordenador
 *
 */
public interface IOrdenadorService {

	/**
	 * Método del service para guardar un Ordenador en la BBDD
	 * @param o de la clase Ordenador
	 */
	public void create(Ordenador o);
	
	/**
	 * Método del service para buscar un Ordenador por su Id en la BBDD
	 * @param id int identificador del Ordenador
	 * @return Ordenador encontrado
	 */
	public Ordenador findById(int id);
	
	/**
	 * Método para obtener una lista con todos los Ordenadores de la BBDD
	 * @return List de Ordenadores
	 */ 
	public List<Ordenador> findAll();
	
	/**
	 * Método para actualizar un Ordenador en la BBDD
	 * @param o de la clase Ordenador
	 */
	public void update(Ordenador o);
	
	/**
	 * Método para borrar un Ordenador por su id
	 * @param id identificador del Ordenador
	 */
	public void delete(int id);
	
	/**
	 * Método para borrar un Ordenador por Entidad
	 * @param o de la clase Ordenador
	 */
	public void delete(Ordenador o);
	
}
