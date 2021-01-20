package com.cice.gestaulas.services.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import com.cice.gestaulas.entities.Reserva;

/**
 * Interface para los servicios de la clase Reserva
 *
 */
public interface IReservaService {

	/**
	 * Método del service para guardar una Reserva en la BBDD
	 * @param r de la clase Reserva
	 */
	public void create(Reserva r);
	
	/**
	 * Método del service para buscar una reserva por su Id en la BBDD
	 * @param id int identificador de la Reserva
	 * @return Reserva encontrada
	 */
	public Reserva findById(int id);
	
	/**
	 * Método para obtener una lista con todas las Reservas de la BBDD
	 * @return Reserva encontrada
	 */
	public List<Reserva> findAll();
	
	/**
	 * Método para actualizar una Reserva en la BBDD
	 * @param r de la clase Reserva
	 */
	public void update(Reserva r);
	
	/**
	 * Método para borrar una reserva por su id de la BBDD
	 * @param id identificador de la Reserva
	 */
	public void delete(int id);
	
	/**
	 * Método para borrar una reserva por su entidad de la BBDD
	 * @param r de la clase Reserva
	 */
	public void delete(Reserva r);
	
    //Query --------------------------------
	/**
	 * Método para obtener todas las fechas de las reservas de un Aula
	 * @param idAula identificador del aula
	 * @return Lista de LocalDateTime con las fechas 
	 */
	public List<LocalDateTime> findFechasByAulas(int idAula);
	
	//Filtros buscar
	/**
	 * Método para obtener todas las reservas de un aula
	 * @param idAula identificador del aula
	 * @return Lista de reservas
	 */
	public List<Reserva> findAllByAula(int idAula);
	
	/**
	 * Método para obtener las reservas de un curso por nombre del curso
	 * @param nombreCurso nombre del curso
	 * @return Lista de reservas
	 */
	public List<Reserva> findAllByCurso(String nombreCurso);
	
	/**
	 * Metodo para obtener todas las reservas de una aula y un curso
	 * @param idAula identificador del aula
	 * @param nombreCurso nombre del curso
	 * @return Lista de reservas
	 */
	public List<Reserva> findAllByAulaAndCurso(int idAula, String nombreCurso);
	
	public List<String> findAllListaCursos();
	
	
	/**
	 * Para comprobar que una fecha en una aula esta libre para reservar
	 * @param idAula identificador del Aula
	 * @param fechaReserva fecha de la reserva
	 * @return una reserva única si existe o null si no
	 */
	public Reserva findByIdAulaAndFechaReserva(int idAula, LocalDateTime fechaReserva);
	

}
