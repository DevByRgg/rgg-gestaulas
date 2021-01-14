package com.cice.gestaulas.entities.auxiliar;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
	
	private int man09;	private int man10;	private int man11;
	private int man12;	private int man13;	private int man14;
	
	private int tar17;	private int tar18;	private int tar19;
	private int tar20;	private int tar21;	private int tar22;
	
	private String manTitle09;	private String manTitle10;	private String manTitle11;
	private String manTitle12;	private String manTitle13;	private String manTitle14;
	
	private String tarTitle17;	private String tarTitle18;	private String tarTitle19;
	private String tarTitle20;	private String tarTitle21;	private String tarTitle22;

	
	//--------------------------------------------------------------------
	//--------------------------------------------------------------------

	//Constructores-------------------------------------------------------
	
	//HorarioAula---------------------------------------------------------
	public ObjetoPresentacion(String diaReserva, int man09, String manTitle09,int man10, String manTitle10,
			int man11, String manTitle11, int man12, String manTitle12, int man13, String manTitle13,
			int man14, String manTitle14, int tar17, String tarTitle17, int tar18, String tarTitle18,
			int tar19, String tarTitle19, int tar20, String tarTitle20, int tar21, String tarTitle21,
			int tar22, String tarTitle22) {
		this.diaReserva = diaReserva;
		this.man09 = man09;		this.man10 = man10;		this.man11 = man11;
		this.man12 = man12;		this.man13 = man13;		this.man14 = man14;
		
		this.tar17 = tar17;		this.tar18 = tar18;		this.tar19 = tar19;
		this.tar20 = tar20;		this.tar21 = tar21;		this.tar22 = tar22;
		
		this.manTitle09 = manTitle09;		this.manTitle10 = manTitle10;		this.manTitle11 = manTitle11;
		this.manTitle12 = manTitle12;		this.manTitle13 = manTitle13;		this.manTitle14 = manTitle14;
		
		this.tarTitle17 = tarTitle17;		this.tarTitle18 = tarTitle18;		this.tarTitle19 = tarTitle19;
		this.tarTitle20 = tarTitle20;		this.tarTitle21 = tarTitle21;		this.tarTitle22 = tarTitle22;
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
