package com.cice.gestaulas.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Reserva;

public interface IReservasRepository extends JpaRepository<Reserva, Integer> {
	
	@Query("SELECT a.fechaReserva FROM Reserva a WHERE a.idAula = :idAula")
	List<LocalDateTime> findFechasReservasByAula(
			@Param("idAula") Integer aulaSeleccionada);
	

	@Query("SELECT DISTINCT a.nombreCurso FROM Reserva a")
	List<String> findAllListaNombresCurso();
	
	
	List<Reserva> findByNombreCurso(String nombreCurso);
	List<Reserva> findByIdAula(int idAula);
	List<Reserva> findByIdAulaAndNombreCurso(int idAula, String nombreCurso);
	
	// List<String> findDistinctByNombreCurso();	No funciona
	
}
