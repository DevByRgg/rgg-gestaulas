package com.cice.gestaulas.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "reservas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="id_aula")
	private int idAula;
	
	@Column(name="id_admin")
	private int idAdmin;
	
	@Column(name="dia_inicio")
	@NonNull
	private LocalDateTime diaInicio;
	
	@Column(name="dia_fin")
	@NonNull
	private LocalDateTime diaFin;
	
	@Column(name="hora_inicio")
	@NonNull
	private LocalDateTime horaInicio;
	
	@Column(name="hora_fin")
	@NonNull
	private LocalDateTime horaFin;
}
