package com.cice.gestaulas.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.services.interfaces.IUsuarioService;

@Secured("ROLE_ADMIN")
@Controller
public class AdminHomeController {
	
	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping("/admin")
	public ModelAndView mostrarAdminPage() {
	
		/*
		 * String nombreUsuario = "";
		 * 
		 * Authentication auth = SecurityContextHolder
		 * .getContext().getAuthentication(); UserDetails userDetail = (UserDetails)
		 * auth.getPrincipal(); nombreUsuario = userDetail.getUsername();
		 */
		ModelAndView mav = new ModelAndView();
		
		//mav.addObject("username", nombreUsuario);
		mav.setViewName("admin/admin");
		
		return mav;
	}
			
}
