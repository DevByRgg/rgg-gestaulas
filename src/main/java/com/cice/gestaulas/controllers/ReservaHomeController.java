package com.cice.gestaulas.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import com.cice.gestaulas.exceptions.ReservaOcupadaException;
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
	 * Crear una Reserva en la BBDD
	 * @param nombreCurso
	 * @param idAula
	 * @param diaReserva
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
	 * @param attributes
	 * @return
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

	@GetMapping("reservas/buscarReserva")
	public ModelAndView buscarReservaPage() {

		ModelAndView mav = new ModelAndView();

		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();

		mav.addObject("tipoAulas", listaTipoAulas);
		mav.setViewName("reservas/buscarReserva");

		return mav;
	}

	// -------------------------------------------------------------------------------------------------------

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

	@GetMapping("reservas/realizarReservas")
	public ModelAndView realizarReservaCurso(@RequestParam(name = "nombreCurso", required = true) String nombreCurso,
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
			@RequestParam(name = "capacidadAula", required = true) int capacidadAula) throws FestivoExisteException {

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

		mav.addObject("nombreCurso", nombreCurso);
		mav.addObject("fechaInicio", fechaInicio);
		mav.addObject("cantidadHorasCurso", cantidadHorasCurso);
		mav.addObject("tipo", tipoAula);
		mav.addObject("capacidadAula", capacidadAula);
		mav.addObject("semana", diasLectivos);
		mav.addObject("horas", horas);
		mav.addObject("numeroReservas", numeroReservas);
		mav.addObject("fechaFinal", fechaFinal);

		mav.addObject("tipoAulas", listaTipoAulas);
		mav.setViewName("reservas/buscarReserva");

		return mav;
	}

	// -------------------------------------------------------------------------------------------------------
	// UPDATE
	// -------------------------------------------------------------------------------------------------------

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

	@GetMapping("reservas/borrarReserva")
	public String borrarReserva(
			@RequestParam(required = true) int id,
			RedirectAttributes attributes) {
		
		reservaService.delete(id);
		String mensaje = "La reserva ha sido borrada!"; 
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarReserva";
	}

	
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
