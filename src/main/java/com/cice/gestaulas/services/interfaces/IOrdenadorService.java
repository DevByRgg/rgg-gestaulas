package com.cice.gestaulas.services.interfaces;

import java.util.List;

import com.cice.gestaulas.entities.Ordenador;

public interface IOrdenadorService {

	public void create(Ordenador o);
	public Ordenador findById(int id);
	public List<Ordenador> findAll();
	public void update(Ordenador o);
	public void delete(int id);
	public void delete(Ordenador o);
	
}
