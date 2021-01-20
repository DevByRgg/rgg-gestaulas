package com.cice.gestaulas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Equipamiento;
import com.cice.gestaulas.entities.Ordenador;
import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.entities.auxiliar.ObjetoPresentacion;
import com.cice.gestaulas.entities.auxiliar.TipoAula;
import com.cice.gestaulas.services.interfaces.IAulaService;
import com.cice.gestaulas.services.interfaces.IEquipamientoService;
import com.cice.gestaulas.services.interfaces.IOrdenadorService;
import com.cice.gestaulas.services.interfaces.ISedeService;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;
import com.cice.gestaulas.utils.Utilidades;

@Secured("ROLE_ADMIN")
@Controller
public class AulaController {

	/**
	 * Servicios de Aula
	 */
	@Autowired
	IAulaService aulaService;
	/**
	 * Servicios de TipoAula 
	 */
	@Autowired
	ITipoAulaService tipoAulaService;
	
	/**
	 * Servicios de Sede
	 */
	@Autowired
	ISedeService sedeService;
	
	/**
	 * Servicios de Ordenador
	 */
	@Autowired
	IOrdenadorService ordenadorService;
	
	/**
	 * Servicios de Equipamiento
	 */
	@Autowired
	IEquipamientoService equipamientoService;


	// -------------------------------------------------------------------------------------------------------
	// CREATE
	// -------------------------------------------------------------------------------------------------------

	/**
	 * Cargar y mostrar la página crearAula
	 * @return ModelAndView 
	 */
	@GetMapping("/admin/crearAula")
	public ModelAndView crearAulaPage() {
		ModelAndView mav = new ModelAndView();

		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();
		List<Sede> listaSedes = sedeService.findAll();
		List<Ordenador> listaOrdenadores = ordenadorService.findAll();
		List<Equipamiento> listaEquipamientos = equipamientoService.findAll();

		mav.addObject("tipoAulas", listaTipoAulas);
		mav.addObject("sedes", listaSedes);
		mav.addObject("ordenadores", listaOrdenadores);
		mav.addObject("equipamientos", listaEquipamientos);
		mav.setViewName("admin/crearAula");
		return mav;
	}

	/**
	 * Crear un Aula en la BBDD
	 * @param nombre del Aula
	 * @param tipo identificador del TipoAula
	 * @param sede identificador de la Sede
	 * @param capacidad del Aula
	 * @param equipoProfesor identificador Ordenador
	 * @param equipoAlumno identificador Ordenador
	 * @param equipamiento identificador Equipamiento
	 * @param attributes redireccion de atributos
	 * @return "redirect:mostrarAula". Mostrar las Aulas
	 */
	@GetMapping("/admin/crearAulaControl")
	public String crearAula(@RequestParam(name = "nombre", required = true) String nombre,
			@RequestParam(name = "tipo", required = true) int tipo,
			@RequestParam(name = "sede", required = true) int sede,
			@RequestParam(name = "capacidad", required = true) int capacidad,
			@RequestParam(name = "equipoProfesor", required = true) int equipoProfesor,
			@RequestParam(name = "equipoAlumno", required = true) int equipoAlumno,
			@RequestParam(name = "equipamiento", required = true) int equipamiento,
			RedirectAttributes attributes) {

		Aula a = new Aula(0, nombre, tipo, sede, capacidad, equipoProfesor, equipoAlumno, equipamiento);

		aulaService.create(a);
		String mensaje = "Aula creada con exito!";
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarAula";
	}

	// -------------------------------------------------------------------------------------------------------
	// READ
	// -------------------------------------------------------------------------------------------------------

