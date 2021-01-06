package com.cice.gestaulas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Nombre del aula compuesto por la primera letra de la sede y un numero de tres cifras identificativo
	 * por ejemplo M003 para aula 003 de M (Maldonado)
	 */
	@Column(name = "nombre")
	@NonNull
	private String nombre;
	
	@Column(name = "tipo")
	@NonNull
	private int tipo;
	
	@Column(name = "sede")
	@NonNull
	private int sede;
	
	/**
	 * Capacidad de puestos del Aula
	 */
	@Column(name = "capacidad")
	@NonNull
	private int capacidad;
	
	@Column(name = "equipo_profesor")
	@NonNull
	private int equipoProfesor;
	
	@Column(name = "equipo_alumno")
	@NonNull
	private int equipoAlumno;
	
	@Column(name = "equipamiento")
	@NonNull
	private int equipamiento;
	
			
}
