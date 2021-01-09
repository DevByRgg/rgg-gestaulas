package com.cice.gestaulas.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.auxiliar.Festivo;

public interface IFestivoRepository extends JpaRepository<Festivo, Integer>{

	@Query("SELECT a.fecha FROM Festivo a")
	List<LocalDate> findAllFestivoFecha();
}
