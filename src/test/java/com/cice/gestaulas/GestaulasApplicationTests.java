package com.cice.gestaulas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.repositories.IAulaRepository;
import com.cice.gestaulas.services.impl.AulaServiceImpl;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class GestaulasApplicationTests {
	final int SIZE_NOMBRE_ALEATORIO = 50;
	String nombreAula;
	Aula aulaNueva;
	Aula aulaAlmacenada;
	
	@Autowired
	IAulaRepository aulaRepository;
	
	@Autowired
	AulaServiceImpl aulaService;
	Aula aula;
	
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		
	}
	
	@Test
    public void testEmpty() {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Aula>> violations = validator.validate(new Aula());
        assertEquals(2, violations.size());
        violations.forEach(v -> System.out.println(
                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
    }
	
	
	@Test
	void testValidationMessagesEs() {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Locale.setDefault(new Locale("es", "ES"));
	    ResourceBundle rb = ResourceBundle.getBundle("ValidationMessages_es");
	    System.out.println("LEYENDO ValidationMessages.properties_ ----  " + rb.getString("aula.nombre.empty"));
	    Set<ConstraintViolation<Aula>> violations = validator.validate(new Aula());
	    for (ConstraintViolation<Aula> constraintViolation : violations) {
	    	System.out.println("VIOLATIONS MESSAGE: ------------- " + constraintViolation.getMessage()); 
		}
	    assertFalse(violations.isEmpty(), ()->"No hay ningun error constraint");
	    assertTrue(violations.stream().anyMatch(v->v.getMessage().equals(rb.getString("aula.nombre.empty"))));
	}
	
	/*
	 * @Test void testValidationMessagesEn() { Validator validator =
	 * Validation.buildDefaultValidatorFactory().getValidator();
	 * Locale.setDefault(new Locale("en", "EN")); ResourceBundle rb =
	 * ResourceBundle.getBundle("ValidationMessages_en");
	 * System.out.println("LEYENDO ValidationMessages.properties_ ----  " +
	 * rb.getString("aula.nombre.empty")); Set<ConstraintViolation<Aula>> violations
	 * = validator.validate(new Aula()); for (ConstraintViolation<Aula>
	 * constraintViolation : violations) {
	 * System.out.println("VIOLATIONS MESSAGE: ------------- " +
	 * constraintViolation.getMessage()); } assertFalse(violations.isEmpty(),
	 * ()->"No hay ningun error constraint");
	 * assertTrue(violations.stream().anyMatch(v->v.getMessage().equals(rb.getString
	 * ("aula.nombre.empty")))); }
	 */

}
