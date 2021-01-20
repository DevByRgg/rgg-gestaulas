package com.cice.gestaulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cice.gestaulas.entities.Ordenador;
import com.cice.gestaulas.services.interfaces.IOrdenadorService;
import com.cice.gestaulas.utils.Utilidades;

@Secured("ROLE_ADMIN")
@Controller
public class OrdenadorController {

	/**
	 * Servicios de Ordenador
	 */
	@Autowired
	IOrdenadorService ordenadorService;
	
	
	//-------------------------------------------------------------------------------------------------------
	//	CREATE
	//-------------------------------------------------------------------------------------------------------
	
	/**
	 * Cargar y mostrar la página crearOrdenador
	 * @return ModelAndView
	 */
	@GetMapping("/admin/crearOrdenador")
	public ModelAndView crearOrdenadorPage() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/crearOrdenador");
		return mav;
	}
	
	/**
	 * Crear un Ordenador en la BBDD
	 * @param nombre del ordenador
	 * @param sistemaOperativo del ordenador
	 * @param dimensionPantalla en pulgadas del monitor (entre 10 y 1000)
	 * @param cpu del ordenador
	 * @param ram del ordenador en GibaBytes (entre 1 y 1000)
	 * @param tarjetaGrafica del ordenador
	 * @param attributes redireccion de atributos
	 * @return "redirect:mostrarOrdenador". Mostrar la lista con todos los ordenadores
	 */
	@GetMapping("/admin/crearOrdenadorControl")
	public String crearOrdenador(
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "sistemaOperativo", required = true) String sistemaOperativo,
			@RequestParam (name = "dimensionPantalla", required = true) int dimensionPantalla,
			@RequestParam (name = "cpu", required = true) String cpu,
			@RequestParam (name = "ram", required = true) int ram,
			@RequestParam (name = "tarjetaGrafica", required = true) String tarjetaGrafica,
			RedirectAttributes attributes) {
		
		Ordenador o = new Ordenador(0, nombre, sistemaOperativo, dimensionPantalla, cpu, ram, tarjetaGrafica);
	
		ordenadorService.create(o);
		String mensaje = "Equipo creado con exito!";
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarOrdenador";	
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//	READ
	//-------------------------------------------------------------------------------------------------------

	/**
	 * Mostrar todos los ordenadores de la BBDD
	 * @return ModelAndView /admin/mostrarOrdenador
	 */
	@GetMapping("/admin/mostrarOrdenador")
	public ModelAndView findAllOrdenador() {
		List<Ordenador> listaOrdenadores = ordenadorService.findAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ordenadores", listaOrdenadores);
		mav.setViewName("/admin/mostrarOrdenador");
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//	UPDATE
	//-------------------------------------------------------------------------------------------------------
	
	/**
	 * Mostrar Ordenador a actualizar
	 * @param id identificador del ordenador
	 * @return ModelAndView /admin/updateOrdenador
	 */
	@GetMapping("/admin/updateOrdenador")
	public ModelAndView actualizaOrdenador(
			@RequestParam (name = "id") int id) {
		
		ModelAndView mav = new ModelAndView();
		
		Ordenador o = ordenadorService.findById(id);
		
		mav.addObject("ordenador", o);
		mav.setViewName("/admin/updateOrdenador");
		
		return mav;
	}
	
	/**
	 * Actualizar Ordenador en la BBDD
	 * @param id identificador del Ordenador
	 * @param nombre del ordenador
	 * @param sistemaOperativo del ordenador
	 * @param dimensionPantalla en pulgadas del monitor (entre 10 y 1000)
	 * @param cpu del ordenador
	 * @param ram del ordenador en GibaBytes (entre 1 y 1000)
	 * @param tarjetaGrafica del ordenador
	 * @param attributes redireccion de atributos
	 * @return "redirect:mostrarOrdenador". Mostrar la lista con todos los ordenadores
	 */
	@GetMapping("/admin/updateOrdenadorControl")
	public String updateOrdenador(
			@RequestParam (name = "id", required = true) int id,
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "sistemaOperativo", required = true) String sistemaOperativo,
			@RequestParam (name = "dimensionPantalla", required = true) int dimensionPantalla,
			@RequestParam (name = "cpu", required = true) String cpu,
			@RequestParam (name = "ram", required = true) int ram,
			@RequestParam (name = "tarjetaGrafica", required = true) String tarjetaGrafica,
			RedirectAttributes attributes) {
		Ordenador o = new Ordenador(id, nombre, sistemaOperativo, dimensionPantalla, cpu, ram, tarjetaGrafica);
		
		ordenadorService.update(o);
		String mensaje = "Equipo actualizado con exito!";
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarOrdenador";
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//	DELETE
	//-------------------------------------------------------------------------------------------------------

	/**
	 * Borrar un Ordenador de la BBDD
	 * @param id identificador del ordenador
	 * @param attributes redireccion de atributos
	 * @return "redirect:mostrarOrdenador". Mostrar la lista con todos los ordenadores
	 */
	@GetMapping("admin/borrarOrdenador")
	public String borrarOrdenador(
			@RequestParam(required = true) int id,
			RedirectAttributes attributes) {
		
		ordenadorService.delete(id);
		String mensaje = "Equipo borrado con exito!";
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarOrdenador";
	}
	
}
