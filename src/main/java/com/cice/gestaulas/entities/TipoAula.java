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
 * Clase Entidad TipoAula que se corresponde con la tabla tipo_aulas de la BBDD
 *
 */
@Entity
@Table(name = "tipo_aulas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoAula {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Nombre identificativo del tipo de aula. Por ejemplo Windows, Mac...
	 * Es la clase que especificara el tipo de cada Aula
	 */
	@Column(name = "nombre")
	@NonNull
	private String nombre;
}
