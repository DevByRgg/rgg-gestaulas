package com.cice.gestaulas.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cice.gestaulas.entities.Reserva;
import com.cice.gestaulas.repositories.IAulaRepository;
import com.cice.gestaulas.repositories.IReservasRepository;
import com.cice.gestaulas.services.interfaces.IReservaService;

@Service
public class ReservasServiceImpl implements IReservaService {

	@Autowired
	IReservasRepository reservaRepository;
	
	@Override
	public void create(Reserva r) {
		reservaRepository.save(r);

	}

	@Override
	public Reserva findById(int id) {		
		return reservaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Reserva> findAll() {
		return reservaRepository.findAll();
	}

	@Override
	public void update(Reserva r) {
		if (this.findById(r.getId())!=null) {
			reservaRepository.save(r);
		}else {
			//TODO GESTIONAR ERROR NO SE PUEDE ACTUALIZAR UN OBJETO QUE NO EXISTE CREARIA UNO NUEVO
		}
		

	}

	@Override
	public void delete(int id) {
		reservaRepository.deleteById(id);

	}

	@Override
	public void delete(Reserva r) {
		reservaRepository.delete(r);
	}

	//Query----------------------------------------------------------------

	@Override
	public List<LocalDateTime> findFechasByAulas(int idAula) {
		return reservaRepository.findFechasReservasByAula(idAula);
	}

	
	//Filtros Buscar-------------------------------------------------------

	@Override
	public List<Reserva> findAllByAula(int idAula) {
		return reservaRepository.findByIdAula(idAula);
	}

	@Override
	public List<Reserva> findAllByCurso(String nombreCurso) {
		return reservaRepository.findByNombreCurso(nombreCurso);
	}

	@Override
	public List<Reserva> findAllByAulaAndCurso(int idAula, String nombreCurso) {
		return reservaRepository.findByIdAulaAndNombreCurso(idAula, nombreCurso);
	}

	
	//Filtros Reserva Listado----------------------------------------------

	@Override
	public List<String> findAllListaCursos() {
		return reservaRepository.findAllListaNombresCurso();
	}

	
	
	
	@Override
	public Reserva findByIdAulaAndFechaReserva(int idAula, LocalDateTime fechaReserva) {
		
		return reservaRepository.findByIdAulaAndFechaReserva(idAula, fechaReserva);
	}
	
	
	
	
}
