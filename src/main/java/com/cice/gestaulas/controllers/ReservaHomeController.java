package com.cice.gestaulas.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		Map<Integer, Boolean> horas = mapaHoras(man09, man10, man11, man12, man13, 
				man14, tar17, tar18, tar19, tar20, tar21, tar22);
		
		Map<Integer, Reserva> reservas = generarReservas(nombreCurso, idAula, dia, horas);
		
		hacerReservas(reservas);
		
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
			@RequestParam (name = "horasCurso") int horasCurso,
			@RequestParam (name = "horasDia") int horasDia,
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
			@RequestParam (name = "tipoAula") int tipoAula,
			@RequestParam (name = "capacidadAula") int capacidadAula) {
		
		LocalDate inicioCurso = LocalDate.parse(fechaInicio);
		int diasCurso = horasCurso / horasDia;
		Map<Integer, Boolean> horas = mapaHoras(man09, man10, man11, man12, man13, 
				man14, tar17, tar18, tar19, tar20, tar21, tar22);
		Map<Integer, Boolean> diasSemana = mapaDias(lunes, martes, miercoles, jueves, viernes, sabado);
		
		Map<Integer, Integer> diasDeCurso = new HashMap<Integer, Integer>();
		
		Map<Integer, Boolean> selecDias = new HashMap<Integer, Boolean>();
		for (int i = 1; i < (diasSemana.size() + 1); i++) {
			if (diasSemana.get(i) == true) {
				selecDias.put(i, diasSemana.get(i));
			}
		}
		
		List<Integer> listaSelecDias = new ArrayList<Integer>(selecDias.keySet());
		
		int numDias = selecDias.size();
		
		int diaInicioCurso = inicioCurso.getDayOfWeek().getValue();
		
		System.out.println( "diascurso" + diasCurso);
		System.out.println("numDias" + numDias);
		System.out.println("diaInicioCurso" + diaInicioCurso);
		System.out.println("selecDias" + selecDias.size());
		System.out.println(listaSelecDias.get(0));
		System.out.println(listaSelecDias.get(1));
		System.out.println(listaSelecDias.get(2));
		
		
		
		ModelAndView mav = new ModelAndView();
		
		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();
		
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
	//-------------------------------------------------------------------------------------------------------
	//	AUXILIAR
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
	private Map<Integer, Boolean> mapaHoras(boolean man09, boolean man10, boolean man11,
			boolean man12, boolean man13, boolean man14, boolean tar17, boolean tar18, 
			boolean tar19, boolean tar20, boolean tar21, boolean tar22){
		
		Map<Integer, Boolean> horas = new HashMap<Integer, Boolean>();
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
	
		return horas;
	}
	
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

	
	private Map<Integer, Reserva> generarReservas(
			String nombreCurso,
			int idAula,
			LocalDate dia,
			Map<Integer, Boolean> horas) {

		Map<Integer, LocalTime> listaHoras = new HashMap<Integer, LocalTime>();
		Map<Integer, LocalDateTime> horasSesion = new HashMap<Integer, LocalDateTime>();
		Map<Integer, Reserva> mapaReservas = new HashMap<Integer, Reserva>();
		int j = 0;
		
		
		for (int i = 0; i < 6; i++) {
			listaHoras.put(i, LocalTime.of(i + 9, 0));
			listaHoras.put(i + 6, LocalTime.of(i + 17, 0));
		}
		
		
		for (int i = 0; i < listaHoras.size(); i++) {
			System.out.println(listaHoras.get(i));
		}
		
		
		for (int i = 0; i < horas.size(); i++) {
			
			if (horas.get(i) == true) {
				horasSesion.put(j, LocalDateTime.of(dia, listaHoras.get(i)));
				j++;
			}
		}
		
		
		for (int i = 0; i < horasSesion.size(); i++) {
			LocalDateTime fechaReserva = horasSesion.get(i);
			Reserva r = new Reserva(0, nombreCurso, idAula, fechaReserva);
			
			mapaReservas.put(i, r);
		}
		
		return mapaReservas;
	}
	
	
	private void hacerReservas(
			Map<Integer, Reserva> reservas) {
		
		for (int i = 0; i < reservas.size(); i++) {
			reservaService.create(reservas.get(i));
		}
	}
	
	
}
