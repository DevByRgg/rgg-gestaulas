package com.cice.gestaulas.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminHomeController {

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
		mav.setViewName("admin/crearAula");
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
