package com.cice.gestaulas.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cice.gestaulas.entities.auxiliar.Festivo;
import com.cice.gestaulas.repositories.IFestivoRepository;
import com.cice.gestaulas.services.interfaces.IFestivoService;

@Service
public class FestivoServiceImpl implements IFestivoService{

	@Autowired
	IFestivoRepository festivoRepository;
	
	@Override
	public void create(Festivo f) {
		festivoRepository.save(f);
	}

	@Override
	public Festivo findById(int id) {
		return festivoRepository.findById(id).orElse(null);
	}

	@Override
	public Festivo findByFecha(LocalDate fecha) {
		return festivoRepository.findByFecha(fecha);
	}
	
	@Override
	public List<Festivo> findAll() {
		return festivoRepository.findAll();
	}

	@Override
	public List<LocalDate> findAllFechas() {
		return festivoRepository.findAllFestivoFecha();
	}
	
	@Override
	public String findNombreByFecha(LocalDate fecha) {
		return festivoRepository.findNombreByFecha(fecha);
	}
	
	@Override
	public void update(Festivo f) {
		festivoRepository.save(f);
	}

	@Override
	public void delete(int id) {
		festivoRepository.deleteById(id);
	}

	@Override
	public void delete(Festivo f) {
		festivoRepository.delete(f);
	}

	
	
}
