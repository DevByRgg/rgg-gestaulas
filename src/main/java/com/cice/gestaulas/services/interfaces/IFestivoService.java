package com.cice.gestaulas.services.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.cice.gestaulas.entities.auxiliar.Festivo;

/**
* Interface para los servicios de la clase Festivo
*
*/
public interface IFestivoService {

	/**
	 * Método del service para guardar un Festivo en la BBDD
	 * @param f de la clase Festivo
	 */
	public void create(Festivo f);
		
	/**
	 * Método del service para buscar un Festivo por su Id en la BBDD
	 * @param id int identificador del Festivo
	 * @return Festivo encontrado
	 */
	public Festivo findById(int id);
		
	/**
	 * Método para obtener una lista con todos los Festivos de la BBDD
	 * @return List de Festivos
	 */
	public List<Festivo> findAll();
		
	/**
	 * Método para obtener una lista con todas las fechas de Festivos de la BBDD
	 * @return List de LocalDate
	 */
	public List<LocalDate> findAllFechas();
	
	/**
	 * Método para actualizar un Festivo en la BBDD
	 * @param f de la clase Festivo
	 */
	public void update(Festivo f);
		
	/**
	 * Método para borrar un Festivo por su id de la BBDD
	 * @param id identificador del Festivo
	 */
	public void delete(int id);
		
	/**
	 * Método para borrar un Festivo por Entidad
	 * @param f de la clase Festivo
	 */
	public void delete(Festivo f);



}
