package com.cice.gestaulas.controllers;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.services.interfaces.IAulaService;
import com.cice.gestaulas.services.interfaces.ISedeService;



@Controller
public class ReservaHomeController {
	
	@Autowired
	ISedeService sedeService;
	
	@Autowired
	IAulaService aulaService;
	
	@GetMapping("reservas/busquedaReserva")
	public ModelAndView buscarReservaPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("reservas/busquedaReserva");
		return mav;
	}
	
	@GetMapping("reservas/crearReserva")
	public ModelAndView crearReservaPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("reservas/crearReserva");
		return mav;
	}
	
	@GetMapping("reservas/calendario")
	public ModelAndView calendarioPage() {
		List<Sede> listaSedes = sedeService.findAll();
		List<Aula> listaAulas = aulaService.findAll();
		Map<Integer, Integer> listaAnios = new HashMap<Integer, Integer>();
		for (int i = 0; i < 5; i++) {
			listaAnios.put(i, LocalDate.now().plusYears(i).getYear());
		}
		
		Map<Integer, String> listaMeses = new HashMap<Integer, String>();
		for (int i = 1; i < 13; i++) {
			listaMeses.put(i, Month.of(i).getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase());
		}
		
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("sedes", listaSedes);
		mav.addObject("aulas", listaAulas);

		
		mav.addObject("anios", listaAnios);
		mav.addObject("meses", listaMeses);
		mav.setViewName("reservas/calendario");
		return mav;
	}
}
