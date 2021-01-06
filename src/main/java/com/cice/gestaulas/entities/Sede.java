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
 * Clase Entidad Sede que se corresponde con la tabla sedes de la BBDD
 *
 */
@Entity
@Table(name = "sedes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sede {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Nombre de la sede
	 */
	@Column(name = "nombre")
	@NonNull
	private String nombre;
		
	/**
	 * Dirección de la sede
	 */
	@Column(name = "direccion")
	@NonNull
	private String direccion;
	
	/**
	 * Código postal de la sede
	 */
	@Column(name = "cp")
	@NonNull
	private String codigoPostal;
	
	/**
	 * Número de teléfono de la sede
	 */
	@Column(name = "tlf")
	@NonNull
	private String telefono;
	
}
