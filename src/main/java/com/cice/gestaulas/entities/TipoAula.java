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

public class TipoAula {

	@Id
	@Column(name = "id")
	@NonNull
	private int id;
	
	@Column(name = "nombre")
	@NonNull
	private String nombre;
	
	@Column(name = "id_ordenador")
	@NonNull
	private int idOrdenador;
	
	@Column(name = "id_equipamiento")
	@NonNull
	private int idEquipamiento;
	
}
