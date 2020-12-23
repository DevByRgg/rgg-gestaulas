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
@Table(name = "tipo_aulas")
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
}