package com.cice.gestaulas.services.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import com.cice.gestaulas.entities.Reserva;

public interface IReservaService {

	public void create(Reserva r);
	public Reserva findById(int id);
	public List<Reserva> findAll();
	public void update(Reserva r);
	public void delete(int id);
	public void delete(Reserva r);
	
    //Query --------------------------------
	public List<LocalDateTime> findFechasByAulas(int idAula);
	
	//Filtros buscar
	public List<Reserva> findAllByAula(int idAula);
	public List<Reserva> findAllByCurso(String nombreCurso);
	public List<Reserva> findAllByAulaAndCurso(int idAula, String nombreCurso);
	
	public List<String> findAllListaCursos();
	

}
