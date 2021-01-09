package com.cice.gestaulas.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.auxiliar.Festivo;
import com.cice.gestaulas.services.interfaces.IFestivoService;


@Controller
public class FestivoController {
	
	@Autowired
	IFestivoService festivoService;
	
	//-------------------------------------------------------------------------------------------------------
	//	CREATE
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("/mantenimiento/crearFestivo")
	public ModelAndView crearFestivoPage() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("mantenimiento/crearFestivo");
		return mav;
	}
	
	@GetMapping("/mantenimiento/crearFestivoControl")
	public String crearFestivo(
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "fecha", required = true) String fecha) {
	
		ModelAndView mav = new ModelAndView();
		
		LocalDate fechaFestivo = LocalDate.parse(fecha);
		
		Festivo f = new Festivo(0, nombre, fechaFestivo);
		festivoService.create(f);
		
		return "redirect:crearFestivo";
	}
	
	//-------------------------------------------------------------------------------------------------------
	//	READ
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("/mantenimiento/mostrarFestivo")
	public ModelAndView findAllFestivo() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Festivo> listaFestivos = festivoService.findAll();
		
		mav.addObject("festivos", listaFestivos);
		mav.setViewName("/mantenimiento/mostrarFestivo");
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//	UPDATE
	//-------------------------------------------------------------------------------------------------------

	@GetMapping("/mantenimiento/updateFestivo")
	public ModelAndView actualizarFestivo(
			@RequestParam (name = "id") int id) {
		
		ModelAndView mav = new ModelAndView();
		
		Festivo f = festivoService.findById(id);
		
		mav.addObject("festivo", f);
		mav.setViewName("/mantenimiento/updateFestivo");
		
		return mav;
	}
	
	
	@GetMapping("/mantenimiento/updateFestivoControl")
	public String updateFestivo(
			@RequestParam (name = "id") int id,
			@RequestParam (name = "nombre") String nombre,
			@RequestParam (name = "fecha") String fecha) {
		
		ModelAndView mav = new ModelAndView();
		
		LocalDate fechaFestivo = LocalDate.parse(fecha);
		
		Festivo f = new Festivo(id, nombre, fechaFestivo);
		
		festivoService.update(f);
		
		return "redirect:mostrarFestivo";
	}

	//-------------------------------------------------------------------------------------------------------
	//	DELETE
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("mantenimiento/borrarFestivo")
	public String borrarFestivo(
			@RequestParam(name = "id", required = true) int id){
		
		festivoService.delete(id);
		
		return "redirect:mostrarFestivo";
	}

	
}
