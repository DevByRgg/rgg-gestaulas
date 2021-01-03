package com.cice.gestaulas.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.ReactiveIsNewAwareAuditingHandler;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Reserva;
import com.cice.gestaulas.entities.TipoAula;
import com.cice.gestaulas.services.interfaces.IAulaService;
import com.cice.gestaulas.services.interfaces.IReservaService;
import com.cice.gestaulas.services.interfaces.ISedeService;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;



@Controller
public class ReservaHomeController {
	
	@Autowired
	ISedeService sedeService;
	
	@Autowired
	IAulaService aulaService;
	
	@Autowired
	ITipoAulaService tipoAulaService;
	
	@Autowired
	IReservaService reservaService;
	
	
	//-------------------------------------------------------------------------------------------------------
	//	CREATE
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("reservas/crearReserva")
	public ModelAndView crearReservaPage() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Aula> listaAulas = aulaService.findAll();
		
		mav.addObject("aulas", listaAulas);
		mav.setViewName("reservas/crearReserva");
		
		return mav;
	}
	
	
	@GetMapping("reservas/crearReservaControl")
	public String crearReserva(
			@RequestParam (name = "nombreCurso", required = true) String nombreCurso,
			@RequestParam (name = "aulaReserva", required = true) int idAula,
			@RequestParam (name = "diaReserva", required = true) String diaReserva,
			@RequestParam (name = "man09", defaultValue = "false", required = true) boolean man09,
			@RequestParam (name = "man10", defaultValue = "false", required = true) boolean man10,
			@RequestParam (name = "man11", defaultValue = "false", required = true) boolean man11,
			@RequestParam (name = "man12", defaultValue = "false", required = true) boolean man12,
			@RequestParam (name = "man13", defaultValue = "false", required = true) boolean man13,
			@RequestParam (name = "man14", defaultValue = "false", required = true) boolean man14,
			@RequestParam (name = "tar17", defaultValue = "false", required = true) boolean tar17,
			@RequestParam (name = "tar18", defaultValue = "false", required = true) boolean tar18,
			@RequestParam (name = "tar19", defaultValue = "false", required = true) boolean tar19,
			@RequestParam (name = "tar20", defaultValue = "false", required = true) boolean tar20,
			@RequestParam (name = "tar21", defaultValue = "false", required = true) boolean tar21,
			@RequestParam (name = "tar22", defaultValue = "false", required = true) boolean tar22) {
		
		LocalDate dia = LocalDate.parse(diaReserva);
		
		List<LocalTime> listaHoras = generarHoras(man09, man10, man11, man12, man13, man14, tar17,
				tar18, tar19, tar20, tar21, tar22);
		
		List<LocalDate> listaFechas = new ArrayList<LocalDate>();
		listaFechas.add(dia);
		
		List<LocalDateTime> listaFechasHoras = generarFechasHoras(listaHoras, listaFechas);
		
		List<Reserva> listaReservas = generarReservas(nombreCurso, idAula, listaFechasHoras);
		
		hacerReservas(listaReservas);
		
		return "redirect:crearReserva";
	}
	
	
	@GetMapping("reservas/buscarReserva")
	public ModelAndView buscarReservaPage() {
		
		ModelAndView mav = new ModelAndView();
		
		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();
		
		mav.addObject("tipoAulas", listaTipoAulas);
		mav.setViewName("reservas/buscarReserva");
		
		return mav;
	}
	
	@GetMapping("reservas/buscarReservaControl")
	public ModelAndView buscarReserva(
			@RequestParam (name = "nombreCurso", required = true) String nombreCurso,
			@RequestParam (name = "fechaInicio", required = true) String fechaInicio,
			@RequestParam (name = "horasCurso") int cantidadHorasCurso,
			@RequestParam (name = "lunes", defaultValue = "false", required = true) boolean lunes,
			@RequestParam (name = "martes", defaultValue = "false", required = true) boolean martes,
			@RequestParam (name = "miercoles", defaultValue = "false", required = true) boolean miercoles,
			@RequestParam (name = "jueves", defaultValue = "false", required = true) boolean jueves,
			@RequestParam (name = "viernes", defaultValue = "false", required = true) boolean viernes,
			@RequestParam (name = "sabado", defaultValue = "false", required = true) boolean sabado,
			@RequestParam (name = "man09", defaultValue = "false", required = true) boolean man09,
			@RequestParam (name = "man10", defaultValue = "false", required = true) boolean man10,
			@RequestParam (name = "man11", defaultValue = "false", required = true) boolean man11,
			@RequestParam (name = "man12", defaultValue = "false", required = true) boolean man12,
			@RequestParam (name = "man13", defaultValue = "false", required = true) boolean man13,
			@RequestParam (name = "man14", defaultValue = "false", required = true) boolean man14,
			@RequestParam (name = "tar17", defaultValue = "false", required = true) boolean tar17,
			@RequestParam (name = "tar18", defaultValue = "false", required = true) boolean tar18,
			@RequestParam (name = "tar19", defaultValue = "false", required = true) boolean tar19,
			@RequestParam (name = "tar20", defaultValue = "false", required = true) boolean tar20,
			@RequestParam (name = "tar21", defaultValue = "false", required = true) boolean tar21,
			@RequestParam (name = "tar22", defaultValue = "false", required = true) boolean tar22,
			@RequestParam (name = "tipoAula", defaultValue = "-1", required = true) int tipoAula,
			@RequestParam (name = "capacidadAula", required = true) int capacidadAula) {
		
		ModelAndView mav = new ModelAndView();
		
		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();
		List<Boolean> horas = horas(man09, man10, man11, man12, man13, man14, tar17, tar18, tar19, 
				tar20, tar21, tar22);
		
		
		Map<Integer, Boolean> diasLectivos = mapaDias(lunes, martes, miercoles, jueves, viernes, sabado);
		List<Boolean> semana = new ArrayList<Boolean>(diasLectivos.values());
		
		
		List<LocalTime> listaHorasDiarias = generarHoras(man09, man10, man11, man12, man13, man14, tar17, tar18, 
				tar19, tar20, tar21, tar22);
		
		List<LocalDateTime> listaFechasHoras = generarNecesidades(fechaInicio, cantidadHorasCurso, listaHorasDiarias, diasLectivos);

		
		Map<Integer, Integer> listaAulas = generarMapaAulas(tipoAula, capacidadAula, listaFechasHoras);
		List<Integer> aulasBusqueda = new ArrayList<Integer>(listaAulas.keySet());
		
		List<Integer> aulasValidas = new ArrayList<Integer>();
		List<Integer> aulasNoValidas = new ArrayList<Integer>();
		List<Integer> numCoincidencias = new ArrayList<Integer>();
		
		for (int i = 0; i < aulasBusqueda.size(); i++) {
			if (listaAulas.get(aulasBusqueda.get(i)) > 0) {
				aulasNoValidas.add(aulasBusqueda.get(i));
				numCoincidencias.add(listaAulas.get(aulasBusqueda.get(i)));
			} else {
				aulasValidas.add(aulasBusqueda.get(i));
			}		
		}
		
		List<Aula> listaAulaValida = new ArrayList<Aula>();
		List<Aula> listaAulaNoValida = new ArrayList<Aula>();
		List<Integer> listaCoincidencias = new ArrayList<Integer>();
		
		for (int i = 0; i < aulasValidas.size(); i++) {
			Aula a = aulaService.findById(aulasValidas.get(i));
			
			listaAulaValida.add(a);
		}
		
		for (int i = 0; i < aulasNoValidas.size(); i++) {
			Aula a = aulaService.findById(aulasNoValidas.get(i));
			
			listaAulaNoValida.add(a);
			listaCoincidencias.add(numCoincidencias.get(i));
		}
		
		System.out.println(listaAulaValida);
		System.out.println(listaAulaNoValida);
		System.out.println(listaCoincidencias);
		
		mav.addObject("aulasValidas", listaAulaValida);
		mav.addObject("aulasNoValidas", listaAulaNoValida);
		
		mav.addObject("nombreCurso", nombreCurso);
		mav.addObject("fechaInicio", fechaInicio);
		mav.addObject("cantidadHorasCurso", cantidadHorasCurso);
		mav.addObject("idAula", tipoAula);
		mav.addObject("capacidadAula", capacidadAula);
		mav.addObject("semana", semana);
		mav.addObject("horas", horas);
		
		//tenemos que meter las horas para que las mantenga
		// y un js para obligar a marcar algun check box de cada grupo (usar los id para identificarlo????)
		
		
		mav.addObject("tipoAulas", listaTipoAulas);
		mav.setViewName("reservas/buscarReserva");
		
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//	READ
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("reservas/mostrarReserva")
	public ModelAndView findAllReserva() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Reserva> listaReservas = reservaService.findAll();
		
		mav.addObject("reservas", listaReservas);
		mav.setViewName("/reservas/mostrarReserva");
		
		return mav;
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//	UPDATE
	//-------------------------------------------------------------------------------------------------------
	
	
	//-------------------------------------------------------------------------------------------------------
	//	DELETE
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("reservas/borrarReserva")
	public String borrarReserva(
			@RequestParam(required = true) int id){
		reservaService.delete(id);
		
		return "redirect:mostrarReserva";
	}
	

	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	//	AUXILIAR
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
	private Map<Integer, Boolean> mapaDias(boolean lunes, boolean martes, boolean miercoles, 
			boolean jueves, boolean viernes, boolean sabado){

		Map<Integer, Boolean> diasSemana = new HashMap<Integer, Boolean>();
		diasSemana.put(1, lunes);
		diasSemana.put(2, martes);
		diasSemana.put(3, miercoles);
		diasSemana.put(4, jueves);
		diasSemana.put(5, viernes);
		diasSemana.put(6, sabado);
		
		return diasSemana;
	}

	//-------------------------------------------------------------------------------------------------------
	
	private List<Boolean> horas(boolean man09, boolean man10, boolean man11,
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
	
	private List<LocalDate> generarFechas(
			LocalDate fechainicioCurso,
			Map<Integer, Boolean> diasLectivos,
			int duracionCurso){
		
		int diaSemanaInicioCurso = fechainicioCurso.getDayOfWeek().getValue();
		
		Map<Integer, Boolean> selecDias = new HashMap<Integer, Boolean>();

		//Separamos los dias lectivos del resto de la semana
		for (int i = 1; i < (diasLectivos.size() + 1); i++) {
			if (diasLectivos.get(i) == true) {
				selecDias.put(i, diasLectivos.get(i));
			}
		}
		
		//Cantidad de dias lectivos
		int cantidadDiasLectivos = selecDias.size();
				
		List<Integer> diaSemanaLectivos = new ArrayList<Integer>(selecDias.keySet());
		
		Map<Integer, LocalDate> primerasFechasLectivas = new HashMap<Integer, LocalDate>();
		
		for (int i = 0; i < diaSemanaLectivos.size(); i++) {
			if (diaSemanaLectivos.get(i) < diaSemanaInicioCurso) {
				int diferencia = diaSemanaLectivos.get(i) - diaSemanaInicioCurso + 7;
				LocalDate diaCurso = fechainicioCurso.plusDays(diferencia);
				primerasFechasLectivas.put(i, diaCurso);
			} 
		
			else if (diaSemanaLectivos.get(i) == diaSemanaInicioCurso) {
				primerasFechasLectivas.put(i, fechainicioCurso);
			}
			
			else if (diaSemanaLectivos.get(i) > diaSemanaInicioCurso) {
				int diferencia = diaSemanaLectivos.get(i) - diaSemanaInicioCurso;
				LocalDate diaCurso = fechainicioCurso.plusDays(diferencia);
				primerasFechasLectivas.put(i, diaCurso);
			}
		}
		
		List<LocalDate> listaPrimerasFechas = new ArrayList<>(primerasFechasLectivas.values());
		
		Collections.sort(listaPrimerasFechas);
		
		List<LocalDate> listaFechasCurso = new ArrayList<LocalDate>();
		
		int i = 0;
		int j = 0;
		while (i < duracionCurso) {
			if (cantidadDiasLectivos >= 1 && i < duracionCurso) {
				listaFechasCurso.add(i, listaPrimerasFechas.get(0).plusWeeks(j));
				i++;
			}
			
			if (cantidadDiasLectivos >= 2 && i < duracionCurso) {
				listaFechasCurso.add(i, listaPrimerasFechas.get(1).plusWeeks(j));
				i++;
			}
			
			if (cantidadDiasLectivos >= 3 && i < duracionCurso) {
				listaFechasCurso.add(i, listaPrimerasFechas.get(2).plusWeeks(j));
				i++;
			} 
			
			if (cantidadDiasLectivos >= 4 && i < duracionCurso) {
				listaFechasCurso.add(i,listaPrimerasFechas.get(3).plusWeeks(j));
				i++;
			}
		
			if (cantidadDiasLectivos >= 5 && i < duracionCurso) {
				listaFechasCurso.add(i, listaPrimerasFechas.get(4).plusWeeks(j));
				i++;
			}

			if (cantidadDiasLectivos >= 6 && i < duracionCurso) {
				listaFechasCurso.add(i, listaPrimerasFechas.get(5).plusWeeks(j));
				i++;
			}

			j++;
		
		}
		
		return listaFechasCurso;		
	}

	//-------------------------------------------------------------------------------------------------------

	private List<LocalTime> generarHoras(boolean man09, boolean man10, boolean man11,
			boolean man12, boolean man13, boolean man14, boolean tar17, boolean tar18, 
			boolean tar19, boolean tar20, boolean tar21, boolean tar22){
		
		Map<Integer, Boolean> horas = new HashMap<Integer, Boolean>();
		Map<Integer, LocalTime> listaHoras = new HashMap<Integer, LocalTime>();
		List<LocalTime> listaHorasDiarias = new ArrayList<LocalTime>();
		
		horas.put(0, man09);
		horas.put(1, man10);
		horas.put(2, man11);
		horas.put(3, man12);
		horas.put(4, man13);
		horas.put(5, man14);
		horas.put(6, tar17);
		horas.put(7, tar18);
		horas.put(8, tar19);
		horas.put(9, tar20);
		horas.put(10, tar21);
		horas.put(11, tar22);
		
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
	
	private List<LocalDateTime> generarFechasHoras(
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
	
	private List<LocalDateTime> generarResto(
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

	private List<LocalDateTime> generarNecesidades(
			String fechaInicio,
			int cantidadHorasCurso,
			List<LocalTime> listaHorasDiarias,
			Map<Integer, Boolean> diasLectivos) {
		
		LocalDate fechainicioCurso = LocalDate.parse(fechaInicio);
		
		int numeroHorasDiarias = listaHorasDiarias.size();

		int duracionCurso = 0;
		int duracionCursoResto = cantidadHorasCurso % numeroHorasDiarias;
		
		if (duracionCursoResto == 0) {
			 duracionCurso = cantidadHorasCurso / numeroHorasDiarias;
		} else {
			double duracionDecimal =  cantidadHorasCurso / numeroHorasDiarias;
			double duracionRedondeada = Math.floor(duracionDecimal);
			duracionCurso = (int)(duracionRedondeada + 1);
		}
		
		List<LocalDate> listaFechasCurso = generarFechas(fechainicioCurso, diasLectivos, duracionCurso);
		LocalDate fechaResto = null;
		
		if (duracionCursoResto != 0) {
			fechaResto = listaFechasCurso.get(listaFechasCurso.size() - 1);
			listaFechasCurso.remove(listaFechasCurso.size() - 1);
		}
		
		List<LocalDateTime> listaFechasHoras = generarFechasHoras(listaHorasDiarias, listaFechasCurso);
		List<LocalDateTime> listaFechasHorasResto = new ArrayList<LocalDateTime>();
		
		System.out.println(listaFechasHoras.size());
		
		if (duracionCursoResto != 0) {
			listaFechasHorasResto = generarResto(duracionCursoResto, fechaResto, listaHorasDiarias);
			
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

	private Map<Integer, Integer> generarMapaAulas(
			int tipoAula,
			int capacidadAula,
			List<LocalDateTime> listaFechasHoras) {
		
		List<Integer> aulasTipoCapacidad = aulaService.findAulasByTipoAndCapacidad(tipoAula, capacidadAula);
		
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

	
	private List<Reserva> generarReservas(
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
	
	private void hacerReservas(
			List<Reserva> listaReservas) {
		
		
		for (int i = 0; i < listaReservas.size(); i++) {
			reservaService.create(listaReservas.get(i));
		}
	}
	
	
}
