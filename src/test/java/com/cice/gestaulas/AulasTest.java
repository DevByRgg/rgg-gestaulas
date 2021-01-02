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
import com.cice.gestaulas.repositories.IAulaRepository;
import com.cice.gestaulas.services.impl.AulaServiceImpl;
import com.cice.gestaulas.services.interfaces.IAulaService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS) // PARA QUE CREE UNA INSTANCIA POR CLASE DE TEST Y NO HAY QUE HACER STATIC
@DisplayName("Tests para la entidad Aula")
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
	IAulaRepository aulaRepository;
	
	@Autowired
	IAulaService aulaService;
	Aula aula;
	
	
	/**
	 * Creamos una nueva aula en la BBDD para pruebas
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
		System.out.println("----------- aula nueva id: " + aulaNueva.getId());
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
	 * Probar guardado e integridad del aula en la BBDD
	 */
	@Test
	@DisplayName("Test Create Aula")
	void testCreate() {
		aulaAlmacenada = aulaService.findById(aulaNueva.getId());
		
		//Si es null el aula no se ha creado
		assertNotNull(aulaAlmacenada, ()->"Error. El aula no se ha guardado en la BBDD");
		
		//Comprobar si son iguales los datos almacenados y enviados
		assertEquals(aulaNueva, aulaAlmacenada, ()->"Error. No se han almacenado correctamente los datos");
		
		
	}
	
	/**
	 * Probar findById Aula
	 */
	@Test
	@DisplayName("Test FindById Aula")
	void testFindById() {
		aulaAlmacenada = aulaService.findById(aulaNueva.getId());
		System.out.println("------------- AULA NUEVA: -----" + aulaNueva.getNombre() );
		System.out.println("------------- AULA ALMACENADA RECUPERADA: ------" + aulaAlmacenada.getNombre());
		assertEquals(aulaAlmacenada, aulaNueva, ()-> "Registros Iguales");
		
	}
	
	/**
	 * Probar FindAll Aula
	 */
	@Test
	@DisplayName("Test FindAll Aula")
	void testFindAll() {
		List<Aula> aulas = aulaService.findAll();
		assertTrue(aulas!=null, ()-> "Funciona FindAll");
		System.out.println("-------Funciona FindAll-------");
	}
	
	/**
	 * Probar FindBySede Aula
	 */
	@Test
	@DisplayName("Test FindBySede Aula")
	void testFindBySede() {
		List<Aula> aulas = aulaService.findBySede(aulaNueva.getSede());
		assertTrue(aulas!=null, ()-> "Funciona FindBySede");
		System.out.println("-------Funciona FindBySede-------");
	}
	
	/**
	 * Probar FindByTipo Aula
	 */
	@Test
	@DisplayName("Test FindByTipo Aula")
	void testFindByTipo() {
		List<Aula> aulas = aulaService.findBySede(aulaNueva.getTipo());
		assertTrue(aulas!=null, ()-> "Funciona FindByTipo");
		System.out.println("-------Funciona FindByTipo-------");
	}
	
	/**
	 * Probar FindBySede Aula
	 */
	@Test
	@DisplayName("Test FindBySedeAndTipo Aula")
	void testFindBySedeAndTipo() {
		List<Aula> aulas = aulaService.findBySedeAndTipo(aulaNueva.getSede(), aulaNueva.getTipo());
		assertTrue(aulas!=null, ()-> "Funciona FindBySedeAndTipo");
		System.out.println("-------Funciona FindBySedeAndTipo-------");
	}
	
	/**
	 * Probar Update Aula
	 */
	@Test
	@DisplayName("Test Update Aula")
	void testUpdate() {
		aulaNueva.setCapacidad(CAPACIDAD_AULA_TEST_UPDATE);
		
		aulaService.update(aulaNueva);
		
		assertTrue(aulaNueva.getCapacidad()==CAPACIDAD_AULA_TEST_UPDATE, ()-> "Funciona Update");
		System.out.println("-------- Funciona Update ---------");
	}
	
	/**
	 * Probar DeleteById
	 */
	@Test
	@DisplayName("Test DeleteById Aula")
	void testDeleteById() {
		Aula aulaBorrar = new Aula
				(0,NOMBRE_AULA_TEST, 
					TIPO_AULA_TEST, 
					SEDE_AULA_TEST, 
					CAPACIDAD_AULA_TEST, 
					EQUIPO_PROFESOR_AULA, 
					EQUIPO_ALUMNO_AULA, 
					EQUIPAMIENTO_AULA);
		aulaService.create(aulaBorrar);
		assertNotNull(aulaBorrar, ()-> "No se ha creado aula en test deleteById. NULL");
		aulaService.delete(aulaBorrar.getId());
		assertNull(aulaService.findById(aulaBorrar.getId()), ()-> "No se ha podido borrar. Error");
		System.out.println("--------------- Funciona deleteById ----------------");
	}
	
	/**
	 * Probar DeleteEntity
	 */
	@Test
	@DisplayName("Test DeleteEntity Aula")
	void testDeleteEntity() {
		Aula aulaBorrar = new Aula
				(0,NOMBRE_AULA_TEST, 
					TIPO_AULA_TEST, 
					SEDE_AULA_TEST, 
					CAPACIDAD_AULA_TEST, 
					EQUIPO_PROFESOR_AULA, 
					EQUIPO_ALUMNO_AULA, 
					EQUIPAMIENTO_AULA);
		aulaService.create(aulaBorrar);
		assertNotNull(aulaBorrar, ()-> "No se ha creado aula en test deleteEntity. NULL");
		aulaService.delete(aulaBorrar);
		assertNull(aulaService.findById(aulaBorrar.getId()), ()-> "No se ha podido borrar. Error");
		System.out.println("--------------- Funciona deleteEntity ----------------");
	}

}
