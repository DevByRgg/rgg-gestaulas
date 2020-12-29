package com.cice.gestaulas.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Equipamiento;
import com.cice.gestaulas.entities.Ordenador;
import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.entities.TipoAula;
import com.cice.gestaulas.services.interfaces.IEquipamientoService;
import com.cice.gestaulas.services.interfaces.IOrdenadorService;
import com.cice.gestaulas.services.interfaces.ISedeService;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;

@Controller
public class AdminHomeController {

	@Autowired
	ITipoAulaService tipoAulaService;
	
	@Autowired
	ISedeService sedeService;
	
	@Autowired
	IOrdenadorService ordenadorService;
	
	@Autowired
	IEquipamientoService equipamientoService;
	
	
	@GetMapping("/admin")
	public ModelAndView mostrarAdminPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/admin");
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
