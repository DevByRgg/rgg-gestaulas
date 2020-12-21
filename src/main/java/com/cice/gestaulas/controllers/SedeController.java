package com.cice.gestaulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.services.interfaces.ISedeService;

@Controller
public class SedeController {

	@Autowired
	ISedeService sedeService;
	
	@GetMapping("/admin/crearSedeControl")
	public String crearSede (
			@RequestParam (name = "nombre") String nombre,
			@RequestParam (name = "direccion", required = true) String direccion,
			@RequestParam (name = "codigoPostal", required = true) String codigoPostal,
			@RequestParam (name = "telefono", required = true) String telefono) {
		
		Sede s = new Sede(0, nombre, direccion, codigoPostal, telefono);
		
		sedeService.create(s);
		
		return "redirect:crearSede";
	}
	
	@GetMapping("/admin/mostrarSede")
	public ModelAndView findAllSedes() {
		List<Sede> listaSedes = sedeService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("sedes", listaSedes);
		mav.setViewName("/admin/mostrarSede");
		return mav;
	}
	
	@GetMapping("admin/borrarSede")
	public String borrarSede(
			@RequestParam(required = true) int id){
		sedeService.delete(id);
		
		return "redirect:mostrarSede";
	}
	
}
