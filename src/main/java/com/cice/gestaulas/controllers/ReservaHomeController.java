package com.cice.gestaulas.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Reserva;
import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.entities.auxiliar.ObjetoPresentacion;
import com.cice.gestaulas.entities.auxiliar.TipoAula;
import com.cice.gestaulas.exceptions.FestivoExisteException;
import com.cice.gestaulas.services.interfaces.IAulaService;
import com.cice.gestaulas.services.interfaces.IReservaService;
import com.cice.gestaulas.services.interfaces.ISedeService;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;
import com.cice.gestaulas.utils.Utilidades;

@Secured("ROLE_USER")
@Controller
public class ReservaHomeController extends ReservaAuxiliarController {

	/**
	 * Servicios de Sede
	 */
	@Autowired
	ISedeService sedeService;

	/**
	 * Servicios de Aula
	 */
	@Autowired
	IAulaService aulaService;

	/**
	 * Servicios de TipoAula
	 */
	@Autowired
	ITipoAulaService tipoAulaService;

	/**
	 * Servicios de Reserva
	 */
	@Autowired
	IReservaService reservaService;

	// -------------------------------------------------------------------------------------------------------
	// CREATE
	// -------------------------------------------------------------------------------------------------------

	/**
	 * Cargar y mostrar la pagina crearReserva
	 * @return ModelAndView
	 */
	@GetMapping("reservas/crearReserva")
	public ModelAndView crearReservaPage() {

		ModelAndView mav = new ModelAndView();

		List<Aula> listaAulas = aulaService.findAll();

		mav.addObject("aulas", listaAulas);
		mav.setViewName("reservas/crearReserva");

		return mav;
	}

	// -------------------------------------------------------------------------------------------------------

	/**
	 * Crear una Reserva en la BBDD (Entre las 9 y las 22 horas)
	 * @param nombreCurso nombre del curso
	 * @param idAula identificador del Aula
	 * @param diaReserva String con el dia de la reserva
	 * @param man09 boolean true si queremos reservar la hora 9 y false si no
	 * @param man10 boolean true si queremos reservar la hora 10 y false si no
	 * @param man11 boolean true si queremos reservar la hora 11 y false si no
	 * @param man12 boolean true si queremos reservar la hora 12 y false si no
	 * @param man13 boolean true si queremos reservar la hora 13 y false si no
	 * @param man14 boolean true si queremos reservar la hora 14 y false si no
	 * @param tar17 boolean true si queremos reservar la hora 17 y false si no
	 * @param tar18 boolean true si queremos reservar la hora 18 y false si no
	 * @param tar19 boolean true si queremos reservar la hora 19 y false si no
	 * @param tar20 boolean true si queremos reservar la hora 20 y false si no
	 * @param tar21 boolean true si queremos reservar la hora 21 y false si no
	 * @param tar22 boolean true si queremos reservar la hora 22 y false si no
	 * @param attributes
	 * @return String "redirect:mostrarReserva". Mostrar lista de reservas
	 * @throws FestivoExisteException
	 */
	@GetMapping("reservas/crearReservaControl")
	public String crearReserva(@RequestParam(name = "nombreCurso", required = true) String nombreCurso,
			@RequestParam(name = "aulaReserva", required = true) int idAula,
			@RequestParam(name = "diaReserva", required = true) String diaReserva,
			@RequestParam(name = "man09", defaultValue = "false", required = true) boolean man09,
			@RequestParam(name = "man10", defaultValue = "false", required = true) boolean man10,
			@RequestParam(name = "man11", defaultValue = "false", required = true) boolean man11,
			@RequestParam(name = "man12", defaultValue = "false", required = true) boolean man12,
			@RequestParam(name = "man13", defaultValue = "false", required = true) boolean man13,
			@RequestParam(name = "man14", defaultValue = "false", required = true) boolean man14,
			@RequestParam(name = "tar17", defaultValue = "false", required = true) boolean tar17,
			@RequestParam(name = "tar18", defaultValue = "false", required = true) boolean tar18,
			@RequestParam(name = "tar19", defaultValue = "false", required = true) boolean tar19,
			@RequestParam(name = "tar20", defaultValue = "false", required = true) boolean tar20,
			@RequestParam(name = "tar21", defaultValue = "false", required = true) boolean tar21,
			@RequestParam(name = "tar22", defaultValue = "false", required = true) boolean tar22,
			RedirectAttributes attributes) throws FestivoExisteException {

		LocalDate dia = LocalDate.parse(diaReserva);
		
		validarFestivos(dia);
		
		List<LocalTime> listaHoras = generarHorasLectivas(man09, man10, man11, man12, man13, man14, tar17, tar18, tar19,
				tar20, tar21, tar22);

		List<LocalDate> listaFechas = new ArrayList<LocalDate>();
		listaFechas.add(dia);

		List<LocalDateTime> listaFechasHoras = generarFechasHoras(listaHoras, listaFechas);

		List<Reserva> listaReservas = generarReservas(nombreCurso, idAula, listaFechasHoras);

		//Error capturado por lo que no tenemos que meter throw ni try catch
		hacerReservas(listaReservas);

		String mensaje = "Reserva creada con exito!"; 
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarReserva";
	}

