package com.cice.gestaulas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
