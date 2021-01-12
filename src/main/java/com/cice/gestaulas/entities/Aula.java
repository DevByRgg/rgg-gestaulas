package com.cice.gestaulas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Clase Entidad Aula que se corresponde con la tabla aulas de la BBDD
 *
 */
@Entity
@Table(name = "aulas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aula {
	/**
	 * Para indicar la capacidad mínima de las aulas
	 */
	@Transient
	final int MIN_CAPACIDAD_AULA = 1;
	
	/**
	 * Para indicar la capacidad máxima de las aulas
	 */
	@Transient
	final int MAX_CAPACIDAD_AULA = 30;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Nombre del aula compuesto por la primera letra de la sede y un numero de tres cifras identificativo
	 * por ejemplo M003 para aula 003 de M (Maldonado)
	 */
	@Column(name = "nombre")
	@NotBlank(message="{aula.nombre.empty}")
	@Size(min = 4, max = 64, message 
    = "{aula.nombre.size}")
	private String nombre;
	
	@Column(name = "tipo")
	@Min(value = 0, message="El id no puede ser inferior a 0")
	private int tipo;
	
	@Column(name = "sede")
	@Min(value = 0, message="El id no puede ser inferior a 0")
	private int sede;
	
	/**
	 * Número de puestos del Aula
	 */
	@Column(name = "capacidad")
	@Min(value = MIN_CAPACIDAD_AULA, message="{aula.capacidad.min} " + MIN_CAPACIDAD_AULA)
	@Max(value = MAX_CAPACIDAD_AULA, message="{aula.capacidad.max} " + MAX_CAPACIDAD_AULA)
	private int capacidad;
	
	/**
	 * Identificador del equipo del profesor
	 */
	@Column(name = "equipo_profesor")
	@Min(value = 0, message="El id no puede ser inferior a 0")
	private int equipoProfesor;
	
	/**
	 * Identificador del equipo de los alumnos
	 */
	@Column(name = "equipo_alumno")
	@Min(value = 0, message="El id no puede ser inferior a 0")
	private int equipoAlumno;
	
	/**
	 * Identificador del equipamiento del Aula
	 */
	@Column(name = "equipamiento")
	@Min(value = 0, message="El id no puede ser inferior a 0")
	private int equipamiento;
	
			
}
