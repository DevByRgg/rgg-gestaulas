package com.cice.gestaulas.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Clase Entidad Reserva que se corresponde con la tabla reservas de la BBDD
 *
 */
@Entity
@Table(name = "reservas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Nombre del curso
	 */
	@Column(name="nombre_curso")
	@NotBlank(message="{reserva.nombre.empty}")
	@Size(min = 4, max = 64, message 
    = "{reserva.nombre.size}")
	private String nombreCurso;
	
	/**
	 * Identificador del aula
	 */
	@Column(name="id_aula")
	private int idAula;
	
	/**
	 * Fecha de la reserva día y hora
	 */
	@Column(name="fecha_reserva")
	@NotNull(message="{reserva.fecha.empty}")
	private LocalDateTime fechaReserva;	
}
