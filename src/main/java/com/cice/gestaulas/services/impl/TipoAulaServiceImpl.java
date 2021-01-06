package com.cice.gestaulas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cice.gestaulas.entities.TipoAula;
import com.cice.gestaulas.repositories.ITipoAulaRepository;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;

@Service
public class TipoAulaServiceImpl implements ITipoAulaService{
	
	@Autowired
	ITipoAulaRepository tipoAulaRepository;
	
	@Override
	public void create(TipoAula t) {
		tipoAulaRepository.save(t);
	}

	@Override
	public TipoAula findById(int id) {
		return tipoAulaRepository.findById(id).orElse(null);
	}

	@Override
	public List<TipoAula> findAll() {
		return tipoAulaRepository.findAll();
	}

	@Override
	public void update(TipoAula t) {
		if(this.findById(t.getId())!=null) {
			tipoAulaRepository.save(t);
		}else {
			//TODO GESTIONAR ERROR NO SE PUEDE ACTUALIZAR UN OBJETO QUE NO EXISTE CREARIA UNO NUEVO
		}
		
	}

	@Override
	public void delete(int id) {
		tipoAulaRepository.deleteById(id);
	}

	@Override
	public void delete(TipoAula t) {
		tipoAulaRepository.delete(t);
	}

}
