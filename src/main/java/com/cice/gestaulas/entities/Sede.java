package com.cice.gestaulas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "sedes")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Sede {
	@Id
	@Column(name = "id")
	@NonNull
	private int id;
	
	@Column(name = "nombre")
	@NonNull
	private String nombre;
		
	@Column(name = "direccion")
	@NonNull
	private String direccion;
	
	@Column(name = "cp")
	@NonNull
	private String codigoPostal;
	
	@Column(name = "tlf")
	@NonNull
	private String telefono;
	
}
