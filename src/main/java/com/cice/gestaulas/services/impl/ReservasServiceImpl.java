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
		reservaRepository.save(r);

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

	//Ordenacion-----------------------------------------------------------
	
	@Override
	public List<Reserva> findAllByIdAsc() {
		return reservaRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	@Override
	public List<Reserva> findAllByIdDes() {
		return reservaRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	@Override
	public List<Reserva> findAllByCursoAsc() {
		return reservaRepository.findAll(Sort.by(Sort.Direction.ASC, "nombreCurso"));
	}

	@Override
	public List<Reserva> findAllByCursoDes() {
		return reservaRepository.findAll(Sort.by(Sort.Direction.DESC, "nombreCurso"));
	}

	@Override
	public List<Reserva> findAllByAulaAsc() {
		return reservaRepository.findAll(Sort.by(Sort.Direction.ASC, "idAula"));
	}

	@Override
	public List<Reserva> findAllByAulaDes() {
		return reservaRepository.findAll(Sort.by(Sort.Direction.DESC, "idAula"));
	}

	@Override
	public List<Reserva> findAllByFechaAsc() {
		return reservaRepository.findAll(Sort.by(Sort.Direction.ASC, "fechaReserva"));
	}

	@Override
	public List<Reserva> findAllByFechaDes() {
		return reservaRepository.findAll(Sort.by(Sort.Direction.DESC, "fechaReserva"));
	}

	//Ordenacion-----------------------------------------------------------
	
	
	
	
}
