package com.cice.gestaulas.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Secured("ROLE_ADMIN")
@Controller
public class AdminHomeController {
	
	@GetMapping("/admin")
	public ModelAndView mostrarAdminPage() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/admin");
		
		return mav;
	}	
}