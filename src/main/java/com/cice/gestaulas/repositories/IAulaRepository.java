package com.cice.gestaulas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cice.gestaulas.entities.Aula;

public interface IAulaRepository extends JpaRepository<Aula, Integer>{

	@Query("SELECT a FROM Aula a WHERE a.sede = :sede AND a.tipo = :tipo")
	List<Aula> findAulasBySedeAndTipo(
			@Param("sede") Integer sedeSeleccionada,
			@Param("tipo") Integer tipoSeleccionado);
	
	@Query("SELECT a FROM Aula a WHERE a.sede = :sede")
	List<Aula> findAulasBySede(
			@Param("sede") Integer sedeSeleccionada);
	
	@Query("SELECT a FROM Aula a WHERE a.tipo = :tipo")
	List<Aula> findAulasByTipo(
			@Param("tipo") Integer tipoSeleccionado);
	
}