	/**
	 * Mostrar todas las aulas de la BBDD
	 * 
	 * @return ModelAndView "/admin/mostrarAula"
	 */
	@GetMapping("/admin/mostrarAula")
	public ModelAndView findAllAula() {
		ModelAndView mav = new ModelAndView();
		List<Aula> listaAulas = aulaService.findAll();
		List<ObjetoPresentacion> listaPresentacion = new ArrayList<ObjetoPresentacion>();

		for (int i = 0; i < listaAulas.size(); i++) {
			Aula a = listaAulas.get(i);
			TipoAula t = tipoAulaService.findById(a.getTipo());
			Sede s = sedeService.findById(a.getSede());
			Ordenador o = ordenadorService.findById(a.getEquipoProfesor());
			Equipamiento e = equipamientoService.findById(a.getEquipamiento());

			ObjetoPresentacion obj = new ObjetoPresentacion(a.getId(), a.getNombre(), t.getId(), t.getNombre(),
					s.getId(), s.getNombre(), a.getCapacidad(), o.getId(), o.getNombre(), e.getId(), e.getNombre());

			listaPresentacion.add(obj);
		}

		mav.addObject("aulas", listaPresentacion);
		mav.setViewName("/admin/mostrarAula");
		return mav;
	}

	// -------------------------------------------------------------------------------------------------------
	// UPDATE
	// -------------------------------------------------------------------------------------------------------

	/**
	 * Mostrar aula a actualizar
	 * @param id identificador del aula
	 * @return ModelAndView /admin/updateAula
	 */
	@GetMapping("/admin/updateAula")
	public ModelAndView actualizaAula(@RequestParam(name = "id") int id) {
		ModelAndView mav = new ModelAndView();

		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();
		List<Sede> listaSedes = sedeService.findAll();
		List<Ordenador> listaOrdenadores = ordenadorService.findAll();
		List<Equipamiento> listaEquipamientos = equipamientoService.findAll();

		Aula a = aulaService.findById(id);

		mav.addObject("tipoAulas", listaTipoAulas);
		mav.addObject("sedes", listaSedes);
		mav.addObject("ordenadores", listaOrdenadores);
		mav.addObject("equipamientos", listaEquipamientos);
		mav.addObject("aula", a);
		mav.setViewName("/admin/updateAula");

		return mav;
	}

	/**
	 * Actualizar aula en la BBDD
	 * @param id identificador del Aula
	 * @param nombre del aula
	 * @param tipo identificador de TipoAula
	 * @param sede identificador de la Sede
	 * @param capacidad del aula
	 * @param equipoProfesor identificador Ordenador del profesor
	 * @param equipoAlumno identificador Ordenador de los alumnos
	 * @param equipamiento del aula
	 * @param attributes redireccion de atributos
	 * @return "redirect:mostrarAula". Mostrar todas las Aulas
	 */
	@GetMapping("/admin/updateAulaControl")
	public String updateAula(@RequestParam(name = "id") int id,
			@RequestParam(name = "nombre", required = true) String nombre,
			@RequestParam(name = "tipo", required = true) int tipo,
			@RequestParam(name = "sede", required = true) int sede,
			@RequestParam(name = "capacidad", required = true) int capacidad,
			@RequestParam(name = "equipoProfesor", required = true) int equipoProfesor,
			@RequestParam(name = "equipoAlumno", required = true) int equipoAlumno,
			@RequestParam(name = "equipamiento", required = true) int equipamiento,
			RedirectAttributes attributes) {

		Aula a = new Aula(id, nombre, tipo, sede, capacidad, equipoProfesor, equipoAlumno, equipamiento);
		
		aulaService.update(a);
		String mensaje = "Aula actualizada con exito!";
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarAula";
	}

	// -------------------------------------------------------------------------------------------------------
	// DELETE
	// -------------------------------------------------------------------------------------------------------

	/**
	 * Borrar un Aula de la BBDD
	 * @param id identificador del Aula
	 * @param attributes redireccion de atributos
	 * @return "redirect:mostrarAula". Mostrar todas las Aulas
	 */
	@GetMapping("admin/borrarAula")
	public String borrarAula(
			@RequestParam(required = true) int id,
			RedirectAttributes attributes) {
		
		aulaService.delete(id);
		String mensaje = "Aula borrada con exito!";
		Utilidades.atributos(1, mensaje, attributes);
		return "redirect:mostrarAula";
	}
}
