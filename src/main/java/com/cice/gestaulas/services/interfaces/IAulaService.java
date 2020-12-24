package com.cice.gestaulas.services.interfaces;

import java.util.List;

import com.cice.gestaulas.entities.Aula;

public interface IAulaService {
	
	public void create(Aula a);
	public Aula findById(int id);
	public List<Aula> findAll();
	public void update(Aula a);
	public void delete(int id);
	public void delete(Aula a);
	
	//Query-----------------------
	public List<Aula> findBySedeAndTipo(int sede, int tipo);
	public List<Aula> findBySede(int sede);
	public List<Aula> findByTipo(int tipo);
	
}