	// -------------------------------------------------------------------------------------------------------
	// BUSCADOR
	// RESERVAS--------------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------------------------------

	//TODO ELIMINAR MÉTODO NO UTILIZADO 
	/**
	 * Método para comprobar que todas las reservas solicitadas están libres
	 * @param listaReservas lista con todas las reservas de horas
	 * @return true si se puede hacer la reserva false si no se puede
	 */
	private boolean comprobarReservasLibres(List<Reserva> listaReservas) {
		boolean reservasLibres = true;
		for (Reserva reserva : listaReservas) {
			if (null != reservaService.findByIdAulaAndFechaReserva(reserva.getIdAula(), reserva.getFechaReserva())) {
				reservasLibres = false;
			}
		}
		return reservasLibres;
	}

	/**
	 * Mostrar Formulario de búsqueda de aulas libres para reservas
	 * @return ModelAndView 
	 */
	@GetMapping("reservas/buscarReserva")
	public ModelAndView buscarReservaPage() {

		ModelAndView mav = new ModelAndView();

		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();

		mav.addObject("tipoAulas", listaTipoAulas);
		mav.setViewName("reservas/buscarReserva");

		return mav;
	}

	// -------------------------------------------------------------------------------------------------------

	/**
	 * Buscador de Aulas libres para hacer reservas
	 * @param nombreCurso a buscar
	 * @param fechaInicio de la reserva
	 * @param cantidadHorasCurso reserva
	 * @param lunes 
	 * @param martes
	 * @param miercoles
	 * @param jueves
	 * @param viernes
	 * @param sabado
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
	 * @param tipoAula identificador del TipoAula
	 * @param capacidadAula capacidad del aula
	 * @return ModelAndView "reservas/buscarReserva". Aulas y su disponibilidad
	 */
	@GetMapping("reservas/buscarReservaControl")
	public ModelAndView buscarReserva(@RequestParam(name = "nombreCurso", required = true) String nombreCurso,
			@RequestParam(name = "fechaInicio", required = true) String fechaInicio,
			@RequestParam(name = "horasCurso") int cantidadHorasCurso,
			@RequestParam(name = "lunes", defaultValue = "false", required = true) boolean lunes,
			@RequestParam(name = "martes", defaultValue = "false", required = true) boolean martes,
			@RequestParam(name = "miercoles", defaultValue = "false", required = true) boolean miercoles,
			@RequestParam(name = "jueves", defaultValue = "false", required = true) boolean jueves,
			@RequestParam(name = "viernes", defaultValue = "false", required = true) boolean viernes,
			@RequestParam(name = "sabado", defaultValue = "false", required = true) boolean sabado,
			@RequestParam(name = "man09", defaultValue = "false", required = true) boolean man09,
			@RequestParam(name = "man10", defaultValue = "false", required = true) boolean man10,
			@RequestParam(name = "man11", defaultValue = "false", required = true) boolean man11,
			@RequestParam(name = "man12", defaultValue = "false", required = true) boolean man12,
			@RequestParam(name = "man13", defaultValue = "false", required = true) boolean man13,
			@RequestParam(name = "man14", defaultValue = "false", required = true) boolean man14,
			@RequestParam(name = "tar17", defaultValue = "false", required = true) boolean tar17,
			@RequestParam(name = "tar18", defaultValue = "false", required = true) boolean tar18,
			@RequestParam(name = "tar19", defaultValue = "false", required = true) boolean tar19,
			@RequestParam(name = "tar20", defaultValue = "false", required = true) boolean tar20,
			@RequestParam(name = "tar21", defaultValue = "false", required = true) boolean tar21,
			@RequestParam(name = "tar22", defaultValue = "false", required = true) boolean tar22,
			@RequestParam(name = "tipoAula", defaultValue = "0", required = true) int tipoAula,
			@RequestParam(name = "capacidadAula", required = true) int capacidadAula) {

		// Realizar Busqueda
		List<Boolean> diasLectivos = listaDiasBoleano(lunes, martes, miercoles, jueves, viernes, sabado);

		List<LocalTime> listaHorasLectivas = generarHorasLectivas(man09, man10, man11, man12, man13, man14, tar17,
				tar18, tar19, tar20, tar21, tar22);

		List<LocalDateTime> listaFechasHoras = generarNecesidades(fechaInicio, cantidadHorasCurso, listaHorasLectivas,
				diasLectivos);
		LocalDate fechaFinal = listaFechasHoras.get(listaFechasHoras.size() - 1).toLocalDate();

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

		List<ObjetoPresentacion> listaAulaValida = new ArrayList<ObjetoPresentacion>();
		List<ObjetoPresentacion> listaAulaNoValida = new ArrayList<ObjetoPresentacion>();

		for (int i = 0; i < aulasValidas.size(); i++) {
			Aula a = aulaService.findById(aulasValidas.get(i));
			Sede s = sedeService.findById(a.getSede());
			TipoAula t = tipoAulaService.findById(a.getTipo());

			ObjetoPresentacion o = new ObjetoPresentacion(a.getId(), a.getNombre(), s.getId(), s.getNombre(), t.getId(),
					t.getNombre(), 0);

			listaAulaValida.add(o);
		}

		for (int i = 0; i < aulasNoValidas.size(); i++) {
			Aula a = aulaService.findById(aulasNoValidas.get(i));
			Sede s = sedeService.findById(a.getSede());
			TipoAula t = tipoAulaService.findById(a.getTipo());
			int coincidencias = numCoincidencias.get(i);

			ObjetoPresentacion o = new ObjetoPresentacion(a.getId(), a.getNombre(), s.getId(), s.getNombre(), t.getId(),
					t.getNombre(), coincidencias);

			listaAulaNoValida.add(o);
		}

		System.out.println(listaAulaValida);
		System.out.println(listaAulaNoValida);

		// Realizar Presentacion
		ModelAndView mav = new ModelAndView();

		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();
		List<Boolean> horas = listaHorasBoleano(man09, man10, man11, man12, man13, man14, tar17, tar18, tar19, tar20,
				tar21, tar22);

		mav.addObject("aulasValidas", listaAulaValida);
		mav.addObject("aulasNoValidas", listaAulaNoValida);

		mav.addObject("nombreCurso", nombreCurso);
		mav.addObject("fechaInicio", fechaInicio);
		mav.addObject("cantidadHorasCurso", cantidadHorasCurso);
		mav.addObject("tipo", tipoAula);
		mav.addObject("capacidadAula", capacidadAula);
		mav.addObject("semana", diasLectivos);
		mav.addObject("horas", horas);
		mav.addObject("fechaFinal", fechaFinal);

		mav.addObject("tipoAulas", listaTipoAulas);
		mav.setViewName("reservas/buscarReserva");

		return mav;
	}

