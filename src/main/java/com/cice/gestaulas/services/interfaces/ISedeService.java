package com.cice.gestaulas.services.interfaces;

import java.util.List;

import com.cice.gestaulas.entities.Sede;

public interface ISedeService {
	
	public void create(Sede s);
	public Sede findById(int id);
	public List<Sede> findAll();
	public void update(Sede s);
	public void delete(int id);
	public void delete(Sede s);
	
	public Sede findByNombre(String nombre);
	
}
