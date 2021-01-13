package com.cice.gestaulas.controllers;

import java.util.List;

import javax.validation.ValidatorFactory;

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
	
	/**
	 * Para crear objeto Validator para comprobar las Constrains de la Entidad
	 */
	@Autowired
	ValidatorFactory factoryValidator;
		
	//-------------------------------------------------------------------------------------------------------
	//	CREATE
	//-------------------------------------------------------------------------------------------------------
	
	/**
	 * Cargar y mostrar la página crearSede
	 * @return ModelAndView 
	 */
	@GetMapping("/admin/crearSede")
	public ModelAndView crearSedePage() {
		
		ModelAndView mav = new ModelAndView();
	
		mav.setViewName("admin/crearSede");
		return mav;
	}
	
	/**
	 * Crear una Sede en la BBDD
	 * @param nombre de la Sede
	 * @param direccion de la Sede
	 * @param codigoPostal de la Sede
	 * @param telefono de la Sede
	 * @return "redirect:mostrarSede". Mostrar la lista con todas las sedes
	 */
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
	
	/**
	 * Mostrar todas las sedes de la BBDD
	 * @return ModelAndView /admin/mostrarSede
	 */
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
	
	/**
	 * Mostrar Sede a actualizar
	 * @param id identificador de la sede
	 * @return ModelAndView /admin/updateSede
	 */
	@GetMapping("/admin/updateSede")
	public ModelAndView actualizarSede(
			@RequestParam (name = "id") int id) {
		
		ModelAndView mav = new ModelAndView();
		
		Sede s = sedeService.findById(id);
		
		mav.addObject("sede", s);
		mav.setViewName("/admin/updateSede");
		
		return mav;
	}
	
	/**
	 * Actualizar Sede en la BBDD
	 * @param id identificador de la Sede
	 * @param nombre de la sede
	 * @param direccion de la sede
	 * @param codigoPostal de la sede
	 * @param telefono de la sede
	 * @return "redirect:mostrarSede". Mostrar la lista con todas la sedes
	 */
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
	
	/**
	 * Borrar una Sede de la BBDD
	 * @param id identificador de la sede
	 * @return "redirect:mostrarSede". Mostrar la lista con todas las sedes
	 */
	@GetMapping("admin/borrarSede")
	public String borrarSede(
			@RequestParam(required = true) int id){
		
		sedeService.delete(id);
		
		return "redirect:mostrarSede";
	}
}
