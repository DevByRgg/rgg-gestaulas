package com.cice.gestaulas.entities.auxiliar;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cice.gestaulas.entities.Aula;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Clase Entidad Aula que se corresponde con la tabla festivos de la BBDD
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
	 * Nombre del aula compuesto por la primera letra de la sede y un numero de tres cifras identificativo
	 * por ejemplo M003 para aula 003 de M (Maldonado)
	 */
	@Column(name = "nombre")
	@NonNull
	private String nombre;
	
	@Column(name = "fecha")
	@NonNull
	private LocalDate fecha;
	
	
	
}
