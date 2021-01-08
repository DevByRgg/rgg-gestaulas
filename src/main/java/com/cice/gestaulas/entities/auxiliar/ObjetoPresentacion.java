package com.cice.gestaulas.entities.auxiliar;

import java.time.LocalDate;
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
	
	private String diaReserva;
	
	private int man09;
	private int man10;
	private int man11;
	private int man12;
	private int man13;
	private int man14;
	
	private int tar17;
	private int tar18;
	private int tar19;
	private int tar20;
	private int tar21;
	private int tar22;

	
	//--------------------------------------------------------------------
	//--------------------------------------------------------------------

	//Constructores-------------------------------------------------------
	
	//HorarioAula---------------------------------------------------------
	public ObjetoPresentacion(String diaReserva, int man09, int man10, int man11, int man12,
			int man13, int man14, int tar17, int tar18, int tar19, int tar20, int tar21,
			int tar22) {
		this.diaReserva = diaReserva;
		this.man09 = man09;
		this.man10 = man10;
		this.man11 = man11;
		this.man12 = man12;
		this.man13 = man13;
		this.man14 = man14;
		this.tar17 = tar17;
		this.tar18 = tar18;
		this.tar19 = tar19;
		this.tar20 = tar20;
		this.tar21 = tar21;
		this.tar22 = tar22;
	}
	
	
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

	

	

	
	

	
	
	
}
