package com.cice.gestaulas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Clase Entidad Equipamiento que se corresponde con la tabla equipamientos de la BBDD
 *
 */
@Entity
@Table(name = "equipamientos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Equipamiento {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Nombre del equipamiento
	 */
	@Column(name = "nombre")
	@NotBlank(message="{equipamiento.nombre.empty}")
	@Size(min = 4, max = 64, message 
    = "{equipamiento.nombre.size}")
	private String nombre;
	
	@Column(name = "descripcion")
	@NotBlank(message="{equipamiento.descripcion.empty}")
	@Size(min = 2, max = 128, message 
    = "{equipamiento.descripcion.size}")
	private String descripcion;
	
	
}
