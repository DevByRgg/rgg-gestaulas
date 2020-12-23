package com.cice.gestaulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.TipoAula;
import com.cice.gestaulas.services.interfaces.IAulaService;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;

@Controller
public class AulaController {

	@Autowired
	IAulaService aulaService;
	
	@Autowired
	ITipoAulaService tipoAulaService;
	
	@GetMapping("/admin/crearAulaControl")
	public String crearAula(
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "tipo", required = true) int tipo,
			@RequestParam (name = "idSede", required = true) int idSede,
			@RequestParam (name = "capacidad", required = true) int capacidad,
			@RequestParam (name = "equipoProfesor", required = true) int equipoProfesor,
			@RequestParam (name = "equipoAlumno", required = true) int equipoAlumno,
			@RequestParam (name = "equipamiento", required = true) int equipamiento) {
		
		Aula a = new Aula(0, nombre, tipo, idSede, capacidad, equipoProfesor, equipoAlumno, equipamiento);
		
		aulaService.create(a);
		
		return "redirect:crearAula";
	
	}
	
	@GetMapping("/admin/mostrarAula")
	public ModelAndView findAllAulas() {
		List<Aula> listaAulas = aulaService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("aulas", listaAulas);
		mav.setViewName("/admin/mostrarAula");
		return mav;
	}
	
	@GetMapping("admin/borrarAula")
	public String borrarAula(
			@RequestParam(required = true) int id){
		aulaService.delete(id);
		
		return "redirect:mostrarAula";
	}
	
	
	@GetMapping("/admin/crearTipoAulaControl")
	public String crearTipoAulaControl(
			@RequestParam (name = "nombre", required = true) String nombre) {
		
		TipoAula t = new TipoAula(0, nombre);
		
		tipoAulaService.create(t);
		
		return "redirect:crearTipoAula";
	
	}
	
	@GetMapping("/admin/mostrarTipoAula")
	public ModelAndView findAllTipoAulas() {
		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("tipoAulas", listaTipoAulas);
		mav.setViewName("/admin/mostrarTipoAula");
		return mav;
	}
	
	@GetMapping("admin/borrarTipoAula")
	public String borrarTipoAula(
			@RequestParam(required = true) int id){
		tipoAulaService.delete(id);
		
		return "redirect:mostrarTipoAula";
	}
}
