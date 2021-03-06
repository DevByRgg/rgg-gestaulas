package com.cice.gestaulas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.repositories.ISedeRepository;
import com.cice.gestaulas.services.interfaces.ISedeService;

@Service
public class SedeServiceImpl implements ISedeService{

	@Autowired
	ISedeRepository sedeRepository;
	
	@Override
	public void create(Sede s) {
		sedeRepository.save(s);
	}

	
	@Override
	public Sede findById(int id) {
		return sedeRepository.findById(id).orElse(null);
	}

	
	@Override
	public List<Sede> findAll() {
		return sedeRepository.findAll();
	}

	
	@Override
	public void update(Sede s) {
		if(this.findById(s.getId())!=null) {
			sedeRepository.save(s);	
		}else {
			//TODO GESTIONAR ERROR NO SE PUEDE ACTUALIZAR UN OBJETO QUE NO EXISTE CREARIA UNO NUEVO
		}	
	}

	
	@Override
	public void delete(int id) {
		sedeRepository.deleteById(id);
	}

	
	@Override
	public void delete(Sede s) {
		sedeRepository.delete(s);	
	}


	@Override
	public Sede findByNombre(String nombre) {
		return sedeRepository.findByNombre(nombre);
	}

}