	// -------------------------------------------------------------------------------------------------------

	/**
	 * Realizar la reserva
	 * @param nombreCurso nombre del curso
	 * @param fechaInicio fecha de inicio del curso
	 * @param cantidadHorasCurso numero de horas del curso
	 * @param aulaSeleccionada identificador del aula seleccionada
	 * @param lunes
	 * @param martes
	 * @param miercoles
	 * @param jueves
	 * @param viernes
	 * @param sabado
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
	 * @param tipoAula identificador del tipo de aula
	 * @param capacidadAula capacidad del aula
	 * @return ModelAndView "reservas/buscarReserva"
	 * @throws FestivoExisteException
	 */
	@GetMapping("reservas/realizarReservas")
	public String realizarReservaCurso(@RequestParam(name = "nombreCurso", required = true) String nombreCurso,
			@RequestParam(name = "fechaInicio", required = true) String fechaInicio,
			@RequestParam(name = "horasCurso", required = true) int cantidadHorasCurso,
			@RequestParam(name = "aulaSeleccionada", required = true) int aulaSeleccionada,
			@RequestParam(name = "lunes", defaultValue = "false", required = true) boolean lunes,
			@RequestParam(name = "martes", defaultValue = "false", required = true) boolean martes,
			@RequestParam(name = "miercoles", defaultValue = "false", required = true) boolean miercoles,
			@RequestParam(name = "jueves", defaultValue = "false", required = true) boolean jueves,
			@RequestParam(name = "viernes", defaultValue = "false", required = true) boolean viernes,
			@RequestParam(name = "sabado", defaultValue = "false", required = true) boolean sabado,
			@RequestParam(name = "man09", defaultValue = "false", required = true) boolean man09,
			@RequestParam(name = "man10", defaultValue = "false", required = true) boolean man10,
			@RequestParam(name = "man11", defaultValue = "false", required = true) boolean man11,
			@RequestParam(name = "man12", defaultValue = "false", required = true) boolean man12,
			@RequestParam(name = "man13", defaultValue = "false", required = true) boolean man13,
			@RequestParam(name = "man14", defaultValue = "false", required = true) boolean man14,
			@RequestParam(name = "tar17", defaultValue = "false", required = true) boolean tar17,
			@RequestParam(name = "tar18", defaultValue = "false", required = true) boolean tar18,
			@RequestParam(name = "tar19", defaultValue = "false", required = true) boolean tar19,
			@RequestParam(name = "tar20", defaultValue = "false", required = true) boolean tar20,
			@RequestParam(name = "tar21", defaultValue = "false", required = true) boolean tar21,
			@RequestParam(name = "tar22", defaultValue = "false", required = true) boolean tar22,
			@RequestParam(name = "tipoAula", defaultValue = "0", required = true) int tipoAula,
			@RequestParam(name = "capacidadAula", required = true) int capacidadAula,
			RedirectAttributes attributes) throws FestivoExisteException {

		List<LocalTime> listaHorasLectivas = generarHorasLectivas(man09, man10, man11, man12, man13, man14, tar17,
				tar18, tar19, tar20, tar21, tar22);
		List<Boolean> diasLectivos = listaDiasBoleano(lunes, martes, miercoles, jueves, viernes, sabado);

		
		List<LocalDateTime> listaFechasHoras = generarNecesidades(fechaInicio, cantidadHorasCurso, listaHorasLectivas,
				diasLectivos);

		for (int i = 0; i < listaFechasHoras.size(); i++) {
			validarFestivos(listaFechasHoras.get(i).toLocalDate());
		}
		List<Reserva> listaReservas = generarReservas(nombreCurso, aulaSeleccionada, listaFechasHoras);
		int numeroReservas = listaFechasHoras.size();
		LocalDate fechaFinal = listaFechasHoras.get(listaFechasHoras.size() - 1).toLocalDate();

		
		//comprobar si se pueden reservar
		hacerReservas(listaReservas);
		
		//hacerReservas(listaReservas);

		// Realizar
		// Presentacion----------------------------------------------------------------------------------
		ModelAndView mav = new ModelAndView();

		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();
		List<Boolean> horas = listaHorasBoleano(man09, man10, man11, man12, man13, man14, tar17, tar18, tar19, tar20,
				tar21, tar22);

		System.out.println(diasLectivos);
		System.out.println(horas);
		System.out.println(numeroReservas);

		/*
		 * mav.addObject("nombreCurso", nombreCurso); mav.addObject("fechaInicio",
		 * fechaInicio); mav.addObject("cantidadHorasCurso", cantidadHorasCurso);
		 * mav.addObject("tipo", tipoAula); mav.addObject("capacidadAula",
		 * capacidadAula); mav.addObject("semana", diasLectivos); mav.addObject("horas",
		 * horas); mav.addObject("numeroReservas", numeroReservas);
		 * mav.addObject("fechaFinal", fechaFinal);
		 * 
		 * mav.addObject("tipoAulas", listaTipoAulas);
		 * mav.setViewName("reservas/buscarReserva");
		 */

		String mensaje = "Reserva realizada. El Curso '" + nombreCurso + "' finaliza " + fechaFinal.toString(); 
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarReserva";
		
		//return mav;
	}

