package com.cice.gestaulas.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import com.cice.gestaulas.services.interfaces.IFestivoService;
import com.cice.gestaulas.services.interfaces.IReservaService;

@Controller
public class ConsultaPortatilController {
	
	@Autowired
	IAulaService aulaService;
	
	@Autowired
	IReservaService reservaService;
	
	@Autowired
	IFestivoService festivoService;
	
	
	@GetMapping("consultas/consultarPortatil")
	public ModelAndView horarioDiario() {
		List<Aula> listaAulas = aulaService.findAll();
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("aulas", listaAulas);
		mav.setViewName("/consultas/consultasDiario");
		return mav;
	}
	
	@GetMapping("consultas/horarioPortatil")
	public ModelAndView verHorarioDiario(
			@RequestParam (name="aula") int aula,
			@RequestParam (name="fecha") String fecha) {
		List<Aula> listaAulas = aulaService.findAll();
		LocalDate dia = LocalDate.parse(fecha);
		int diaSemana = dia.getDayOfWeek().getValue();
		List<ObjetoPresentacion> obj = new ArrayList<ObjetoPresentacion>();
		
		
		List<LocalTime> horas = new ArrayList<LocalTime>();
		for (int i = 0; i < 6; i++) {horas.add(LocalTime.of(i + 9, 0));}
		for (int i = 0; i < 6; i++) {horas.add(LocalTime.of(i + 17, 0));}
		
		List<Reserva> listaReservas = reservaService.findAllByAula(aula);
		List<LocalDateTime> listaFechasHoras = new ArrayList<LocalDateTime>();
		
		for (int i = 0; i < listaReservas.size(); i++) {
			listaFechasHoras.add(listaReservas.get(i).getFechaReserva());	
		}
		
		for (int i = 0; i < horas.size(); i++) {
			LocalDateTime fechaHora = LocalDateTime.of(dia, horas.get(i));
			boolean festivo = festivoService.findAllFechas().contains(dia);
			int horasColores = 0;
			String nombreCurso = null;
			
			if(diaSemana != 7 && !festivo) {
				if (listaFechasHoras.contains(fechaHora)) {
					horasColores = 1;
					nombreCurso = reservaService.findByIdAulaAndFechaReserva(aula, fechaHora).getNombreCurso();
				} else {
					horasColores = 2;
					nombreCurso = "libre";
				}	
			} else {
				horasColores = 0;
				if(diaSemana == 7) {
					nombreCurso = "Domingo";
				} else {
					nombreCurso = festivoService.findNombreByFecha(dia);
				}
			}
			
			obj.add(new ObjetoPresentacion(horas.get(i), horasColores, nombreCurso));
		}
		
		String diaReserva = dia.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		//ahora crea el objeto presentacion con las distintas horas y boleanos
		//si da tiempo incluir el nombre del curso
		ModelAndView mav = new ModelAndView();
		mav.addObject("fechaSel", fecha);
		mav.addObject("aulaSel", aula);
		mav.addObject("aulas", listaAulas);
		mav.addObject("diaReserva", diaReserva);
		mav.addObject("objetos", obj);
		mav.setViewName("/consultas/consultasDiario");
		return mav;
		
			
		
	}
}
