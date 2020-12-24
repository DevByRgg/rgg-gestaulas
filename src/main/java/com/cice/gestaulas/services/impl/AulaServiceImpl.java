package com.cice.gestaulas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.repositories.IAulaRepository;
import com.cice.gestaulas.services.interfaces.IAulaService;

@Service
public class AulaServiceImpl implements IAulaService{

	@Autowired
	IAulaRepository aulaRepository;
	
	@Override
	public void create(Aula a) {
		aulaRepository.save(a);
	}

	@Override
	public Aula findById(int id) {
		return aulaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Aula> findAll() {
		return aulaRepository.findAll();
	}

	@Override
	public void update(Aula a) {
		aulaRepository.save(a);
	}

	@Override
	public void delete(int id) {
		aulaRepository.deleteById(id);
	}

	@Override
	public void delete(Aula a) {
		aulaRepository.delete(a);
	}

	@Override
	public List<Aula> findBySedeAndTipo(int sede, int tipo) {
		return aulaRepository.findAulasBySedeAndTipo(sede, tipo);
	}

	@Override
	public List<Aula> findBySede(int sede) {
		return aulaRepository.findAulasBySede(sede);
	}

	@Override
	public List<Aula> findByTipo(int tipo) {
		return aulaRepository.findAulasByTipo(tipo);
	}

}
