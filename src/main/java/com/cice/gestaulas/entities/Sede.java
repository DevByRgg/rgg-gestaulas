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
	@NotBlank(message="{sede.nombre.empty}")
	@Size(min = 4, max = 64, message 
    = "{sede.nombre.size}")
	private String nombre;
		
	/**
	 * Dirección de la sede
	 */
	@Column(name = "direccion")
	@NotBlank(message="{sede.direccion.empty}")
	@Size(min = 4, max = 128, message 
    = "{sede.direccion.size}")
	private String direccion;
	
	/**
	 * Código postal de la sede
	 */
	@Column(name = "cp")
	@NotBlank(message="{sede.codigoPostal.empty}")
	@Size(min = 5, max = 16, message 
    = "{sede.codigoPostal.size}")
	private String codigoPostal;
	
	/**
	 * Número de teléfono de la sede
	 */
	@Column(name = "tlf")
	@NotBlank(message="{sede.telefono.empty}")
	@Size(min = 9, max = 16, message 
    = "{sede.telefono.size}")
	private String telefono;
	
}
