package com.cice.gestaulas.exceptions;

import javax.naming.CommunicationException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import java.net.ConnectException;
import java.util.Set;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomHandlerException extends ResponseEntityExceptionHandler{

	//Parece no ser necesario probar a quitarlo
	@ExceptionHandler(CommunicationException.class)
	public ModelAndView CommunicationsException(CommunicationException ex) {
		System.out.println("EXCEPTION HANDLER CONSTRAINTVIOLATION EXCEPTION -- MENSAJE: ");
		String mensaje = "Fallo en la bbdd, compruebe si esta encendida";
		
		/*Esto no funciona
			String mensaje = ex.getMessage() != null ? ex.getMessage().split(":")[0] : "Constraint en BBDD no admitido";
		*/
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("mensajesError", mensaje);
		mav.addObject("titulo", "Datos no válidos");
		return mav;
	}
	
	//Parece no ser necesario probar a quitarlo
	@ExceptionHandler(ConnectException.class)
	public ModelAndView ConnectException(ConnectException ex) {
		System.out.println("EXCEPTION HANDLER CONSTRAINTVIOLATION EXCEPTION -- MENSAJE: ");
		String mensaje = "Fallo en la bbdd!! Compruebe si esta encendida";
		
		System.out.println("--" + ex.fillInStackTrace());
		System.out.println("--" + ex.getLocalizedMessage());
		System.out.println("--" + ex.getMessage());
		System.out.println("--" + ex.fillInStackTrace());
		System.out.println("--" + ex.getCause());
		
		/*Esto no funciona
			String mensaje = ex.getMessage() != null ? ex.getMessage().split(":")[0] : "Constraint en BBDD no admitido";
		*/
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("mensajesError", mensaje);
		mav.addObject("titulo", "Datos no válidos");
		return mav;
	}
	
	//Este metodo es para cuando la bbdd esta apagada
	@ExceptionHandler(JDBCConnectionException.class)
	public ModelAndView JDBCConnectionException(JDBCConnectionException ex) {
		System.out.println("EXCEPTION HANDLER CONSTRAINTVIOLATION EXCEPTION -- MENSAJE: ");
		String mensaje = "Fallo en la bbdd!! La bbdd puede estar apagada";
		
		System.out.println("--" + ex.getErrorCode());
		System.out.println("--" + ex.getLocalizedMessage());
		System.out.println("--" + ex.getMessage());
		System.out.println("--" + ex.fillInStackTrace());
		System.out.println("--" + ex.getCause());
		
		/*Esto no funciona
			String mensaje = ex.getMessage() != null ? ex.getMessage().split(":")[0] : "Constraint en BBDD no admitido";
		*/
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("mensajesError", mensaje);
		mav.addObject("titulo", "Conexion bbdd");
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
		final String TITULO_ERROR = "Datos no válidos";
		ModelAndView mav = new ModelAndView();
		String[] mensajesError;
		String mensaje = "";
		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
		for (ConstraintViolation<?> constraintViolation : violations) {
			
			//para separar los mensajes
			String atributo = constraintViolation.getPropertyPath().toString().toUpperCase();
			
			mensaje += atributo + ": " + constraintViolation.getMessage().trim() + "#";
			System.out.println(mensaje);
		}
		//puede haber varios mensajes de error
		mensajesError = mensaje.split("#");
	
		mav.setViewName("error");
		mav.addObject("mensajesError", mensajesError);
		mav.addObject("titulo", TITULO_ERROR);
		return mav;
	}
	
	
	
	
}
