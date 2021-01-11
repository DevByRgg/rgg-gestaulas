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
		
	//-------------------------------------------------------------------------------------------------------
	//	CREATE
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("/admin/crearSede")
	public ModelAndView crearSedePage() {
		
		ModelAndView mav = new ModelAndView();
	
		mav.setViewName("admin/crearSede");
		return mav;
	}
	
	@GetMapping("/admin/crearSedeControl")
	public String crearSede (
			@RequestParam (name = "nombre") String nombre,
			@RequestParam (name = "direccion", required = true) String direccion,
			@RequestParam (name = "codigoPostal", required = true) String codigoPostal,
			@RequestParam (name = "telefono", required = true) String telefono) {
		
		Sede s = new Sede(0, nombre, direccion, codigoPostal, telefono);
		
		sedeService.create(s);
		
		return "redirect:mostrarSede";
	}
		
	//-------------------------------------------------------------------------------------------------------
	//	READ
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("/admin/mostrarSede")
	public ModelAndView findAllSede() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Sede> listaSedes = sedeService.findAll();
		
		mav.addObject("sedes", listaSedes);
		mav.setViewName("/admin/mostrarSede");
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//	UPDATE
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("/admin/updateSede")
	public ModelAndView actualizarSede(
			@RequestParam (name = "id") int id) {
		
		ModelAndView mav = new ModelAndView();
		
		Sede s = sedeService.findById(id);
		
		mav.addObject("sede", s);
		mav.setViewName("/admin/updateSede");
		
		return mav;
	}
	
	@GetMapping("/admin/updateSedeControl")
	public String updateSede (
			@RequestParam (name = "id") int id,
			@RequestParam (name = "nombre") String nombre,
			@RequestParam (name = "direccion", required = true) String direccion,
			@RequestParam (name = "codigoPostal", required = true) String codigoPostal,
			@RequestParam (name = "telefono", required = true) String telefono) {
		
		Sede s = new Sede(id, nombre, direccion, codigoPostal, telefono);
		
		sedeService.update(s);
		
		return "redirect:mostrarSede";
	}
	
	//-------------------------------------------------------------------------------------------------------
	//	DELETE
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("admin/borrarSede")
	public String borrarSede(
			@RequestParam(required = true) int id){
		
		sedeService.delete(id);
		
		return "redirect:mostrarSede";
	}
}
