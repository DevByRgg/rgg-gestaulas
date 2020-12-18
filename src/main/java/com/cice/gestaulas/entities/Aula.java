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
@Table(name = "aulas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Aula {
	@Id
	@Column(name = "id")
	@NonNull
	private int id;
	
	@Column(name = "tipo_aula")
	@NonNull
	private String tipoAula;
	
	@Column(name = "puestos")
	@NonNull
	private int numeroPuestos;
	
	@Column(name = "id_equipos")
	@NonNull
	private String idEquipos;
	
	@Column(name = "id_equipamiento")
	@NonNull
	private String idEquipamiento;

	
}
