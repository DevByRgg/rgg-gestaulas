package com.cice.gestaulas.services.interfaces;

import java.util.List;

import com.cice.gestaulas.entities.TipoAula;

public interface ITipoAulaService {

	public void create(TipoAula t);
	public TipoAula findById(int id);
	public List<TipoAula> findAll();
	public void update(TipoAula t);
	public void delete(int id);
	public void delete(TipoAula t);
	
}
