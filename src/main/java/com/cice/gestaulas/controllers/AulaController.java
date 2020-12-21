package com.cice.gestaulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.services.interfaces.IAulaService;

@Controller
public class AulaController {

	@Autowired
	IAulaService aulaService;
	
	@GetMapping("/admin/crearAulaControl")
	public String crearOrdenador(
			@RequestParam (name = "idSede", required = true) int idSede,
			@RequestParam (name = "capacidad", required = true) int capacidad,
			@RequestParam (name = "equipoProfesor", required = true) int equipoProfesor,
			@RequestParam (name = "equipoAlumno", required = true) int equipoAlumno,
			@RequestParam (name = "equipamiento", required = true) int equipamiento) {
		
		Aula a = new Aula(0, idSede, capacidad, equipoProfesor, equipoAlumno, equipamiento);
		
		aulaService.create(a);
		
		return "redirect:crearAula";
	
	}
	
	@GetMapping("/admin/mostrarAula")
	public ModelAndView findAllSedes() {
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
	
	
	
		
}
