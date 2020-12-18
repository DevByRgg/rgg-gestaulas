package com.cice.gestaulas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.services.interfaces.IAulaService;

@Controller
public class AulaController {

	@Autowired
	IAulaService aulaService;
	
	@GetMapping("/admin/crearAulaControl")
	public String crearOrdenador(
			@RequestParam (name = "idTipoAula", required = true) int idTipoAula,
			@RequestParam (name = "numeroPuestos", required = true) int numeroPuestos) {
		
		Aula a = new Aula (0, idTipoAula, numeroPuestos);
		
		aulaService.create(a);
		
		return "redirect:crearAula";
	
	}
		
}
