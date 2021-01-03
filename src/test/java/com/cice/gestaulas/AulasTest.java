package com.cice.gestaulas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.services.interfaces.IAulaService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS) // PARA QUE CREE UNA INSTANCIA POR CLASE DE TEST Y NO HAY QUE HACER STATIC
@DisplayName("Tests para Service de la entidad Aula")
class AulasTest {

	final String NOMBRE_AULA_TEST = "TEST_AULA_BORRAR";
	final int TIPO_AULA_TEST = 1;
	final int SEDE_AULA_TEST = 1;
	final int CAPACIDAD_AULA_TEST = 33;
	final int EQUIPO_PROFESOR_AULA = 3;
	final int EQUIPO_ALUMNO_AULA = 3;
	final int EQUIPAMIENTO_AULA = 5;
	final int CAPACIDAD_AULA_TEST_UPDATE = 9999;
	
	Aula aulaNueva;
	Aula aulaAlmacenada;
	
	@Autowired
	IAulaService aulaService;
	
	
	/**
	 * Crear una nueva aula en la BBDD para pruebas de busquedas
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		System.out.println("------------------BEFORE ALL---------------------");
		aulaNueva = new Aula(0,NOMBRE_AULA_TEST, 
				TIPO_AULA_TEST, 
				SEDE_AULA_TEST, 
				CAPACIDAD_AULA_TEST, 
				EQUIPO_PROFESOR_AULA, 
				EQUIPO_ALUMNO_AULA, 
				EQUIPAMIENTO_AULA);
		aulaService.create(aulaNueva);
		//System.out.println("----------- aula nueva id: " + aulaNueva.getId());
	}
	
	/**
	 * Eliminar el registro creado para test
	 * @throws java.lang.Exception
	 */
	@AfterAll
	void tearDownAfterClass() throws Exception {
		 {
			System.out.println("-------------------------- AFTER ALL -----------------------");
			aulaService.delete(aulaNueva); //eliminar el registro creado
		}
	}

	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
			System.out.println("***************************************");
			System.out.println("///////   TEST  INICIO ////////////////");
			System.out.println("***************************************");	
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("***************************************");
		System.out.println("////////   TEST  FIN   ////////////////");
		System.out.println("***************************************");
	}
	
	
	/**
	 * Probar guardado e integridad del Aula en la BBDD
	 */
	@Test
	@DisplayName("Test Create Aula")
	void testCreate() {
		System.out.println("******* CREATE *******");
		aulaAlmacenada = aulaService.findById(aulaNueva.getId());
		
		//Si es null el aula no se ha creado
		assertNotNull(aulaAlmacenada, ()->"Error, el aula no se ha guardado en la BBDD");
		
		//Comprobar si son iguales los datos almacenados y enviados
		assertEquals(aulaNueva, aulaAlmacenada, ()->"Error, no se han almacenado correctamente los datos");	
	}
	
	/**
	 * Probar findById Aula
	 */
	@Test
	@DisplayName("Test FindById Aula")
	void testFindById() {
		System.out.println("******* FIND BY ID *******");
		aulaAlmacenada = aulaService.findById(aulaNueva.getId());
		assertNotNull(aulaAlmacenada, ()-> "Error, no se ha encontrado el aula");
		assertEquals(aulaNueva, aulaAlmacenada, ()-> "Error, los registros no son iguales");		
	}
	
	/**
	 * Probar FindAll Aula
	 */
	@Test
	@DisplayName("Test FindAll Aula")
	void testFindAll() {
		System.out.println("******* FIND ALL *******");
		List<Aula> aulas = aulaService.findAll();
		assertNotNull(aulas, ()-> "Error, no funciona FindAll");
	}
	
	/**
	 * Probar FindBySede Aula
	 */
	@Test
	@DisplayName("Test FindBySede Aula")
	void testFindBySede() {
		System.out.println("******** FIND BY SEDE ********");
		List<Aula> aulas = aulaService.findBySede(aulaNueva.getSede());
		assertNotNull(aulas, ()-> "Error, no funciona FindBySede");
	}
	
	/**
	 * Probar FindByTipo Aula
	 */
	@Test
	@DisplayName("Test FindByTipo Aula")
	void testFindByTipo() {
		System.out.println("******** FIND BY TIPO ********");
		List<Aula> aulas = aulaService.findBySede(aulaNueva.getTipo());
		assertNotNull(aulas, ()-> "Error, no funciona FindByTipo");
	}
	
	/**
	 * Probar FindBySede Aula
	 */
	@Test
	@DisplayName("Test FindBySedeAndTipo Aula")
	void testFindBySedeAndTipo() {
		System.out.println("******** FIND BY SEDE AND TIPO ********");
		List<Aula> aulas = aulaService.findBySedeAndTipo(aulaNueva.getSede(), aulaNueva.getTipo());
		assertNotNull(aulas, ()-> "Funciona FindBySedeAndTipo");
	}
	
	/**
	 * Probar Update Aula
	 */
	@Test
	@DisplayName("Test Update Aula")
	void testUpdate() {
		System.out.println("******** UPDATE ********");
		aulaNueva.setCapacidad(CAPACIDAD_AULA_TEST_UPDATE);
		
		aulaService.update(aulaNueva);
		
		assertEquals(CAPACIDAD_AULA_TEST_UPDATE, aulaNueva.getCapacidad(), ()-> "Error, no funciona Update");
	}
	
	/**
	 * Probar DeleteById
	 */
	@Test
	@DisplayName("Test DeleteById Aula")
	void testDeleteById() {
		System.out.println("******** DELETE BY ID ********");
		Aula aulaBorrar = new Aula
				(0,NOMBRE_AULA_TEST, 
					TIPO_AULA_TEST, 
					SEDE_AULA_TEST, 
					CAPACIDAD_AULA_TEST, 
					EQUIPO_PROFESOR_AULA, 
					EQUIPO_ALUMNO_AULA, 
					EQUIPAMIENTO_AULA);
		aulaService.create(aulaBorrar);
		assertNotNull(aulaBorrar, ()-> "Error, no se ha creado aula en test deleteById. NULL");
		aulaService.delete(aulaBorrar.getId());
		assertNull(aulaService.findById(aulaBorrar.getId()), ()-> "Error, no se ha podido borrar");
	}
	
	/**
	 * Probar DeleteEntity
	 */
	@Test
	@DisplayName("Test DeleteEntity Aula")
	void testDeleteEntity() {
		System.out.println("******** DELETE BY AULA ********");
		Aula aulaBorrar = new Aula
				(0,NOMBRE_AULA_TEST, 
					TIPO_AULA_TEST, 
					SEDE_AULA_TEST, 
					CAPACIDAD_AULA_TEST, 
					EQUIPO_PROFESOR_AULA, 
					EQUIPO_ALUMNO_AULA, 
					EQUIPAMIENTO_AULA);
		aulaService.create(aulaBorrar);
		assertNotNull(aulaBorrar, ()-> "Error, no se ha creado aula en test deleteEntity. NULL");
		aulaService.delete(aulaBorrar);
		assertNull(aulaService.findById(aulaBorrar.getId()), ()-> "Error, no se ha podido borrar");
	}
}
