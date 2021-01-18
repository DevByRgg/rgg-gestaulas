package com.cice.gestaulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cice.gestaulas.entities.auxiliar.TipoAula;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;
import com.cice.gestaulas.utils.Utilidades;

@Secured("ROLE_ADMIN")
@Controller
public class TipoAulaController {
	
	/**
	 * SErvicios de TipoAula
	 */
	@Autowired
	ITipoAulaService tipoAulaService;
	
	
	//-------------------------------------------------------------------------------------------------------
	//	CREATE
	//-------------------------------------------------------------------------------------------------------

	/**
	 * Cargar y mostrar la página crearTipoAula
	 * @return ModelAndView
	 */
	@GetMapping("/admin/crearTipoAula")
	public ModelAndView crearTipoAulaPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/crearTipoAula");
		return mav;
	}
	
	/**
	 * Crear un TipoAula en la BBDD
	 * @param nombre del TipoAula
	 * @return "redirect:mostrarTipoAula". Mostrar los TipoAulas
	 */
	@GetMapping("/admin/crearTipoAulaControl")
	public String crearTipoAulaControl(
			@RequestParam (name = "nombre", required = true) String nombre,
			RedirectAttributes attributes) {
		TipoAula t = new TipoAula(0, nombre);
		
		tipoAulaService.create(t);
		String mensaje = "TipoAula creada con exito!";
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarTipoAula";
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//	READ
	//-------------------------------------------------------------------------------------------------------
	
	/**
	 * Mostrar todos los tipoAula de la BBDD
	 * @return ModelAndView "/admin/mostrarTipoAula"
	 */
	@GetMapping("/admin/mostrarTipoAula")
	public ModelAndView findAllTipoAula() {
		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("tipoAulas", listaTipoAulas);
		mav.setViewName("/admin/mostrarTipoAula");
		return mav;
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//	UPDATE
	//-------------------------------------------------------------------------------------------------------
	
	/**
	 * Mostrar TipoAula a actualizar
	 * @param id identificador del TipoAula
	 * @return ModelAndView /admin/updateTipoAula
	 */
	@GetMapping("/admin/updateTipoAula")
	public ModelAndView actualizaTipoAula(
			@RequestParam (name = "id") int id) {
		
		ModelAndView mav = new ModelAndView();
		
		TipoAula t = tipoAulaService.findById(id);
		
		mav.addObject("tipoAula", t);
		mav.setViewName("/admin/updateTipoAula");
		return mav;
	}
	
	/**
	 * Actualizar TipoAula en la BBDD
	 * @param id identificador del TipoAula
	 * @param nombre del TipoAula
	 * @return "redirect:mostrarTipoAula". Mostrar todos los TipoAula
	 */
	@GetMapping("/admin/updateTipoAulaControl")
	public String updateTipoAula(
			@RequestParam (name = "id", required = true) int id,
			@RequestParam (name = "nombre", required = true) String nombre,
			RedirectAttributes attributes) {
		
		TipoAula t = new TipoAula(id, nombre);
		
		tipoAulaService.create(t);
		String mensaje = "TipoAula actualizada con exito!";
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarTipoAula";
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//	DELETE
	//-------------------------------------------------------------------------------------------------------
	
	/**
	 * Borrar un TipoAula de la BBDD
	 * @param id identificador del TipoAula
	 * @return "redirect:mostrarTipoAula". Mostrar todos los TipoAula
	 */
	@GetMapping("admin/borrarTipoAula")
	public String borrarTipoAula(
			@RequestParam(required = true) int id,
			RedirectAttributes attributes) {
		tipoAulaService.delete(id);
		
		String mensaje = "TipoAula borrada con exito!";
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarTipoAula";
	}
	
}
