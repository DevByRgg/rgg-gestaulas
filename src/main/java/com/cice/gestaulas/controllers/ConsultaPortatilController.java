package com.cice.gestaulas.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Reserva;
import com.cice.gestaulas.entities.auxiliar.ObjetoPresentacion;
import com.cice.gestaulas.services.interfaces.IAulaService;
import com.cice.gestaulas.services.interfaces.IReservaService;

@Controller
public class ConsultaPortatilController {
	
	@Autowired
	IAulaService aulaService;
	
	@Autowired
	IReservaService reservaService;
	
	@GetMapping("consultas/consultarPortatil")
	public ModelAndView horarioDiario() {
		List<Aula> listaAulas = aulaService.findAll();
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("aulas", listaAulas);
		mav.setViewName("/consultas/consultasDiario");
		return mav;
	}
	
	@GetMapping("consultas/consultarPortatil")
	public ModelAndView verHorarioDiario(
			@RequestParam (name="aula") int aula,
			@RequestParam (name="fecha") String fecha) {
		LocalDate dia = LocalDate.parse(fecha);
		
		ObjetoPresentacion obj = new ObjetoPresentacion();
		
		List<LocalTime> horas = new ArrayList<LocalTime>();
		for (int i = 0; i < 6; i++) {horas.add(LocalTime.of(i + 9, 0));}
		for (int i = 0; i < 6; i++) {horas.add(LocalTime.of(i + 17, 0));}
		
		List<Reserva> listaReservas = reservaService.findAllByAula(aula);
		List<LocalDateTime> listaFechasHoras = new ArrayList<LocalDateTime>();
		
		for (int i = 0; i < listaReservas.size(); i++) {
			listaFechasHoras.add(listaReservas.get(i).getFechaReserva());	
		}
		
		List<Boolean> listaBoleana = new ArrayList<Boolean>();
		for (int i = 0; i < horas.size(); i++) {
			LocalDateTime fechaHora = LocalDateTime.of(dia, horas.get(i));
			if (listaFechasHoras.contains(fechaHora)) {
				listaBoleana.add(true);
			} else {
				listaBoleana.add(false);
			}
		}
		
		//ahora crea el objeto presentacion con las distintas horas y boleanos
		//si da tiempo incluir el nombre del curso
				
		return null;
		
		
		
	}
}
