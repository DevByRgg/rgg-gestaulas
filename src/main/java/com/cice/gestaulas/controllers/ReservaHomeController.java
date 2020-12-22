package com.cice.gestaulas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservaHomeController {
	
	@GetMapping("reservas/crearReserva")
	public ModelAndView crearReservaPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("reservas/crearReserva");
		return mav;
	}
	
}
