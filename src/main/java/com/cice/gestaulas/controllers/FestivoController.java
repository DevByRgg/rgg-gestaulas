package com.cice.gestaulas.controllers;

import org.hibernate.exception.ConstraintViolationException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.time.temporal.ChronoUnit.DAYS;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.auxiliar.Festivo;
import com.cice.gestaulas.exceptions.FestivoExisteException;
import com.cice.gestaulas.services.interfaces.IFestivoService;


/**
 * Controller para la entidad Festivo
 *
 */
@Validated
@Controller
public class FestivoController {

	@Autowired
	IFestivoService festivoService;

	//-------------------------------------------------------------------------------------------------------
	// CREATE
	//-------------------------------------------------------------------------------------------------------
	/**
	 * Mostrar la vista de mantenimiento/crearFestivo.jsp
	 * 
	 */
	@RequestMapping(value = "/mantenimiento/crearFestivo", method = RequestMethod.GET)
	public @ResponseBody ModelAndView crearFestivoPage() {
		return new ModelAndView("mantenimiento/crearFestivo", "festivo", new Festivo());
	}

	/**
	 * Guardar el Festivo en la BBDD
	 * 
	 * @param nombre especifico del festivo
	 * @param fecha  del festivo
	 * @return
	 * @throws FestivoExisteException
	 */
	@RequestMapping(value = "/mantenimiento/crearFestivoControl", method = RequestMethod.POST)
	public String crearFestivo(@Valid Festivo festivo, BindingResult bindingResult) throws FestivoExisteException {

		if (bindingResult.hasErrors()) {
			System.out.println("ERROR DE VALIDACION TEST");
			// bindingResult.getFieldError().getDefaultMessage();
			return "/mantenimiento/crearFestivo";
		}

		// comprobar si existe
		if (festivoService.findAllFechas().contains(festivo.getFecha())) {
			System.out.println("LA FECHA YA EXISTE");
			throw new FestivoExisteException("La fecha ya tiene un festivo asignado. Puede modificarlo");

		} else {
			System.out.println("CREAR FESTIVO ---- " + festivo.getNombre());
			festivoService.create(festivo);
			return "redirect:mostrarFestivo";
		}
	}

	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping(value = "/mantenimiento/crearPeriodoFestivo")
	public ModelAndView crearPeriodoFestivoPage() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("mantenimiento/crearPeriodoFestivo");
		return mav;
	}
	
	@GetMapping(value = "/mantenimiento/crearPeridoFestivoControl")
	public String crearPeriodoFestivo(
			@RequestParam (name = "nombre", required = true) String nombre,
			@RequestParam (name = "fechaInicio") String fechaInicio,
			@RequestParam (name = "fechaFin") String fechaFin) throws FestivoExisteException {
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
				throw new FestivoExisteException("La fecha " + fecha + " ya tiene un festivo asignado. Puede modificarlo");
			} else {
				festivoService.create(f);
			}	
		}
		
		return "redirect:mostrarFestivo";
	}
	
	
	/**
	 * Guardar el Festivo en la BBDD
	 * 
	 * @param nombre especifico del festivo
	 * @param fecha  del festivo
	 * @return
	 *//*
		 * @GetMapping("/mantenimiento/crearFestivoControl") public String crearFestivo(
		 * 
		 * @RequestParam (name = "nombre", required = true) String nombre,
		 * 
		 * @RequestParam (name = "fecha", required = true) String fecha) {
		 * 
		 * ModelAndView mav = new ModelAndView();
		 * 
		 * LocalDate fechaFestivo = LocalDate.parse(fecha);
		 * 
		 * Festivo f = new Festivo(0, nombre, fechaFestivo); festivoService.create(f);
		 * 
		 * return "redirect:crearFestivo"; }
		 */

	
	
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
	 * @return Modelo
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
	 * @return
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
	 * @return redireccion a mostrarFestivo
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

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	/**
	 * Capturar y gestionar las excepciones de constraint violation de la base de
	 * datos.
	 * 
	 * @param ex del tipo ConstraintViolationException
	 * @return ModelAndView para mostrar el error
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView ConstraintViolationExceptions(ConstraintViolationException ex) {
		System.out.println("EXCEPTION HANDLER CONSTRAINTVIOLATION EXCEPTION -- MENSAJE: ");
		String mensaje = "Esa fecha ya esta reservada!! Modificala";
		
		System.out.println("--" + ex.getConstraintName());
		System.out.println("--" + ex.getErrorCode());
		System.out.println("--" + ex.getLocalizedMessage());
		System.out.println("--" + ex.getMessage());
		System.out.println("--" + ex.getSQL());
		System.out.println("--" + ex.getSQLState());
		
		/*Esto no funciona
			String mensaje = ex.getMessage() != null ? ex.getMessage().split(":")[0] : "Constraint en BBDD no admitido";
		*/
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("mensajesError", mensaje);
		mav.addObject("titulo", "Datos no válidos");
		return mav;

	}
	
	/**
	 * Capturar y gestionar FestivoExisteException. Para que no se pueda grabar
	 * festivos con la misma fecha
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(FestivoExisteException.class)
	public ModelAndView gestionarErrorReservaOcupada(FestivoExisteException ex) {
		System.out.println("LLEGA A FESTIVO EXISTE HANDLER..localizedMessage" + ex.getLocalizedMessage());
		System.out.println("LLEGA A FESTIVO EXISTE HANDLER..ex.getMessage" + ex.getMessage());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");

		// introducimos el mensaje que queremos que se muestre en error.jsp
		mav.addObject("mensaje", ex.getLocalizedMessage());
		mav.addObject("titulo", "Festivo no válido");

		return mav;
	}

}
