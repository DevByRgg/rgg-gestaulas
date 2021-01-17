package com.cice.gestaulas.exceptions;

import javax.naming.CommunicationException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import java.net.ConnectException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomHandlerException extends ResponseEntityExceptionHandler {

	// Parece no ser necesario probar a quitarlo
	@ExceptionHandler(CommunicationException.class)
	public ModelAndView CommunicationsException(CommunicationException ex) {
		System.out.println("EXCEPTION HANDLER CommunicationException EXCEPTION");
		String mensaje = "Fallo en la bbdd, compruebe si esta encendida";

		/*
		 * Esto no funciona String mensaje = ex.getMessage() != null ?
		 * ex.getMessage().split(":")[0] : "Constraint en BBDD no admitido";
		 */

		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("mensajesError", mensaje);
		mav.addObject("titulo", "Datos no válidos");
		return mav;
	}

	// Parece no ser necesario probar a quitarlo
	@ExceptionHandler(ConnectException.class)
	public ModelAndView ConnectException(ConnectException ex) {
		System.out.println("EXCEPTION HANDLER ConnectException EXCEPTION");
		String mensaje = "Fallo en la bbdd!! Compruebe si esta encendida";

		System.out.println("--" + ex.fillInStackTrace());
		System.out.println("--" + ex.getLocalizedMessage());
		System.out.println("--" + ex.getMessage());
		System.out.println("--" + ex.fillInStackTrace());
		System.out.println("--" + ex.getCause());

		/*
		 * Esto no funciona String mensaje = ex.getMessage() != null ?
		 * ex.getMessage().split(":")[0] : "Constraint en BBDD no admitido";
		 */

		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("mensajesError", mensaje);
		mav.addObject("titulo", "Datos no válidos");
		return mav;
	}

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
	
	@ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
	public ModelAndView errorCadenaDeBorrado(org.hibernate.exception.ConstraintViolationException ex) {
		System.out.println("EXCEPTION HANDLER CASCADDAAAAAAAAAAA");
		
		System.out.println("getSQL-----------------------------------" + ex.getSQL());		
		System.out.println("getSQLState---------------------------- " + ex.getSQLState());		
		System.out.println("getconstrain nama---------------------------- " + ex.getConstraintName());		
		final String TITULO_ERROR = "Borrado cascada";
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + ex.getSQLException().getClass().toString());
		String mensaje = ex.getSQLException().getClass().toString();;
		
		Map<String, String> msnError = new HashMap<String, String>();
		
		msnError.put("Bbdd", "Fallo por borrado en cascada no permitido");
		msnError.put("Error", mensaje);
		msnError.put("Problema", "Estas intentando borrar un objeto con datos asociados");

		ModelAndView mav = new ModelAndView();
		mav.addObject("msnError", msnError);
		mav.addObject("titulo", TITULO_ERROR);
		mav.setViewName("error");
		return mav;
	}
	
	/*
	 * @ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
	 * public ModelAndView
	 * errorCadenaDeBorrado(org.hibernate.exception.ConstraintViolationException ex)
	 * { System.out.
	 * println("EXCEPTION HANDLER SQLIntegrityConstraintViolationException"); final
	 * String TITULO_ERROR = "No se puede eliminar porque contiene datos";
	 * 
	 * String mensaje = ex.getMessage();
	 * 
	 * Map<String, String> msnError = new HashMap<String, String>();
	 * msnError.put("mensaje", mensaje);
	 * 
	 * 
	 * ModelAndView mav = new ModelAndView(); mav.addObject("msnError", msnError);
	 * mav.addObject("titulo", TITULO_ERROR); mav.setViewName("error"); return mav;
	 * }
	 */

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
	 * Capturar y gestionar FestivoExisteException. Para que no se pueda grabar
	 * festivos con la misma fecha
	 * 
	 * @param ex
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
