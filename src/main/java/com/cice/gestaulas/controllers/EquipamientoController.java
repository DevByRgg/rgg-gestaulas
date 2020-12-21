package com.cice.gestaulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Equipamiento;
import com.cice.gestaulas.entities.Ordenador;
import com.cice.gestaulas.services.interfaces.IEquipamientoService;


@Controller
public class EquipamientoController {

	@Autowired
	IEquipamientoService equipamientoService;
	
	@GetMapping("/admin/crearEquipamientoControl")
	public String crearOrdenador(
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "descripcion", required = true) String descripcion) {
		
		Equipamiento e = new Equipamiento(0, nombre, descripcion);
		
		equipamientoService.create(e);
		
		return "redirect:crearEquipamiento";
	
	}
	
	@GetMapping("/admin/mostrarEquipamiento")
	public ModelAndView findAllEquipamientos() {
		List<Equipamiento> listaEquipamientos = equipamientoService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("equipamientos", listaEquipamientos);
		mav.setViewName("/admin/mostrarEquipamiento");
		return mav;
	}
	
	@GetMapping("admin/borrarEquipamiento")
	public String borrarEquipamiento(
			@RequestParam(required = true) int id){
		equipamientoService.delete(id);
		
		return "redirect:mostrarEquipamiento";
	}
	
}
