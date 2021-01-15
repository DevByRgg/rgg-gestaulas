package com.cice.gestaulas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cice.gestaulas.entities.Role;
import com.cice.gestaulas.entities.Usuario;
import com.cice.gestaulas.services.interfaces.IUsuarioService;

@Controller
@Secured("ROLE_ADMIN")
public class GestionUsuariosController {
	
	private static final String USER = "ROLE_USER";
	private static final String ADMIN = "ROLE_ADMIN";
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IUsuarioService service;
	
	@RequestMapping(value = "/admin/altaUsuario", method = RequestMethod.GET)
	public String mostrarForm() {
		return "admin/crearUsuario";
	}
	
	@RequestMapping(value = "/admin/altaUsuario/confirm", method = RequestMethod.POST)
	public String createUsuario(
			@RequestParam(required = true) String username,
			@RequestParam(required = true) String password,
			@RequestParam(required = true) boolean roleUser,			
			RedirectAttributes attributes) {
		
		List<Role> roles = new ArrayList<Role>();	
		String bcryptPassword = passwordEncoder.encode(password);
		
		Usuario user = new Usuario(username, bcryptPassword, true);
		
		if(roleUser == true) {
			roles.add(new Role(USER, user.getId()));
		}else if(roleUser == false) {
			roles.add(new Role(USER, user.getId()));
			roles.add(new Role(ADMIN, user.getId()));
		}
		
		user.setRoles(roles);
		
		try {
			service.addUsuario(user);
			attributes.addFlashAttribute("alert", "success");
			attributes.addFlashAttribute("msg", "Usuario dado de alta!");
		} catch (DataIntegrityViolationException e) {
			attributes.addFlashAttribute("alert", "warning");
			attributes.addFlashAttribute("msg", "Este usuario ya existe!");			
			e.printStackTrace();
		}
		return "redirect:/admin/mostrarUsuarios";				
	}
	
	@GetMapping("/admin/mostrarUsuarios")
	public ModelAndView consultaUsuarios( ) {	
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = service.findAll();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/mostrarUsuarios");
		mav.addObject("usuarios", usuarios);
		return mav;		
		
	}
	
	@GetMapping("/admin/borrarUsuario")
	public String borrarUsuario(@RequestParam( required = true) long id,
									RedirectAttributes attributes) {		
		
		service.deleteUsuario(id);
		attributes.addFlashAttribute("msg", "usuario borrado!");
		
		return "redirect:/admin/mostrarUsuarios";
		
	}

}
