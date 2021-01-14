package com.cice.gestaulas.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Clase con utilidades para la aplicación
 * 
 * @author Diego
 *
 */
public class Utilidades {
	
	
	// -------------------------------------------------------------------------------------------------------
	// VALIDACIONES
	// -------------------------------------------------------------------------------------------------------
	
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
}
