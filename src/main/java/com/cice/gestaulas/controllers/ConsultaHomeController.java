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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.entities.TipoAula;
import com.cice.gestaulas.services.interfaces.IAulaService;
import com.cice.gestaulas.services.interfaces.ISedeService;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;

@Controller
public class ConsultaHomeController {
	
	@Autowired
	ISedeService sedeService;
	
	@Autowired
	IAulaService aulaService;
	
	@Autowired
	ITipoAulaService tipoAulaService;
	
	@GetMapping("consultas/buscarAula")
	public ModelAndView buscarAulaPage() {
		List<Sede> listaSedes = sedeService.findAll();
		List<Aula> listaAulas = aulaService.findAll();
		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();
		
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
		mav.addObject("tipoAulas", listaTipoAulas);
		mav.addObject("anios", listaAnios);
		mav.addObject("meses", listaMeses);
		
		mav.setViewName("consultas/buscarAula");
		return mav;
		
	}
	
	//Metodo que crea el ModelAndview para todos los metodos
	//-------------------------------------------------------------------------------------------------------
	private ModelAndView consultaAulas (List<Aula> resAulas) {
		ModelAndView mav = new ModelAndView();
		
		List<Sede> listaSedes = sedeService.findAll();
		List<Aula> listaAulas = aulaService.findAll();
		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();
		
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
		mav.addObject("tipoAulas", listaTipoAulas);
		mav.addObject("anios", listaAnios);
		mav.addObject("meses", listaMeses);
		
		//------------------------------------------------------------------------------------------------------
		
		mav.addObject("resAulas", resAulas);
		
		mav.setViewName("consultas/buscarAula");
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("consultas/elegirAula")
	public ModelAndView elegirAulaPage(
		@RequestParam (name="sede") int sede,
		@RequestParam (name="tipo") int tipo) {
		
		if (sede == -1) {
			List<Aula> listaAulas = aulaService.findByTipo(tipo);
			ModelAndView mav = consultaAulas(listaAulas);
			return mav;
			
		} else if (tipo == -1) {
			List<Aula> listaAulas = aulaService.findBySede(sede);
			ModelAndView mav = consultaAulas(listaAulas);
			return mav;
			
		} else {
			List<Aula> listaAulas = aulaService.findBySedeAndTipo(sede, tipo);
			ModelAndView mav = consultaAulas(listaAulas);
			return mav;
		}
		
	}
	
	
	@GetMapping("consultas/verHorarioAula")
	public ModelAndView verHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio) {
		
		int numDias = LocalDate.of(anio, mes, 1).lengthOfMonth();
		
		List<LocalDate> listaDias;
		
		
		
		
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
}
