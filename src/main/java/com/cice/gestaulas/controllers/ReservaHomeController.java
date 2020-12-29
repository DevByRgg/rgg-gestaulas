package com.cice.gestaulas.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Reserva;
import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.services.interfaces.IAulaService;
import com.cice.gestaulas.services.interfaces.IReservaService;
import com.cice.gestaulas.services.interfaces.ISedeService;



@Controller
public class ReservaHomeController {
	
	@Autowired
	ISedeService sedeService;
	
	@Autowired
	IAulaService aulaService;
	
	@Autowired
	IReservaService reservaService;
	
	@GetMapping("reservas/crearReserva")
	public ModelAndView crearReservaPage() {
		ModelAndView mav = new ModelAndView();
		
		List<Aula> listaAulas = aulaService.findAll();
		
		Map<Integer, LocalTime> listaHoras = new HashMap<Integer, LocalTime>();
		for (int i = 1; i < 7; i++) {
			listaHoras.put(i, LocalTime.of(i + 8, 0));
		}
		for (int i = 1; i < 7; i++) {
			listaHoras.put(i + 6, LocalTime.of(i + 16, 0));
		}
		
		mav.addObject("horas", listaHoras);
		mav.addObject("aulas", listaAulas);
		mav.setViewName("reservas/crearReserva");
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("reservas/crearReservaControl")
	public String crearReserva(
			@RequestParam (name = "nombreCurso") String nombreCurso,
			@RequestParam (name = "aulaReserva") int idAula,
			@RequestParam (name = "diaReserva") String diaReserva,
			@RequestParam (name = "horaReserva") String horaReserva) {
		
		LocalDate dia = LocalDate.parse(diaReserva);
		LocalTime hora = LocalTime.parse(horaReserva);
		LocalDateTime fechaReserva = LocalDateTime.of(dia, hora);
		
		Reserva r = new Reserva(0, nombreCurso, idAula, fechaReserva);
		reservaService.create(r);
		
		return "redirect:crearReserva";
	}
	
	@GetMapping("reservas/mostrarReserva")
	public ModelAndView findAllReservas() {
		ModelAndView mav = new ModelAndView();
		
		List<Reserva> listaReservas = reservaService.findAll();
		
		mav.addObject("reservas", listaReservas);
		mav.setViewName("/reservas/mostrarReserva");
		
		return mav;
	}
	
	
	
	
}
