package com.cice.gestaulas.exceptions;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomHandlerException extends ResponseEntityExceptionHandler {

	/**
	 * Capturar y gestionar las excepciones de JDBCConnectionException de la base de
	 * datos.
	 * 
	 * @param ex del tipo JDBCConnectionException
	 * @return ModelAndView para mostrar el error
	 */
	@ExceptionHandler(JDBCConnectionException.class)
	public ModelAndView JDBCConnectionException(JDBCConnectionException ex) {
		System.out.println("EXCEPTION HANDLER JDBCConnectionException EXCEPTION");
		final String TITULO_ERROR = "Bbdd";
		
		Map<String, String> msnError = new HashMap<String, String>();
		msnError.put("Bbdd", "Communications link failure");
		msnError.put("Error", ex.getMessage());
		msnError.put("Problema", "Es posible que la bbdd este apagada");

		ModelAndView mav = new ModelAndView();
		mav.addObject("msnError", msnError);
		mav.addObject("titulo", TITULO_ERROR);
		mav.setViewName("error");
		return mav;
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ModelAndView errorforeignKey(DataIntegrityViolationException ex) {
		String tituloError = "Foreign Key";
		Map<String, String> msnError = new HashMap<String, String>();
			msnError.put("Bbdd", "Foreign key constraint fails");
			msnError.put("Problema", "Estas intentando borrar un objeto con datos asociados");
			
		System.out.println("EXCEPTION HANDLER SPINGGGGGGGGGGGGGGGGGGG");
		System.out.println("getSQL-----------------------------------" + ex.getCause());		
		System.out.println("getSQLState---------------------------- " + ex.getMessage());		
		System.out.println("getconstrain nama---------------------------- " + ex.getMostSpecificCause());
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + ex.getLocalizedMessage());
			
		if (ex.getMostSpecificCause().toString().contains("sede")) {
			msnError.put("Error", "Sede no borrada porque aun contiene aulas");
		} else if(ex.getMostSpecificCause().toString().contains("alumno")) {
			msnError.put("Error", "Equipo no borrado porque hay aulas que lo contienen");
		} else if(ex.getMostSpecificCause().toString().contains("profesor")) {
			msnError.put("Error", "Equipo no borrado porque hay aulas que lo contienen");
		} else if(ex.getMostSpecificCause().toString().contains("equipamiento")) {	
			msnError.put("Error", "Equipamiento no borrado porque hay aulas que lo contienen");
		} else if(ex.getMostSpecificCause().toString().contains("tipo")) {
			msnError.put("Error", "Tipo de aula no borrado porque aun existen aulas que lo contienen");
		} else if(ex.getMostSpecificCause().toString().contains("reservas")) {
			msnError.put("Error", "Aula no borrada porque existen reservas asociadas a ella");
		} else if(ex.getMostSpecificCause().toString().contains("unicos")) {
			msnError.put("Error", "En este aula esa fecha esta ya reservada para otro curso");	
		} else {	
			msnError.put("Error", "Fatal Error! Contacte con el desarrollador");
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msnError", msnError);
		mav.addObject("titulo", tituloError);
		mav.setViewName("error");
		return mav;
	}
	
	@ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
	public ModelAndView errorCadenaDeBorrado(org.hibernate.exception.ConstraintViolationException ex) {
		String tituloError = "Borrado cascada";
		Map<String, String> msnError = new HashMap<String, String>();
		String mensaje = ex.getSQLException().getClass().toString();
		
		System.out.println("EXCEPTION HANDLER CASCADDAAAAAAAAAAA");
		System.out.println("getSQL-----------------------------------" + ex.getSQL());		
		System.out.println("getSQLState---------------------------- " + ex.getSQLState());		
		System.out.println("getconstrain nama---------------------------- " + ex.getConstraintName());
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + ex.getSQLException().getClass().toString());
		
		if (ex.getConstraintName().equals("fecha")) {
			tituloError = "Fecha Festivo";
			msnError.put("Error", "El festivo que has seleccionado ya existe!");
		} else if(ex.getConstraintName().equals("unicos")) {
			tituloError = "Reserva";
			msnError.put("Error", "En ese aula esa fecha esta ya reservada para otro curso!");
		} else if(ex.getConstraintName() == null) {
		
			msnError.put("Bbdd", "Fallo por borrado en cascada no permitido");
			msnError.put("Error", mensaje);
			msnError.put("Problema", "Estas intentando borrar un objeto con datos asociados");
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msnError", msnError);
		mav.addObject("titulo", tituloError);
		mav.setViewName("error");
		return mav;
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
		System.out.println("EXCEPTION HANDLER CONSTRAINTVIOLATION EXCEPTION");
		final String TITULO_ERROR = "Datos no validos";
		Map<String, String> msnError = new HashMap<String, String>();
		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();

		for (ConstraintViolation<?> constraintViolation : violations) {
			String atributo = constraintViolation.getPropertyPath().toString();
			String mensaje = constraintViolation.getMessage().trim();

			msnError.put(atributo, mensaje);
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("msnError", msnError);
		mav.addObject("titulo", TITULO_ERROR);
		mav.setViewName("error");
		return mav;
	}

	
	/**
	 * Capturar y gestionar las excepciones de ReservaOcupadaException de la base de
	 * datos.
	 * 
	 * @param ex del tipo ReservaOcupadaException
	 * @return ModelAndView para mostrar el error
	 */
	@ExceptionHandler(ReservaOcupadaException.class)
	public ModelAndView gestionarErrorReservaOcupada(ReservaOcupadaException ex) {
		System.out.println("LLEGA A EXCEPTION HANDLER...");
		final String TITULO_ERROR = "Reserva";
		
		Map<String, String> msnError = new HashMap<String, String>();
		msnError.put("Reserva", "La hora que intentas reservar esta ya ocupada");
		msnError.put("Error", ex.getMessage());
		msnError.put("Problema", "Ese aula ya tiene un cuso previsto para esa hora");

		ModelAndView mav = new ModelAndView();
		mav.addObject("msnError", msnError);
		mav.addObject("titulo", TITULO_ERROR);
		mav.setViewName("error");
		return mav;
	}
	
	
	/**
	 * Capturar y gestionar FestivoExisteException. Para que no se pueda grabar
	 * festivos con la misma fecha
	 * 
	 * @param ex excepcion de tipo FestivoExisteException
	 * @return ModelAndView a la página de error.jsp
	 */
	@ExceptionHandler(FestivoExisteException.class)
	public ModelAndView gestionarErrorReservaOcupada(FestivoExisteException ex) {
		System.out.println("LLEGA A FESTIVO EXISTE HANDLER..localizedMessage" + ex.getLocalizedMessage());
		
		final String TITULO_ERROR = "Fecha no valida";
		String mensaje = ex.getMessage();
		
		Map<String, String> msnError = new HashMap<String, String>();
		msnError.put("fecha", mensaje);
			
		ModelAndView mav = new ModelAndView();
		mav.addObject("msnError", msnError);
		mav.addObject("titulo", TITULO_ERROR);
		mav.setViewName("error");
		return mav;
	}

	
	
}