	// -------------------------------------------------------------------------------------------------------
	// UPDATE
	// -------------------------------------------------------------------------------------------------------

	/**
	 * Cargar y mostrar la vista de updateReserva
	 * @param id identificador de la reserva
	 * @return ModelAndView /reservas/updateReserva
	 */
	@GetMapping("/reservas/updateReserva")
	public ModelAndView actualizaReserva(@RequestParam(name = "id") int id) {
		ModelAndView mav = new ModelAndView();

		List<Aula> listaAulas = aulaService.findAll();

		Reserva r = reservaService.findById(id);

		LocalDate fechaReserva = r.getFechaReserva().toLocalDate();
		LocalTime horareserva = r.getFechaReserva().toLocalTime();
		int hora = horareserva.getHour();

		List<Boolean> listaHoras = generarListaHoras(hora);

		mav.addObject("aulas", listaAulas);
		mav.addObject("reserva", r);
		mav.addObject("fechaReserva", fechaReserva);
		mav.addObject("horas", listaHoras);
		mav.setViewName("/reservas/updateReserva");

		return mav;
	}

	/**
	 * Actualizar reserva en la BBDD
	 * @param id identificador de la reserva
	 * @param nombreCurso nombre del curso
	 * @param idAula identificador del aula
	 * @param diaReserva día de la reserva
	 * @param horaReserva hora de la reserva
	 * @param attributes RedirectAttributes
	 * @return String "redirect:mostrarReserva". Mostrar todas las reservas
	 * @throws FestivoExisteException
	 */
	@GetMapping("reservas/updateReservaControl")
	public String updateReserva(@RequestParam(name = "id", required = true) int id,
			@RequestParam(name = "nombreCurso", required = true) String nombreCurso,
			@RequestParam(name = "aulaReserva", required = true) int idAula,
			@RequestParam(name = "diaReserva", required = true) String diaReserva,
			@RequestParam(name = "hora", required = true) int horaReserva,
			RedirectAttributes attributes) throws FestivoExisteException {

		LocalDate dia = LocalDate.parse(diaReserva);
		LocalTime hora = LocalTime.of(horaReserva, 0);
		
		validarFestivos(dia);

		LocalDateTime fechaReserva = LocalDateTime.of(dia, hora);

		Reserva r = new Reserva(id, nombreCurso, idAula, fechaReserva);
		
		if (reservaService.findById(id).equals(r)) {
			String mensaje = "No se ha modificado ningun dato!"; 
			Utilidades.atributos(2, mensaje, attributes);
		} else {
			reservaService.update(r);
			String mensaje = "Se ha actualizado la reserva con exito!"; 
			Utilidades.atributos(1, mensaje, attributes);
		}
		return "redirect:mostrarReserva";
	}

