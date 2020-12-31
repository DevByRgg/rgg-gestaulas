package com.cice.gestaulas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cice.gestaulas.entities.Sede;

public interface ISedeRepository extends JpaRepository<Sede, Integer>{

	public Sede findByNombre(String nombre);
}
