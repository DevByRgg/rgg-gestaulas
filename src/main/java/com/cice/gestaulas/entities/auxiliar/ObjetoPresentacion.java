package com.cice.gestaulas.entities.auxiliar;

import java.time.LocalDateTime;

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
	
	private int idSede;
	private String nombreSede;
	
	private int idAula;
	private String nombreAula;
	private int capacidadAula;
	
	private int idOrdenador;
	private String nombreOrdenador;
	
	private int idEquipamiento;
	private String nombreEquipamiento;
	
	private int idTipoAula;
	private String nombreTipoAula;
	
	private int idReserva;
	private String nombreCurso;
	private LocalDateTime fechaReserva;
	
	//--------------------------------------------------------------------
	//--------------------------------------------------------------------

	//Auxiliares----------------------------------------------------------
	private int coincidencias;

	//--------------------------------------------------------------------
	//--------------------------------------------------------------------

	//Constructores-------------------------------------------------------
	
	
	//ListadoAula---------------------------------------------------------
	public ObjetoPresentacion(int idAula, String nombreAula, int idTipoAula, String nombreTipoAula, 
			int idSede, String nombreSede,  int capacidadAula, int idOrdenador, String nombreOrdenador,
			int idEquipamiento, String nombreEquipamiento) {
		this.idAula = idAula;
		this.nombreAula = nombreAula;
		this.idTipoAula = idTipoAula;
		this.nombreTipoAula = nombreTipoAula;
		this.idSede = idSede;
		this.nombreSede = nombreSede;
		this.capacidadAula = capacidadAula;
		this.idOrdenador = idOrdenador;
		this.nombreOrdenador = nombreOrdenador;
		this.idEquipamiento = idEquipamiento;
		this.nombreEquipamiento = nombreEquipamiento;
	}
	
	//ListadoReserva------------------------------------------------------
	public ObjetoPresentacion(int idReserva, String nombreCurso,  int idAula, String nombreAula,
			LocalDateTime fechaReserva) {
		this.idReserva = idReserva;
		this.nombreCurso = nombreCurso;
		this.idAula = idAula;
		this.nombreAula = nombreAula;
		this.fechaReserva = fechaReserva;
	}
		
	//Consultas-------------------------------------------------------------
	public ObjetoPresentacion(int idAula, String nombreAula, int idSede, String nombreSede, 
			int idTipoAula, String nombreTipoAula) {
		this.idAula = idAula;
		this.nombreAula = nombreAula;
		this.idSede = idSede;
		this.nombreSede = nombreSede;
		this.idTipoAula = idTipoAula;
		this.nombreTipoAula = nombreTipoAula;
	}

	//BuscarReserva---------------------------------------------------------
	public ObjetoPresentacion(int idAula, String nombreAula, int idSede, String nombreSede, 
			int idTipoAula,	String nombreTipoAula, int coincidencias) {
		this.idAula = idAula;
		this.nombreAula = nombreAula;
		this.idSede = idSede;
		this.nombreSede = nombreSede;
		this.idTipoAula = idTipoAula;
		this.nombreTipoAula = nombreTipoAula;
		this.coincidencias = coincidencias;
	}

	public ObjetoPresentacion(int idSede, String nombreSede, int idAula, String nombreAula, int capacidadAula,
			int idOrdenador, String nombreOrdenador, int idEquipamiento, String nombreEquipamiento, int idTipoAula,
			String nombreTipoAula) {
		super();
		this.idSede = idSede;
		this.nombreSede = nombreSede;
		this.idAula = idAula;
		this.nombreAula = nombreAula;
		this.capacidadAula = capacidadAula;
		this.idOrdenador = idOrdenador;
		this.nombreOrdenador = nombreOrdenador;
		this.idEquipamiento = idEquipamiento;
		this.nombreEquipamiento = nombreEquipamiento;
		this.idTipoAula = idTipoAula;
		this.nombreTipoAula = nombreTipoAula;
	}

	
	

	
	
	
}