	// -------------------------------------------------------------------------------------------------------
	// DELETE
	// -------------------------------------------------------------------------------------------------------

	/**
	 * Borrar Reservas de la BBDD
	 * @param id identificador de la reserva
	 * @param attributes RedirectAttributes
	 * @return String "redirect:mostrarReserva". Mostrar todas las reservas
	 */
	@GetMapping("reservas/borrarReserva")
	public String borrarReserva(
			@RequestParam(required = true) int id,
			RedirectAttributes attributes) {
		
		reservaService.delete(id);
		String mensaje = "La reserva ha sido borrada!"; 
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarReserva";
	}

	/**
	 * Cargar y mostrar vista /reservas/borrarDiaCurso
	 * Formularios para poder borrar las reservas de días y/o cursos enteros
	 * @return ModelAndView con el formulario /reservas/borrarDiaCurso
	 */
	@GetMapping("reservas/borrarCursoReserva")
	public ModelAndView borrarDiaCursoReserva() {
		ModelAndView mav = new ModelAndView();
		List<Aula> listaAulas = aulaService.findAll();
		List<String> listaCursos = reservaService.findAllListaCursos();
		
		mav.addObject("cursos", listaCursos);
		mav.addObject("aulas", listaAulas);
		mav.setViewName("/reservas/borrarDiaCurso");
		return mav;
	}
	
