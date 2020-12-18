package com.cice.gestaulas.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Equipamiento;
import com.cice.gestaulas.entities.Ordenador;
import com.cice.gestaulas.entities.TipoAula;
import com.cice.gestaulas.services.impl.OrdenadorServiceImpl;
import com.cice.gestaulas.services.interfaces.IEquipamientoService;
import com.cice.gestaulas.services.interfaces.IOrdenadorService;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;

@Controller
public class AdminHomeController {

	@Autowired
	IOrdenadorService ordenadorService;
	
	@Autowired
	IEquipamientoService equipamientoService;
	
	@Autowired
	ITipoAulaService tipoAulaService;
	
	@GetMapping("/admin")
	public ModelAndView mostrarAdminPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/admin");
		return mav;
	}
	
	@GetMapping("/admin/crearSede")
	public ModelAndView crearSedePage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/crearSede");
		return mav;
	}

	@GetMapping("/admin/crearAula")
	public ModelAndView crearAulaPage() {
		ModelAndView mav = new ModelAndView();
		List<TipoAula> listaTipoAula = tipoAulaService.findAll();
		mav.addObject("tipoAulas", listaTipoAula);
		mav.setViewName("admin/crearAula");
		return mav;
	}

	@GetMapping("/admin/crearTipoAula")
	public ModelAndView crearTipoAulaPage() {
		ModelAndView mav = new ModelAndView();
		List<Ordenador> listaOrdenadores = ordenadorService.findAll();
		List<Equipamiento> listaEquipamientos = equipamientoService.findAll();
		mav.addObject("ordenadores", listaOrdenadores);
		mav.addObject("equipamientos", listaEquipamientos);
		mav.setViewName("admin/crearTipoAula");
		return mav;
	}
	
	@GetMapping("/admin/crearOrdenador")
	public ModelAndView crearOrdenadorPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/crearOrdenador");
		return mav;
	}
	
	@GetMapping("/admin/crearEquipamiento")
	public ModelAndView crearEquipamientoPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/crearEquipamiento");
		return mav;
	}
}
