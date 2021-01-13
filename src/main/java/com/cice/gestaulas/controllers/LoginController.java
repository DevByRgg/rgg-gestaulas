package com.cice.gestaulas.controllers;

import java.security.Principal;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {		
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required = false) String logout,
			Model model, Principal principal, RedirectAttributes flash, Locale locale) {
		
		if(principal != null) {
			flash.addFlashAttribute("info", "Ya has inciado sesión anteriormente");
			return "redirect:/";
		}
		
		if(error != null) {
			model.addAttribute("error", "Error: nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
		}else {
			model.addAttribute("error", null);
		}
		
		if(logout != null) {
			model.addAttribute("success", "Has cerrado sesión con éxito!");
			System.out.println("Has cerrado sesión con éxito!");
		}else {
			model.addAttribute("success", null);
		}
		
		model.addAttribute("user", " ");
		model.addAttribute("password", " ");
		return "login/login";
	}
}