	/**
	 * Borrar Dia entero en la tabla Reservas de la BBDD
	 * @param fecha Fecha a borrar
	 * @param idAula identificador del Aula
	 * @param attributes RedirectAttributes
	 * @return String "redirect:mostrarReserva". Mostrar lista de reservas
	 */
	@GetMapping("reservas/borrarDiaControl")	
	public String borrarDiaReserva(
			@RequestParam(name = "fechaDia", required = true) String fecha,
			@RequestParam(name = "idAula", required = true) int idAula,
			RedirectAttributes attributes) {
		LocalDate fechaReserva = LocalDate.parse(fecha);
		List<Reserva> listaReservas = new ArrayList<Reserva>();
		List<Reserva> listaBorrar = new ArrayList<Reserva>();
		
		if (idAula == -1) {
			listaReservas = reservaService.findAll();
		} else {
			listaReservas = reservaService.findAllByAula(idAula);
		}
		
		for (int i = 0; i < listaReservas.size(); i++) {
			LocalDate f = listaReservas.get(i).getFechaReserva().toLocalDate();
			if(f.equals(fechaReserva)) {
				listaBorrar.add(listaReservas.get(i));	
			}
		}

		for (int i = 0; i < listaBorrar.size(); i++) {
			reservaService.delete(listaBorrar.get(i));
		}
		
		String mensaje = listaBorrar.size() + " reservas han sido borradas!"; 
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarReserva";	
	}
	
	/**
	 * Borrar curso entero
	 * @param nombreCurso nombre del curso a borrar
	 * @param attributes RedirectAttributes
	 * @return String "redirect:mostrarReserva". Mostrar lista de reservas
	 */
	@GetMapping("reservas/borrarCursoControl")	
	public String borrarCursoReserva(
			@RequestParam(name = "nombreCurso", required = true) String nombreCurso,
			RedirectAttributes attributes) {
		List<Reserva> listaReservas = reservaService.findAllByCurso(nombreCurso);
		
		for (int i = 0; i < listaReservas.size(); i++) {
			reservaService.delete(listaReservas.get(i));
		}
		
		String mensaje = listaReservas.size() + " reservas han sido borradas!"; 
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarReserva";		
	}
}	
