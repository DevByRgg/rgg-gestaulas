package com.cice.gestaulas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cice.gestaulas.entities.Equipamiento;
import com.cice.gestaulas.repositories.IEquipamientoRepository;
import com.cice.gestaulas.services.interfaces.IEquipamientoService;

@Service
public class EquipamientoServiceImpl implements IEquipamientoService{

	@Autowired
	IEquipamientoRepository equipamientoRepository;
	
	
	@Override
	public void create(Equipamiento e) {
		equipamientoRepository.save(e);

	}

	@Override
	public Equipamiento findById(int id) {
		return equipamientoRepository.findById(id).orElse(null);
		
	}

	@Override
	public List<Equipamiento> findAll() {
		return equipamientoRepository.findAll();
		
	}

	@Override
	public void update(Equipamiento e) {
		equipamientoRepository.save(e);
		
	}

	@Override
	public void delete(int id) {
		equipamientoRepository.deleteById(id);
		
	}

	@Override
	public void delete(Equipamiento e) {
		equipamientoRepository.delete(e);	

	}

}
