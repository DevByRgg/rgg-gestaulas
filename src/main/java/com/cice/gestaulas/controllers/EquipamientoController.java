package com.cice.gestaulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Equipamiento;
import com.cice.gestaulas.services.interfaces.IEquipamientoService;


@Controller
public class EquipamientoController {

	@Autowired
	IEquipamientoService equipamientoService;
	
	
	//-------------------------------------------------------------------------------------------------------
	//	CREATE
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("/admin/crearEquipamiento")
	public ModelAndView crearEquipamientoPage() {
		
		ModelAndView mav = new ModelAndView();
	
		mav.setViewName("admin/crearEquipamiento");
		
		return mav;
	}
	
	
	@GetMapping("/admin/crearEquipamientoControl")
	public String crearEquipamiento(
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "descripcion", required = true) String descripcion) {
		
		Equipamiento e = new Equipamiento(0, nombre, descripcion);
		
		equipamientoService.create(e);
		
		return "redirect:crearEquipamiento";
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//	READ
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("/admin/mostrarEquipamiento")
	public ModelAndView findAllEquipamiento() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Equipamiento> listaEquipamientos = equipamientoService.findAll();
		
		mav.addObject("equipamientos", listaEquipamientos);
		mav.setViewName("/admin/mostrarEquipamiento");
		
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//	UPDATE
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("/admin/updateEquipamiento")
	public ModelAndView actualizaEquipamiento(
			@RequestParam (name = "id") int id) {
		
		ModelAndView mav = new ModelAndView();
		
		Equipamiento e = equipamientoService.findById(id);
		
		mav.addObject("equipamiento", e);
		mav.setViewName("/admin/updateEquipamiento");
		
		return mav;
	}
	
	
	@GetMapping("/admin/updateEquipamientoControl")
	public String updateEquipamiento(
			@RequestParam (name = "id", required = true) int id,
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "descripcion", required = true) String descripcion) {
		
		Equipamiento e = new Equipamiento(id, nombre, descripcion);
		
		equipamientoService.update(e);
		
		return "redirect:mostrarEquipamiento";
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//	DELETE
	//-------------------------------------------------------------------------------------------------------
		
	@GetMapping("admin/borrarEquipamiento")
	public String borrarEquipamiento(
			@RequestParam(required = true) int id){
		
		equipamientoService.delete(id);
		
		return "redirect:mostrarEquipamiento";
	}
	
}
