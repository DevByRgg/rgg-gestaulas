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

/**
 * Clase con utilidades para la aplicación
 * 
 * @author Diego
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
}
