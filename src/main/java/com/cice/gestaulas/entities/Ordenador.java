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
	@NonNull
	private String nombre;
		
	/**
	 * Sistema operativo del ordenador
	 */
	@Column(name = "sistema_operativo")
	@NonNull
	private String sistemaOperativo;
	
	/**
	 * Dimensión de la pantalla en pulgadas enteras
	 */
	@Column(name = "pantalla")
	private int dimensionPantalla;
	
	/**
	 * Descripción de la cpu del ordenador
	 */
	@Column(name = "cpu")
	@NonNull
	private String cpu;
	
	/**
	 * Cantidad de memoria ram del ordenador
	 */
	@Column(name = "ram")
	private int ram;
	
	/**
	 * Descripción de la tarjeta gráfica del ordenador
	 */
	@Column(name = "tarjeta_grafica")
	@NonNull
	private String tarjetaGrafica;
	
}
