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
public class UsuarioController {
	
	private static final String USER = "ROLE_USER";
	private static final String ADMIN = "ROLE_ADMIN";
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IUsuarioService usuarioService;
	

	// -------------------------------------------------------------------------------------------------------
	// CREATE
	// -------------------------------------------------------------------------------------------------------

	@RequestMapping(value = "/admin/crearUsuario", method = RequestMethod.GET)
	public String mostrarForm() {
		return "admin/crearUsuario";
	}
	
	@RequestMapping(value = "/admin/crearUsuarioControl", method = RequestMethod.POST)
	public String createUsuario(
			@RequestParam(required = true) String username,
			@RequestParam(required = true) String password,
			@RequestParam(required = true) int role,			
			RedirectAttributes attributes) {
		
		List<Role> roles = new ArrayList<Role>();	
		String bcryptPassword = passwordEncoder.encode(password);
		
		Usuario u = new Usuario(username, bcryptPassword, true);
		
		if(role == 1) {
			roles.add(new Role(USER, u.getId()));
		} else if(role == 2) {
			roles.add(new Role(USER, u.getId()));
			roles.add(new Role(ADMIN, u.getId()));
		}
		
		u.setRoles(roles);
		
		try {
			usuarioService.addUsuario(u);
			attributes.addFlashAttribute("alert", "success");
			attributes.addFlashAttribute("msg", "Usuario dado de alta!");
		} catch (DataIntegrityViolationException e) {
			attributes.addFlashAttribute("alert", "warning");
			attributes.addFlashAttribute("msg", "Este usuario ya existe!");			
			e.printStackTrace();
		}
		return "redirect:/admin/mostrarUsuario";				
	}

	// -------------------------------------------------------------------------------------------------------
	// READ
	// -------------------------------------------------------------------------------------------------------

	@GetMapping("/admin/mostrarUsuario")
	public ModelAndView consultaUsuarios( ) {	
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = usuarioService.findAll();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/mostrarUsuarios");
		mav.addObject("usuarios", usuarios);
		return mav;		
	}

	// -------------------------------------------------------------------------------------------------------
	// UPDATE
	// -------------------------------------------------------------------------------------------------------
	
	@GetMapping("/admin/updateUsuario")
	public ModelAndView actualizaUsuario(
			@RequestParam(required = true) long id,		
			RedirectAttributes attributes) {
		Usuario u = usuarioService.findById(id);
		List<Role> roles = usuarioService.findById(id).getRoles();
		int role = 1;
		
		for (int i = 0; i < roles.size(); i++) {
			String auth = roles.get(i).getAuthority();
			if (auth.equals(ADMIN)) {
				role = 2;
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", u);
		mav.addObject("role", role);
		mav.setViewName("admin/updateUsuario");
		return mav;
	}
	
	@GetMapping("/admin/updateUsuarioControl")
	public String updateUsuario(
			@RequestParam(required = true) Long id,
			@RequestParam(required = true) String username,
			@RequestParam(required = true) String password,
			RedirectAttributes attributes) {
		String bcryptPassword = passwordEncoder.encode(password);
		Usuario u = usuarioService.findById(id);
		u.setUsername(username);
		u.setPassword(bcryptPassword);
		
		try {
			usuarioService.addUsuario(u);
			attributes.addFlashAttribute("alert", "success");
			attributes.addFlashAttribute("msg", "Usuario actualizado con exito!");
		} catch (DataIntegrityViolationException e) {
			attributes.addFlashAttribute("alert", "warning");
			attributes.addFlashAttribute("msg", "Error, Contacte con el desarrollador!");			
			e.printStackTrace();
		}
		return "redirect:/admin/mostrarUsuario";	
	}
	
	@GetMapping("/admin/unlockUsuario")
	public String desbloquearUsuario(
			@RequestParam(required = true) long id,		
			RedirectAttributes attributes) {
		Usuario u = usuarioService.findById(id);
		boolean locker = u.getEnabled();
		
		if(locker) {
			u.setEnabled(false);
		} else {
			u.setEnabled(true);
		}
		
		try {
			usuarioService.updateUsuario(u);
			if (!locker) {
				attributes.addFlashAttribute("alert", "success");
				attributes.addFlashAttribute("msg", "¡¡ Usuario " + u.getUsername() + " desbloqueado !!");	
			} else {
				attributes.addFlashAttribute("alert", "warning");
				attributes.addFlashAttribute("msg", "¡¡ Usuario " + u.getUsername() + " bloqueado !!");
			}
			
		} catch (DataIntegrityViolationException e) {
			attributes.addFlashAttribute("alert", "warning");
			attributes.addFlashAttribute("msg", "Error, Contacte con el desarrollador!");			
			e.printStackTrace();
		}
		return "redirect:/admin/mostrarUsuario";	
	}
	// -------------------------------------------------------------------------------------------------------
	// DELETE
	// -------------------------------------------------------------------------------------------------------

	@GetMapping("/admin/borrarUsuario")
	public String borrarUsuario(@RequestParam( required = true) long id,
									RedirectAttributes attributes) {		
		
		usuarioService.deleteUsuario(id);
		attributes.addFlashAttribute("msg", "usuario borrado!");
		
		return "redirect:/admin/mostrarUsuario";
		
	}

}
