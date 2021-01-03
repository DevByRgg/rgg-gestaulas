package com.cice.gestaulas.services.interfaces;

import java.util.List;

import com.cice.gestaulas.entities.Sede;

/**
 * Interface para los servicios de la clase Sede
 *
 */
public interface ISedeService {
	
	/**
	 * Método del service para guardar una Sede en la BBDD
	 * @param s de la clase Sede
	 */
	public void create(Sede s);
	
	/**
	 * Método del service para buscar una Sede por su Id en la BBDD
	 * @param id int identificador de la Sede
	 * @return Sede encontrada
	 */
	public Sede findById(int id);
	
	
	/**
	 * Método para obtener una lista con todas las Sedes de la BBDD
	 * @return List de Sedes
	 */
	public List<Sede> findAll();
	
	
	/**
	 * Método para actualizar una Sede en la BBDD
	 * @param s de la clase Sede
	 */
	public void update(Sede s);
	
	/**
	 * Método para borrar una Sede por su id
	 * @param id identificador de la Sede
	 */
	public void delete(int id);
	
	/**
	 * Método para borrar una Sede por Entidad
	 * @param s de la clase Sede
	 */
	public void delete(Sede s);
	
	
	/**
	 * Método para buscar una sede por su nombre Exacto
	 * @param nombre de la clase String
	 * @return Objeto de la clase Sede
	 */
	public Sede findByNombre(String nombre);
	
}
