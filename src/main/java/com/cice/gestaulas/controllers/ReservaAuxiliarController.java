package com.cice.gestaulas.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import com.cice.gestaulas.entities.Reserva;
import com.cice.gestaulas.entities.auxiliar.Festivo;
import com.cice.gestaulas.exceptions.FestivoExisteException;
import com.cice.gestaulas.exceptions.ReservaOcupadaException;
import com.cice.gestaulas.services.interfaces.IAulaService;
import com.cice.gestaulas.services.interfaces.IFestivoService;
import com.cice.gestaulas.services.interfaces.IReservaService;
import com.cice.gestaulas.services.interfaces.ISedeService;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;

@Secured("ROLE_USER")
public class ReservaAuxiliarController {
	
	@Autowired
	ISedeService sedeService;
	
	@Autowired
	IAulaService aulaService;
	
	@Autowired
	ITipoAulaService tipoAulaService;
	
	@Autowired
	IReservaService reservaService;
	
	@Autowired
	IFestivoService festivoService;
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------

	/**
	 * Comprobar que una fecha no sea un dia festivo ni un domingo
	 * @param fecha a validar
	 * @throws FestivoExisteException Excepcion informando del error
	 */
	protected void validarFestivos(LocalDate fecha) throws FestivoExisteException{
		List<LocalDate> listaFestivos = festivoService.findAllFechas();
		boolean existe = listaFestivos.contains(fecha);
		
		if (existe) {
			throw new FestivoExisteException("No se puede reservar, es un dia festivo");
		} else if(fecha.getDayOfWeek().getValue() == 7) {
			throw new FestivoExisteException("No se puede reservar, es domingo");
		}
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------

	/**
	 * Obtener la lista de días seleccionados en el buscador
	 * @param martes
	 * @param miercoles
	 * @param jueves
	 * @param viernes
	 * @param sabado
	 * @return Lista con la semana válida
	 */
	protected List<Boolean> listaDiasBoleano(boolean lunes, boolean martes, boolean miercoles, 
			boolean jueves, boolean viernes, boolean sabado){
		List<Boolean> diasSemana = new ArrayList<Boolean>();
		diasSemana.add(lunes);
		diasSemana.add(martes);
		diasSemana.add(miercoles);
		diasSemana.add(jueves);
		diasSemana.add(viernes);
		diasSemana.add(sabado);
		
		return diasSemana;
	}

	//-------------------------------------------------------------------------------------------------------
	
	/**
	 * Obtener la lista con las horas seleccionadas del buscador
	 * @param man09
	 * @param man10
	 * @param man11
	 * @param man12
	 * @param man13
	 * @param man14
	 * @param tar17
	 * @param tar18
	 * @param tar19
	 * @param tar20
	 * @param tar21
	 * @param tar22
	 * @return Lista con las horas válidas del día
	 */
	protected List<Boolean> listaHorasBoleano(boolean man09, boolean man10, boolean man11,
			boolean man12, boolean man13, boolean man14, boolean tar17, boolean tar18, 
			boolean tar19, boolean tar20, boolean tar21, boolean tar22){
		
		List<Boolean> horas = new ArrayList<Boolean>();
		
		horas.add(man09);
		horas.add(man10);
		horas.add(man11);
		horas.add(man12);
		horas.add(man13);
		horas.add(man14);
		horas.add(tar17);
		horas.add(tar18);
		horas.add(tar19);
		horas.add(tar20);
		horas.add(tar21);
		horas.add(tar22);
		
		return horas;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	/**
	 * Genera una lista con las horas 
	 * @param hora entero con la hora a poner en true
	 * @return Lista con todo en false menos el int recibido por parámetro
	 */
	protected List<Boolean> generarListaHoras(int hora) {
		boolean man09 = false;
		boolean man10 = false;
		boolean man11 = false;
		boolean man12 = false;
		boolean man13 = false;
		boolean man14 = false;
		boolean tar17 = false;
		boolean tar18 = false;
		boolean tar19 = false;
		boolean tar20 = false;
		boolean tar21 = false;
		boolean tar22 = false;

		if (hora == 9) {man09 = true;}
		if (hora == 10) {man10 = true;}
		if (hora == 11) {man11 = true;}
		if (hora == 12) {man12 = true;}
		if (hora == 13) {man13 = true;}
		if (hora == 14) {man14 = true;}
		if (hora == 17) {tar17 = true;}
		if (hora == 18) {tar18 = true;}
		if (hora == 19) {tar19 = true;}
		if (hora == 20) {tar20 = true;}
		if (hora == 21) {tar21 = true;}
		if (hora == 22) {tar22 = true;}
		
		List<Boolean> listaHoras = listaHorasBoleano(man09, man10, man11, man12, man13, 
				man14, tar17, tar18, tar19, tar20, tar21, tar22);
		
		return listaHoras;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	/**
	 * Generar fechas validas para dar el curso
	 * @param fechainicioCurso
	 * @param diasLectivos
	 * @param duracionCurso
	 * @return Lista de fechas validas
	 */
	protected List<LocalDate> generarFechasCurso(
			LocalDate fechainicioCurso,
			List<Boolean> diasLectivos,
			int duracionCurso){
		
		int diaSemanaInicioCurso = fechainicioCurso.getDayOfWeek().getValue();
		
		Map<Integer, Boolean> selecDias = new HashMap<Integer, Boolean>();

		//Separamos los dias lectivos del resto de la semana
		for (int i = 0; i < diasLectivos.size(); i++) {
			if (diasLectivos.get(i) == true) {
				selecDias.put(i + 1, diasLectivos.get(i));
			}
		}
		
		System.out.println(selecDias);
		
		//Cantidad de dias lectivos
		int cantidadDiasLectivos = selecDias.size();
				
		List<Integer> diaSemanaLectivos = new ArrayList<Integer>(selecDias.keySet());
		
		List<LocalDate> listaPrimerasFechas = new ArrayList<LocalDate>();
		
		for (int i = 0; i < diaSemanaLectivos.size(); i++) {
			if (diaSemanaLectivos.get(i) < diaSemanaInicioCurso) {
				int diferencia = diaSemanaLectivos.get(i) - diaSemanaInicioCurso + 7;
				LocalDate diaCurso = fechainicioCurso.plusDays(diferencia);
				listaPrimerasFechas.add(diaCurso);
			} 
		
			else if (diaSemanaLectivos.get(i) == diaSemanaInicioCurso) {
				listaPrimerasFechas.add(fechainicioCurso);
			}
			
			else if (diaSemanaLectivos.get(i) > diaSemanaInicioCurso) {
				int diferencia = diaSemanaLectivos.get(i) - diaSemanaInicioCurso;
				LocalDate diaCurso = fechainicioCurso.plusDays(diferencia);
				listaPrimerasFechas.add(diaCurso);
			}
		}
		
		Collections.sort(listaPrimerasFechas);
		
		List<LocalDate> listaFestivos = festivoService.findAllFechas();
		
		
		List<LocalDate> listaFechasCurso = new ArrayList<LocalDate>();
		
		int i = 0;
		int j = 0;
		while (i < duracionCurso) {
			if (cantidadDiasLectivos >= 1 && i < duracionCurso) {
				LocalDate fecha = listaPrimerasFechas.get(0).plusWeeks(j);
				boolean existe = listaFestivos.contains(fecha);
					if (!existe) {
						listaFechasCurso.add(i, fecha);
						i++;
					}
			}
			
			if (cantidadDiasLectivos >= 2 && i < duracionCurso) {
				LocalDate fecha = listaPrimerasFechas.get(1).plusWeeks(j);
				boolean existe = listaFestivos.contains(fecha);
					if (!existe) {
						listaFechasCurso.add(i, fecha);
						i++;
					}
			}
			
			if (cantidadDiasLectivos >= 3 && i < duracionCurso) {
				LocalDate fecha = listaPrimerasFechas.get(2).plusWeeks(j);
				boolean existe = listaFestivos.contains(fecha);
					if (!existe) {
						listaFechasCurso.add(i, fecha);
						i++;
					}
			} 
			
			if (cantidadDiasLectivos >= 4 && i < duracionCurso) {
				LocalDate fecha = listaPrimerasFechas.get(3).plusWeeks(j);
				boolean existe = listaFestivos.contains(fecha);
					if (!existe) {
						listaFechasCurso.add(i, fecha);
						i++;
					}
			}
		
			if (cantidadDiasLectivos >= 5 && i < duracionCurso) {
				LocalDate fecha = listaPrimerasFechas.get(4).plusWeeks(j);
				boolean existe = listaFestivos.contains(fecha);
					if (!existe) {
						listaFechasCurso.add(i, fecha);
						i++;
					}
			}

			if (cantidadDiasLectivos >= 6 && i < duracionCurso) {
				LocalDate fecha = listaPrimerasFechas.get(5).plusWeeks(j);
				boolean existe = listaFestivos.contains(fecha);
					if (!existe) {
						listaFechasCurso.add(i, fecha);
						i++;
					}
			}

			j++;
		
		}
		
		
		return listaFechasCurso;		
	}

	//-------------------------------------------------------------------------------------------------------

	/**
	 * Relaccionar las horas lectivas con las horas seleccionadas
	 * @param man09
	 * @param man10
	 * @param man11
	 * @param man12
	 * @param man13
	 * @param man14
	 * @param tar17
	 * @param tar18
	 * @param tar19
	 * @param tar20
	 * @param tar21
	 * @param tar22
	 * @return List de horas en formato LocalTime
	 */
	protected List<LocalTime> generarHorasLectivas(boolean man09, boolean man10, boolean man11,
			boolean man12, boolean man13, boolean man14, boolean tar17, boolean tar18, 
			boolean tar19, boolean tar20, boolean tar21, boolean tar22){
		
		Map<Integer, LocalTime> listaHoras = new HashMap<Integer, LocalTime>();
		List<LocalTime> listaHorasDiarias = new ArrayList<LocalTime>();
		
		List<Boolean> horas = listaHorasBoleano(man09, man10, man11, man12, man13,
				man14, tar17, tar18, tar19, tar20, tar21, tar22);
		
		for (int i = 0; i < 6; i++) {
			listaHoras.put(i, LocalTime.of(i + 9, 0));
			listaHoras.put(i + 6, LocalTime.of(i + 17, 0));
		}
		
		for (int i = 0; i < horas.size(); i++) {
			if (horas.get(i) == true) {
				listaHorasDiarias.add(listaHoras.get(i));
			}
		}
		
		return listaHorasDiarias;
	}

	//-------------------------------------------------------------------------------------------------------
	
	/**
	 * Para reservar las horas de cada día 
	 * @param listaHorasDiarias
	 * @param listaFechasCurso
	 * @return Lista con las fechas y las horas a reservar
	 */
	protected List<LocalDateTime> generarFechasHoras(
			List<LocalTime> listaHorasDiarias,
			List<LocalDate> listaFechasCurso) {
		
		List<LocalDateTime> listaFechasHoras = new ArrayList<LocalDateTime>();
		
		for (int i = 0; i < listaFechasCurso.size(); i++) {
			for (int j = 0; j < listaHorasDiarias.size(); j++) {
				LocalDateTime ldt = LocalDateTime.of(listaFechasCurso.get(i), listaHorasDiarias.get(j));
				
				listaFechasHoras.add(ldt);
			}
		}
		
		return listaFechasHoras;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	/**
	 * Para meter las horas restantes en el ultimo día
	 * @param duracionCursoResto
	 * @param fechaResto
	 * @param listaHorasDiarias
	 * @return Lista con las horas restantes para completar el curso
	 */
	protected List<LocalDateTime> generarResto(
			int duracionCursoResto,
			LocalDate fechaResto,
			List<LocalTime> listaHorasDiarias) {
		
		List<LocalDateTime> listaFechasHorasResto = new ArrayList<LocalDateTime>();
		
		for (int i = 0; i < duracionCursoResto; i++) {
			LocalDateTime ldt = LocalDateTime.of(fechaResto, listaHorasDiarias.get(i));
			
			listaFechasHorasResto.add(ldt);
		}
		
		return listaFechasHorasResto;
	}
	
	//-------------------------------------------------------------------------------------------------------

	/**
	 * Calcular dias y horas de las reservas
	 * @param fechaInicio
	 * @param cantidadHorasCurso
	 * @param listaHorasLectivas
	 * @param diasLectivos
	 * @return Lista de fechas y las horas a reservar
	 */
	protected List<LocalDateTime> generarNecesidades(
			String fechaInicio,
			int cantidadHorasCurso,
			List<LocalTime> listaHorasLectivas,
			List<Boolean> diasLectivos) {
		
		LocalDate fechainicioCurso = LocalDate.parse(fechaInicio);
		
		int numeroHorasDiarias = listaHorasLectivas.size();

		int duracionCurso = 0;
		int duracionCursoResto = cantidadHorasCurso % numeroHorasDiarias;
		
		if (duracionCursoResto == 0) {
			 duracionCurso = cantidadHorasCurso / numeroHorasDiarias;
		} else {
			double duracionDecimal =  cantidadHorasCurso / numeroHorasDiarias;
			double duracionRedondeada = Math.floor(duracionDecimal);
			duracionCurso = (int)(duracionRedondeada + 1);
		}
		
		List<LocalDate> listaFechasCurso = generarFechasCurso(fechainicioCurso, diasLectivos, duracionCurso);
		LocalDate fechaResto = null;
		
		if (duracionCursoResto != 0) {
			fechaResto = listaFechasCurso.get(listaFechasCurso.size() - 1);
			listaFechasCurso.remove(listaFechasCurso.size() - 1);
		}
		
		List<LocalDateTime> listaFechasHoras = generarFechasHoras(listaHorasLectivas, listaFechasCurso);
		List<LocalDateTime> listaFechasHorasResto = new ArrayList<LocalDateTime>();
		
		System.out.println(listaFechasHoras.size());
		
		if (duracionCursoResto != 0) {
			listaFechasHorasResto = generarResto(duracionCursoResto, fechaResto, listaHorasLectivas);
			
			for (int i = 0; i < listaFechasHorasResto.size(); i++) {
				listaFechasHoras.add(listaFechasHorasResto.get(i));
			}
		}
		
		//-------------------------------------------------------------------------
				System.out.println(listaFechasHoras);
				System.out.println(listaFechasHoras.size());
				System.out.println(listaFechasHorasResto);
				System.out.println(listaFechasHorasResto.size());
		//-------------------------------------------------------------------------
				
		return listaFechasHoras;
	}

	//-------------------------------------------------------------------------------------------------------

	
	protected Map<Integer, Integer> generarMapaAulas(
			int tipoAula,
			int capacidadAula,
			List<LocalDateTime> listaFechasHoras) {
		
		List<Integer> aulasTipoCapacidad = aulaService.findAulasByTipoAndCapacidad(tipoAula, capacidadAula);
		
		if (tipoAula == 0) {
			aulasTipoCapacidad.clear();
			aulasTipoCapacidad.addAll(aulaService.findAulasByCapacidad(capacidadAula));	
		} 
		
		Map<Integer, Integer> listaAulas = new HashMap<Integer, Integer>();
		
		
		for (int i = 0; i < aulasTipoCapacidad.size(); i++) {
			List<LocalDateTime> fechasValidas = reservaService.findFechasByAulas(aulasTipoCapacidad.get(i));
			int cantidadCoincidencias = 0;
			boolean comparacion = false;
			
			System.out.println(fechasValidas);
			
			for (int j = 0; j < listaFechasHoras.size(); j++) {
				comparacion = fechasValidas.contains(listaFechasHoras.get(j));
				
				if (comparacion == true) {
					cantidadCoincidencias++;	
				}
			}
			
		listaAulas.put(aulasTipoCapacidad.get(i), cantidadCoincidencias);
		
		}	
		
		System.out.println(listaAulas);
		
		return listaAulas;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------

	/**
	 * Método para generar la List con todas las reservas de un curso
	 * @param nombreCurso nombre del curso para hacer la reserva
	 * @param idAula id del Aula reservada para el curso
	 * @param listaFechasHoras una lista con todas las fechas y horas reservadas
	 * @return
	 */
	protected List<Reserva> generarReservas(
			String nombreCurso,
			int idAula,
			List<LocalDateTime> listaFechasHoras) {

		List<Reserva> listaReservas = new ArrayList<Reserva>();
		
		for (int i = 0; i < listaFechasHoras.size(); i++) {
			Reserva r = new Reserva(0, nombreCurso, idAula, listaFechasHoras.get(i));
			
			listaReservas.add(r);
		}
		
		return listaReservas;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
	/**
	 * Método para guardar en BBDD las reservas de un curso
	 * @param listaReservas List de Reserva
	 */
	protected void hacerReservas(
			List<Reserva> listaReservas) {
		
		  for (int i = 0; i < listaReservas.size(); i++) {
		  reservaService.create(listaReservas.get(i)); }
	}
}
