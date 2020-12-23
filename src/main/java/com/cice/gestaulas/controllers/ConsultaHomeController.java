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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.services.interfaces.IAulaService;
import com.cice.gestaulas.services.interfaces.ISedeService;

@Controller
public class ConsultaHomeController {
	
	@Autowired
	ISedeService sedeService;
	
	@Autowired
	IAulaService aulaService;
	
	@GetMapping("consultas/buscarAula")
	public ModelAndView buscarAulaPage() {
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
		
		mav.setViewName("consultas/buscarAula");
		return mav;
		
	}
	
	//Metodo que crea el ModelAndview para todos los metodos
	//-------------------------------------------------------------------------------------------------------
	private ModelAndView consultaAulas (List<Aula> resAulas, int idSede , int mes, int anio, int turno) {
		ModelAndView mav = new ModelAndView();
		
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
		
		mav.addObject("sedes", listaSedes);
		mav.addObject("aulas", listaAulas);
		mav.addObject("anios", listaAnios);
		mav.addObject("meses", listaMeses);
		
		//------------------------------------------------------------------------------------------------------
		
		mav.addObject("resAulas", resAulas);
		mav.addObject("resAulas", resAulas);
		mav.addObject("resAulas", resAulas);
		mav.addObject("resAulas", resAulas);
		mav.addObject("resAulas", resAulas);
		mav.setViewName("consultas/buscarAula");
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("consultas/elegirAula")
	public ModelAndView elegirAulaPage(
		@RequestParam (name="idSede", required = true) int idSede,
		@RequestParam (name="idAula", required = true) int idAula,
		@RequestParam (name="mes", required = true) int mes,
		@RequestParam (name="anio", required = true) int anio,
		@RequestParam (name="turno", required = true) int turno) {
	
		List<Aula> listaAulas = aulaService.findAll();
		
		ModelAndView mav = consultaAulas(listaAulas, idSede, mes, anio, turno);
		return mav;
	}
	
	
}
