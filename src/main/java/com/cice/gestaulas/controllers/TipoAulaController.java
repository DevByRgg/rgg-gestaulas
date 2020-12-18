package com.cice.gestaulas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cice.gestaulas.entities.TipoAula;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;

@Controller
public class TipoAulaController {
	
	@Autowired
	ITipoAulaService tipoAulaService;
	
	@GetMapping("/admin/crearTipoAulaControl")
	public String crearOrdenador(
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "idOrdenador", required = true) int idOrdenador,
			@RequestParam (name = "idEquipamiento", required = true) int idEquipamiento) {
		
		TipoAula t = new TipoAula (0, nombre, idOrdenador, idEquipamiento);
		
		tipoAulaService.create(t);
		
		return "redirect:crearTipoAula";
	
	}
	
	
	
}
