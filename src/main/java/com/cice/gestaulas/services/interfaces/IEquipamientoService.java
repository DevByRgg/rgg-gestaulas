package com.cice.gestaulas.services.interfaces;

import java.util.List;

import com.cice.gestaulas.entities.Equipamiento;

public interface IEquipamientoService {

	public void create(Equipamiento e);
	public Equipamiento findById(int id);
	public List<Equipamiento> findAll();
	public void update(Equipamiento e);
	public void delete(int id);
	public void delete(Equipamiento e);
	
}
