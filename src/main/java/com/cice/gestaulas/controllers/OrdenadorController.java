package com.cice.gestaulas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cice.gestaulas.entities.Ordenador;
import com.cice.gestaulas.services.interfaces.IOrdenadorService;

@Controller
public class OrdenadorController {

	@Autowired
	IOrdenadorService ordenadorService;
	
	@GetMapping("/admin/crearOrdenadorControl")
	public String crearOrdenador(
			@RequestParam (name = "tipo", required = true) String tipo,
			@RequestParam (name = "sistemaOperativo", required = true) String sistemaOperativo,
			@RequestParam (name = "dimensionPantalla", required = true) int dimensionPantalla,
			@RequestParam (name = "cpu", required = true) String cpu,
			@RequestParam (name = "ram", required = true) int ram,
			@RequestParam (name = "tarjetaGrafica", required = true) String tarjetaGrafica) {
		
		Ordenador o = new Ordenador(0, tipo, sistemaOperativo, dimensionPantalla, cpu, ram, tarjetaGrafica);
		
		ordenadorService.create(o);
		
		return "redirect:crearOrdenador";
	
	}
}
