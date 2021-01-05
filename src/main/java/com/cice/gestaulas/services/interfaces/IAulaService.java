package com.cice.gestaulas.services.interfaces;

import java.util.List;

import com.cice.gestaulas.entities.Aula;

/**
 * Interface para los servicios de la clase Aula
 *
 */
public interface IAulaService {
	
	/**
	 * Método del service para guardar un Aula en la BBDD
	 * @param a de la clase Aula
	 */
	public void create(Aula a);
	
	/**
	 * Método del service para buscar un Aula por su Id en la BBDD
	 * @param id int identificador del Aula
	 * @return Aula encontrada
	 */
	public Aula findById(int id);
	
	/**
	 * Método para obtener una lista con todas las Aulas de la BBDD
	 * @return List de Aulas
	 */
	public List<Aula> findAll();
	
	/**
	 * Método para actualizar un Aula en la BBDD
	 * @param a de la clase Aula
	 */
	public void update(Aula a);
	
	/**
	 * Método para borrar un Aula por su id
	 * @param id identificador del Aula
	 */
	public void delete(int id);
	
	/**
	 * Método para borrar un Aula por Entidad
	 * @param a de la clase Aula
	 */
	public void delete(Aula a);
	
	//Query-----------------------
	
	
	/**
	 * Método para obtener todas las aulas de una Sede y un tipo de Aula
	 * @param sede int identificador de la Sede
	 * @param tipo int identificador del Tipo de Aula
	 * @return Lista de Aula coincidentes
	 */
	public List<Aula> findBySedeAndTipo(int sede, int tipo);
	
	/**
	 * Método para obtener todas las aulas de una sede
	 * @param sede int que es el id de la sede
	 * @return Lista de Aulas coincidentes
	 */
	public List<Aula> findBySede(int sede);
	
	/**
	 * Método para obtener todas las aulas de un Tipo
	 * @param tipo int que es el id del tipo de Aula
	 * @return Lista de Aulas coincidentes
	 */
	public List<Aula> findByTipo(int tipo);
	
	//Se necesita para las reservas
	
	/**
	 * Método para obtener todas las aulas de un tipo y con una capacidad
	 * @param tipo int que es el id del tipo de Aula
	 * @param capacidad int con la capacidad buscada
	 * @return Lista de Aulas coincidentes
	 */
	public List<Integer> findAulasByTipoAndCapacidad(int tipo, int capacidad);
	
	/**
	 * Método para obtener todas las aulas con una capacidad
	 * @param capacidad int con la capacidad buscada
	 * @return Lista de Aulas coincidentes
	 */
	public List<Integer> findAulasByCapacidad(int capacidad);
	
}
