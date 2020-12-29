package com.cice.gestaulas.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "reservas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nombre_curso")
	private String nombreCurso;
	
	@Column(name="id_aula")
	private int idAula;
	
	@Column(name="fecha_reserva")
	@NonNull
	private LocalDateTime fechaReserva;
	
}
