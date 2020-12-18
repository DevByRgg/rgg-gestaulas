package com.cice.gestaulas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cice.gestaulas.entities.Ordenador;
import com.cice.gestaulas.repositories.IOrdenadorRepository;
import com.cice.gestaulas.services.interfaces.IOrdenadorService;

@Service
public class OrdenadorServiceImpl implements IOrdenadorService{

	@Autowired
	IOrdenadorRepository ordenadorRepository;
	
	@Override
	public void create(Ordenador o) {
		ordenadorRepository.save(o);
	}

	@Override
	public Ordenador findById(int id) {
		return ordenadorRepository.findById(id).orElse(null);
	}

	@Override
	public List<Ordenador> findAll() {
		return ordenadorRepository.findAll();
	}

	@Override
	public void update(Ordenador o) {
		ordenadorRepository.save(o);
	}

	@Override
	public void delete(int id) {
		ordenadorRepository.deleteById(id);
	}

	@Override
	public void delete(Ordenador o) {
		ordenadorRepository.delete(o);
	}

}
