package com.cice.gestaulas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Clase Entidad Ordenador que se corresponde con la tabla ordenadores de la BBDD
 *
 */
@Entity
@Table(name = "ordenadores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordenador {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Nombre descriptivo del ordenador
	 */
	@Column(name = "nombre")
	@NotBlank(message="{ordenador.nombre.empty}")
	@Size(min = 4, max = 64, message 
    = "{ordenador.nombre.size}")
	private String nombre;
		
	/**
	 * Sistema operativo del ordenador
	 */
	@Column(name = "sistema_operativo")
	@NotBlank(message="{ordenador.sistemaOperativo.empty}")
	@Size(min = 4, max = 100, message 
    = "{ordenador.sistemaOperativo.size}")
	private String sistemaOperativo;
	
	/**
	 * Dimensión de la pantalla en pulgadas enteras
	 */
	@Column(name = "pantalla")
	@Min(message="{ordenador.dimensionPantalla.min}", value = 10)
	@Max(message="{ordenador.dimensionPantalla.max}", value=1000)
	private int dimensionPantalla;
	
	/**
	 * Descripción de la cpu del ordenador
	 */
	@Column(name = "cpu")
	@NotBlank(message="{ordenador.cpu.empty}")
	@Size(min = 4, max = 64, message 
    = "{ordenador.cpu.size}")
	private String cpu;
	
	/**
	 * Cantidad de memoria ram del ordenador en GigaBytes
	 */
	@Column(name = "ram")
	@Min(message="{ordenador.ram.min}", value = 1)
	@Max(message="{ordenador.ram.max}", value=1000)
	private int ram;
	
	/**
	 * Descripción de la tarjeta gráfica del ordenador
	 */
	@Column(name = "tarjeta_grafica")
	@NotBlank(message="{ordenador.tarjetaGrafica.empty}")
	@Size(min = 4, max = 64, message 
    = "{ordenador.tarjetaGrafica.size}")
	private String tarjetaGrafica;
	
}
