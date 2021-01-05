package com.cice.gestaulas.entities.auxiliar;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cice.gestaulas.entities.Aula;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjetoPresentacion {

	private int idAula;
	private String nombreAula;
	private int capacidadAula;
	private int idSede;
	private String nombreSede;
	private int idTipoAula;
	private String nombreTipoAula;
	private int coincidencias;
	
	//----Para las consultas
	public ObjetoPresentacion(int idAula, String nombreAula, int idSede, String nombreSede, int idTipoAula,
			String nombreTipoAula) {
		this.idAula = idAula;
		this.nombreAula = nombreAula;
		this.idSede = idSede;
		this.nombreSede = nombreSede;
		this.idTipoAula = idTipoAula;
		this.nombreTipoAula = nombreTipoAula;
	}

	//BuscarReserva
	public ObjetoPresentacion(int idAula, String nombreAula, int idSede, String nombreSede, int idTipoAula,
			String nombreTipoAula, int coincidencias) {
		this.idAula = idAula;
		this.nombreAula = nombreAula;
		this.idSede = idSede;
		this.nombreSede = nombreSede;
		this.idTipoAula = idTipoAula;
		this.nombreTipoAula = nombreTipoAula;
		this.coincidencias = coincidencias;
	}
	
	
	
}
