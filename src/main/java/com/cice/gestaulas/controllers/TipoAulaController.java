package com.cice.gestaulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.auxiliar.TipoAula;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;

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
			@RequestParam (name = "nombre", required = true) String nombre) {
		
		TipoAula t = new TipoAula(0, nombre);
		
		tipoAulaService.create(t);
		
		return "redirect:mostrarTipoAula";
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//	READ
	//-------------------------------------------------------------------------------------------------------
	
	
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
	
	@GetMapping("/admin/updateTipoAula")
	public ModelAndView actualizaTipoAula(
			@RequestParam (name = "id") int id) {
		
		ModelAndView mav = new ModelAndView();
		
		TipoAula t = tipoAulaService.findById(id);
		
		mav.addObject("tipoAula", t);
		mav.setViewName("/admin/updateTipoAula");
		return mav;
	}
	
	@GetMapping("/admin/updateTipoAulaControl")
	public String updateTipoAula(
			@RequestParam (name = "id", required = true) int id,
			@RequestParam (name = "nombre", required = true) String nombre ) {
		
		TipoAula t = new TipoAula(id, nombre);
		
		tipoAulaService.create(t);
		
		return "redirect:mostrarTipoAula";
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//	DELETE
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("admin/borrarTipoAula")
	public String borrarTipoAula(
			@RequestParam(required = true) int id){
		tipoAulaService.delete(id);
		
		return "redirect:mostrarTipoAula";
	}
	
}
