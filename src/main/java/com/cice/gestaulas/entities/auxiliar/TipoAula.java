package com.cice.gestaulas.entities.auxiliar;

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
	@NotBlank(message="{tipoAula.nombre.empty}")
	@Size(min = 4, max = 128, message 
    = "{tipoAula.nombre.size}")
	private String nombre;
}
