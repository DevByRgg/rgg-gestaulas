package com.cice.gestaulas.controllers;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	
	
}
