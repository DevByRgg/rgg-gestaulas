package com.cice.gestaulas.entities.auxiliar;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Clase Entidad Festivo que se corresponde con la tabla festivos de la BBDD
 *
 */
@Entity
@Table(name = "festivos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Festivo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Nombre del festivo
	 */
	@Column(name = "nombre")
	@NotBlank(message="El nombre es obligatorio")
	private String nombre;
	
	/**
	 * Fecha del festivo
	 */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "fecha")
	private LocalDate fecha;
	
	
	
}
