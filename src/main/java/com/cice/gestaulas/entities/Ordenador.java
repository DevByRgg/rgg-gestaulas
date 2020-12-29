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
@Table(name = "ordenadores")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ordenador {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")
	@NonNull
	private String nombre;
		
	@Column(name = "sistema_operativo")
	@NonNull
	private String sistemaOperativo;
	
	@Column(name = "pantalla")
	@NonNull
	private int dimensionPantalla;
	
	@Column(name = "cpu")
	@NonNull
	private String cpu;
	
	@Column(name = "ram")
	@NonNull
	private int ram;
	
	@Column(name = "tarjeta_grafica")
	@NonNull
	private String tarjetaGrafica;
	

	
}
