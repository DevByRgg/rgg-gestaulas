package com.cice.gestaulas.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Clase con utilidades para la aplicación
 * 
 *
 */
public class Utilidades {
		
	/**
	 * Método para validar una Entidad
	 * 
	 * @param a Objeto De tipo entidad a Validar
	 * @throws ConstraintViolationException. Si hay algún dato no valido.
	 */
	public static void validar(Object obj) {
		ValidatorFactory factoryValidator = Validation.buildDefaultValidatorFactory();
		Validator validator = factoryValidator.getValidator();
		
		Set<ConstraintViolation<Object>> violations = validator.validate(obj);
		if (!violations.isEmpty()) {
			System.out.println("ERRORES EN LA VALIDACIÓN");
			throw new ConstraintViolationException(violations);
		}	
	}
	
	/**
	 * Metodo para obtener el nombre del usuario logueado
	 * @return
	 */
	public String getUserNameAuthenticated() {
		
		  String nombreUsuario = "";
		  
		  Authentication auth = SecurityContextHolder
		  .getContext().getAuthentication(); UserDetails userDetail = (UserDetails)
		  auth.getPrincipal(); nombreUsuario = userDetail.getUsername();
		 
		return nombreUsuario;
	}
	
	/**
	 * Generar atributos para mostrar los distintos mensajes
	 * @param tipoAlerta 1="success" 2="warning" 3="danger"
	 * @param mensaje String con el mensaje a mostrar
	 * @param attributes atributos para redireccionar
	 * @return RedirectAttributes con los atributos a redireccionar
	 */
	public static RedirectAttributes atributos(int tipoAlerta, String mensaje,
			RedirectAttributes attributes){
		String alerta = null;
		if (tipoAlerta == 1) { alerta = "success";}
		else if (tipoAlerta == 2) { alerta = "warning";}
		else if (tipoAlerta == 3) { alerta = "danger";}
		
		attributes.addFlashAttribute("alert", alerta);
		attributes.addFlashAttribute("msg", mensaje);
		
		return attributes;
	}
}
