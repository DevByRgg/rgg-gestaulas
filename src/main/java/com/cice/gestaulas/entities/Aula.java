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
	
	@Column(name = "nombre")
	@NonNull
	private String nombre;
	
	@Column(name = "tipo")
	@NonNull
	private int tipo;
	
	@Column(name = "sede")
	@NonNull
	private int sede;
	
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
