package com.cice.gestaulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Equipamiento;
import com.cice.gestaulas.services.interfaces.IEquipamientoService;
import com.cice.gestaulas.utils.Utilidades;

@Secured("ROLE_ADMIN")
@Controller
public class EquipamientoController {

	/**
	 * Servicios de Equipamiento
	 */
	@Autowired
	IEquipamientoService equipamientoService;
	
	
	//-------------------------------------------------------------------------------------------------------
	//	CREATE
	//-------------------------------------------------------------------------------------------------------
	
	/**
	 * Cargar y mostrar la página crearEquipamiento
	 * @return ModelAndView admin/crearEquipamiento
	 */
	@GetMapping("/admin/crearEquipamiento")
	public ModelAndView crearEquipamientoPage() {
		
		ModelAndView mav = new ModelAndView();
	
		mav.setViewName("admin/crearEquipamiento");
		
		return mav;
	}
	
	/**
	 * Crear un Equipamiento en la BBDD
	 * @param nombre del equipamiento
	 * @param descripcion del equipamiento
	 * @return "redirect:mostrarEquipamiento". Mostrar la lista con todos los equipamientos
	 */
	@GetMapping("/admin/crearEquipamientoControl")
	public String crearEquipamiento(
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "descripcion", required = true) String descripcion) {
		
		Equipamiento e = new Equipamiento(0, nombre, descripcion);
		
		Utilidades.validar(e);
		equipamientoService.create(e);
		
		return "redirect:mostrarEquipamiento";
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//	READ
	//-------------------------------------------------------------------------------------------------------
	/**
	 * Mostrar todas los equipamientos de la BBDD
	 * @return ModelAndView /admin/mostrarEquipamiento
	 */
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
	
	/**
	 * Mostrar Equipamiento a actualizar
	 * @param id identificador del equipamiento
	 * @return ModelAndView /admin/updateEquipamiento
	 */
	@GetMapping("/admin/updateEquipamiento")
	public ModelAndView actualizaEquipamiento(
			@RequestParam (name = "id") int id) {
		
		ModelAndView mav = new ModelAndView();
		
		Equipamiento e = equipamientoService.findById(id);
		
		mav.addObject("equipamiento", e);
		mav.setViewName("/admin/updateEquipamiento");
		
		return mav;
	}
	
	/**
	 * Actualizar Equipamiento en la BBDD
	 * @param id identificador del Equipamiento
	 * @param nombre del equipamiento
	 * @param descripcion del equipamiento
	 * @return "redirect:mostrarEquipamiento". Mostrar la lista con todos los equipamientos.
	 */
	@GetMapping("/admin/updateEquipamientoControl")
	public String updateEquipamiento(
			@RequestParam (name = "id", required = true) int id,
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "descripcion", required = true) String descripcion) {
		
		Equipamiento e = new Equipamiento(id, nombre, descripcion);
		
		Utilidades.validar(e);
		equipamientoService.update(e);
		
		return "redirect:mostrarEquipamiento";
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//	DELETE
	//-------------------------------------------------------------------------------------------------------
		
	/**
	 * Borrar un Equipamiento de la BBDD
	 * @param id identificador del Equipamiento
	 * @return "redirect:mostrarEquipamiento". Mostrar la lista con todos los equipamientos.
	 */
	@GetMapping("admin/borrarEquipamiento")
	public String borrarEquipamiento(
			@RequestParam(required = true) int id){
		
		equipamientoService.delete(id);
		
		return "redirect:mostrarEquipamiento";
	}
	
}
