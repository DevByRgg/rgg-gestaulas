package com.cice.gestaulas.controllers;

import java.time.LocalDate;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cice.gestaulas.entities.auxiliar.Festivo;
import com.cice.gestaulas.exceptions.FestivoExisteException;
import com.cice.gestaulas.services.interfaces.IFestivoService;
import com.cice.gestaulas.utils.Utilidades;


/**
 * Controller para la entidad Festivo
 *
 */
@Secured("ROLE_ADMIN")
@Controller
public class FestivoController {

	@Autowired
	IFestivoService festivoService;

	//-------------------------------------------------------------------------------------------------------
	// CREATE
	//-------------------------------------------------------------------------------------------------------
	/**
	 * Cargar y mostrar la página crearFestivo
	 * @return ModelAndView mantenimiento/crearFestivo
	 */
	@RequestMapping("/mantenimiento/crearFestivo")
	public ModelAndView crearFestivoPage() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("mantenimiento/crearFestivo");
		return mav;
	}
	
	
	/**
	* Guardar el Festivo en la BBDD
	* 
	* @param nombre especifico del festivo
	* @param fecha  del festivo
	* @return
	* @throws FestivoExisteException 
	*/
	@GetMapping("/mantenimiento/crearFestivoControl") public String crearFestivo(
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "fecha", required = true) String fecha,
			RedirectAttributes attributes) throws FestivoExisteException {
		  
		LocalDate fechaFestivo = LocalDate.parse(fecha);
		  
		Festivo f = new Festivo(0, nombre, fechaFestivo); 

		// comprobar si existe
		if (festivoService.findAllFechas().contains(f.getFecha())) {
			System.out.println("LA FECHA YA EXISTE");
			throw new FestivoExisteException("La fecha ya tiene un festivo asignado");
		} else {
			System.out.println("CREAR FESTIVO ---- " + f.getNombre());
			festivoService.create(f);
			attributes.addFlashAttribute("alert", "success");
			attributes.addFlashAttribute("msg", "El festivo " + f.getNombre() + " creado con exito!");
			
			return "redirect:mostrarFestivo";
		}
	}

	/**
	 * Cargar y mostrar la página /mantenimiento/crearPeriodoFestivo
	 * @return ModelAndView
	 */
	@GetMapping(value = "/mantenimiento/crearPeriodoFestivo")
	public ModelAndView crearPeriodoFestivoPage() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("mantenimiento/crearPeriodoFestivo");
		return mav;
	}
	
	/**
	 * Guardar un periodo Festivo o Cerrado en la BBDD
	 * @param nombre del periodo Festivo
	 * @param fechaInicio inicio del periodo festivo
	 * @param fechaFin fin del periodo festivo
	 * @return "redirect:mostrarFestivo". Mostrar todos los Festivos
	 * @throws FestivoExisteException
	 */
	@GetMapping(value = "/mantenimiento/crearPeridoFestivoControl")
	public String crearPeriodoFestivo(
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "fechaInicio") String fechaInicio,
			@RequestParam (name = "fechaFin") String fechaFin,
			RedirectAttributes attributes) throws FestivoExisteException {
		LocalDate ldInicio = LocalDate.parse(fechaInicio);
		LocalDate ldFin = LocalDate.parse(fechaFin);
		int orden = ldInicio.compareTo(ldFin);

		Long l = DAYS.between(ldInicio, ldFin);
		int numDias = l.intValue() + 1;
		
		//Comprobar fecha inicio anterior a fecha fin
		if (orden > 0) {
			System.out.println("ORDEN ERRONEO");
			throw new FestivoExisteException("La fecha fin no puede ser anterior a la fecha inicio");	
		}
		
		//Graba todas las fechas anteriores al error y eso se tiene que evitar
		for (int i = 0; i < numDias; i++) {
			LocalDate fecha = ldInicio.plusDays(i);
			Festivo f = new Festivo(0, nombre, fecha);
			
			//Comprobar si ese festivo ya existe
			if (festivoService.findAllFechas().contains(f.getFecha())) {
				Festivo festivoExistente = festivoService.findByFecha(fecha);
				festivoService.delete(festivoExistente);
			}
			festivoService.create(f);
		}	
		
		attributes.addFlashAttribute("alert", "success");
		attributes.addFlashAttribute("msg", "Nombre del festivo: " + nombre + " - Numero de festivos: " + numDias);
		return "redirect:mostrarFestivo";
	}
	
	
	// -------------------------------------------------------------------------------------------------------
	// READ
	// -------------------------------------------------------------------------------------------------------

	/**
	 * Mostrar lista con los festivos creados
	 * 
	 * @return Lista de Festivo
	 */
	@GetMapping("/mantenimiento/mostrarFestivo")
	public ModelAndView findAllFestivo() {

		ModelAndView mav = new ModelAndView();

		List<Festivo> listaFestivos = festivoService.findAll();

		mav.addObject("festivos", listaFestivos);
		mav.setViewName("/mantenimiento/mostrarFestivo");
		return mav;
	}

	// -------------------------------------------------------------------------------------------------------
	// UPDATE
	// -------------------------------------------------------------------------------------------------------

	/**
	 * Mostrar la vista de mantenimiento/updateFestivo.jsp
	 * 
	 * @param id del festivo a mostrar
	 * @return ModelAndView
	 */
	@GetMapping("/mantenimiento/updateFestivo")
	public ModelAndView actualizarFestivo(
			@RequestParam(name = "id") int id) {

		ModelAndView mav = new ModelAndView();

		Festivo f = festivoService.findById(id);

		mav.addObject("festivo", f);
		mav.setViewName("/mantenimiento/updateFestivo");

		return mav;
	}

	/**
	 * Actualizar/Modificar día festivo
	 * 
	 * @param id     identificador del festivo
	 * @param nombre del día festivo
	 * @param fecha  del día festivo
	 * @return "redirect:mostrarFestivo". Mostrar lista de Festivos
	 * @throws FestivoExisteException
	 */
	@GetMapping("/mantenimiento/updateFestivoControl")
	public String updateFestivo(
			@RequestParam(name = "id") int id, @RequestParam(name = "nombre") String nombre,
			@RequestParam(name = "fecha") String fecha) throws FestivoExisteException {
		LocalDate fechaFestivo = LocalDate.parse(fecha);
		Festivo f = new Festivo(id, nombre, fechaFestivo);
		
		//Comprobar si es el mismo festivo
		if (festivoService.findById(id).getId() == f.getId()) {
			System.out.println("ES LA MISMA");
			festivoService.update(f);
			return "redirect:mostrarFestivo";
		}
		//Comprobar si ese festivo ya existe
		if (festivoService.findAllFechas().contains(f.getFecha())) {
			System.out.println("LA FECHA YA EXISTE");
			throw new FestivoExisteException("La fecha ya tiene un festivo asignado. Puede modificarlo");
		} else {
			System.out.println("CREAR FESTIVO ---- " + f.getNombre());
			Utilidades.validar(f);
			festivoService.update(f);
			return "redirect:mostrarFestivo";
		}

	}

	// -------------------------------------------------------------------------------------------------------
	// DELETE
	// -------------------------------------------------------------------------------------------------------

	/**
	 * Borrar día festivo
	 * 
	 * @param id del día festivo
	 * @return "redirect:mostrarFestivo". Mostrar todos los festivos
	 */
	@GetMapping("mantenimiento/borrarFestivo")
	public String borrarFestivo(@RequestParam(name = "id", required = true) int id) {

		festivoService.delete(id);

		return "redirect:mostrarFestivo";
	}

	// ----------------------------------------------------------------------------------------------------------
	// MÉTODOS PARA MANEJO DE EXCEPCIONES
	////// EXCEPTION_HANDLER ///////////////////////
	// ----------------------------------------------------------------------------------------------------------

	/*
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public Map<String,
	 * String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	 * Map<String, String> errors = new HashMap<>();
	 * ex.getBindingResult().getAllErrors().forEach((error) -> { String fieldName =
	 * ((FieldError) error).getField(); String errorMessage =
	 * error.getDefaultMessage(); errors.put(fieldName, errorMessage); }); return
	 * errors; }
	 */

		
	/**
	 * Capturar y gestionar FestivoExisteException. Para que no se pueda grabar
	 * festivos con la misma fecha
	 * 
	 * @param ex
	 * @return ModelAndView a la página de error.jsp
	 */
	/*
	 * @ExceptionHandler(FestivoExisteException.class) public ModelAndView
	 * gestionarErrorReservaOcupada(FestivoExisteException ex) {
	 * System.out.println("LLEGA A FESTIVO EXISTE HANDLER..localizedMessage" +
	 * ex.getLocalizedMessage());
	 * System.out.println("LLEGA A FESTIVO EXISTE HANDLER..ex.getMessage" +
	 * ex.getMessage()); ModelAndView mav = new ModelAndView();
	 * mav.setViewName("error");
	 * 
	 * // introducimos el mensaje que queremos que se muestre en error.jsp
	 * mav.addObject("mensaje", ex.getMessage()); mav.addObject("titulo",
	 * "Festivo no válido");
	 * 
	 * return mav; }
	 */
}
