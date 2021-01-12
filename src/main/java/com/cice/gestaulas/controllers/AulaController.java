package com.cice.gestaulas.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

@Controller
public class AulaController {

	@Autowired
	IAulaService aulaService;
	@Autowired
	ITipoAulaService tipoAulaService;
	@Autowired
	ISedeService sedeService;
	@Autowired
	IOrdenadorService ordenadorService;
	@Autowired
	IEquipamientoService equipamientoService;
	
	@Autowired
	ValidatorFactory factoryValidator;
	
	
	//-------------------------------------------------------------------------------------------------------
	//	CREATE
	//-------------------------------------------------------------------------------------------------------
	
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
		

	@GetMapping("/admin/crearAulaControl")
	public String crearAula(
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "tipo", required = true) int tipo,
			@RequestParam (name = "sede", required = true) int sede,
			@RequestParam (name = "capacidad", required = true) int capacidad,
			@RequestParam (name = "equipoProfesor", required = true) int equipoProfesor,
			@RequestParam (name = "equipoAlumno", required = true) int equipoAlumno,
			@RequestParam (name = "equipamiento", required = true) int equipamiento) {
		
		Validator validator = factoryValidator.getValidator(); 
		Aula a = new Aula(0, nombre, tipo, sede, capacidad, equipoProfesor, equipoAlumno, equipamiento);
		
		//validar Entidad Aula
		if (validar(a, validator)) {
			aulaService.create(a);
		}
		
		
		
		return "redirect:mostrarAula";
	}

	/**
	 * Método para validar un Aula
	 * @param a Objeto de la clase Aula
	 * @param validator Validador
	 * @return true si no hay errores, false si hay errores de validación
	 */
	private boolean validar(Aula a, Validator validator) {
		Set<ConstraintViolation<Aula>> violations = validator.validate(a);
		if (null == violations) {
			return true;
		}
		for (ConstraintViolation<Aula> constraintViolation : violations) {
			System.out.println(constraintViolation.getMessage());
		}
		return false;
	}

	//-------------------------------------------------------------------------------------------------------
	//	READ
	//-------------------------------------------------------------------------------------------------------
	
	

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
	
	
	//-------------------------------------------------------------------------------------------------------
	//	UPDATE
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("/admin/updateAula")
	public ModelAndView actualizaAula(
			@RequestParam (name = "id") int id) {
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
	
	
	@GetMapping("/admin/updateAulaControl")
	public String updateAula (
			@RequestParam (name = "id") int id,
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "tipo", required = true) int tipo,
			@RequestParam (name = "sede", required = true) int sede,
			@RequestParam (name = "capacidad", required = true) int capacidad,
			@RequestParam (name = "equipoProfesor", required = true) int equipoProfesor,
			@RequestParam (name = "equipoAlumno", required = true) int equipoAlumno,
			@RequestParam (name = "equipamiento", required = true) int equipamiento) {
		
		Aula a = new Aula(id, nombre, tipo, sede, capacidad, equipoProfesor, equipoAlumno, equipamiento);
		
		aulaService.update(a);
		
		return "redirect:mostrarAula";
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//	DELETE
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("admin/borrarAula")
	public String borrarAula(
			@RequestParam(required = true) int id){
		aulaService.delete(id);
		
		return "redirect:mostrarAula";
	}

}
