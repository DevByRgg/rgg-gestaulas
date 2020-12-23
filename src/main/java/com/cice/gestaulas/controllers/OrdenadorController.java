package com.cice.gestaulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Ordenador;
import com.cice.gestaulas.services.interfaces.IOrdenadorService;

@Controller
public class OrdenadorController {

	@Autowired
	IOrdenadorService ordenadorService;
	
	@GetMapping("/admin/crearOrdenadorControl")
	public String crearOrdenador(
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "sistemaOperativo", required = true) String sistemaOperativo,
			@RequestParam (name = "dimensionPantalla", required = true) int dimensionPantalla,
			@RequestParam (name = "cpu", required = true) String cpu,
			@RequestParam (name = "ram", required = true) int ram,
			@RequestParam (name = "tarjetaGrafica", required = true) String tarjetaGrafica) {
		
		Ordenador o = new Ordenador(0, nombre, sistemaOperativo, dimensionPantalla, cpu, ram, tarjetaGrafica);
		
		ordenadorService.create(o);
		
		return "redirect:crearOrdenador";
	
	}
	
	@GetMapping("/admin/mostrarOrdenador")
	public ModelAndView findAllOrdenadores() {
		List<Ordenador> listaOrdenadores = ordenadorService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("ordenadores", listaOrdenadores);
		mav.setViewName("/admin/mostrarOrdenador");
		return mav;
	}
	
	@GetMapping("admin/borrarOrdenador")
	public String borrarOrdenador(
			@RequestParam(required = true) int id){
		ordenadorService.delete(id);
		
		return "redirect:mostrarOrdenador";
	}
	
	
}