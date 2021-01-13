package com.cice.gestaulas.exceptions;

import javax.naming.CommunicationException;
import java.net.ConnectException;
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
	
	
	
	
}
