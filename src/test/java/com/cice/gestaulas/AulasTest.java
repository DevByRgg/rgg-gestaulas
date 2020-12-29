package com.cice.gestaulas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.repositories.IAulaRepository;
import com.cice.gestaulas.services.impl.AulaServiceImpl;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS) // PARA QUE CREE UNA INSTANCIA POR CLASE DE TEST Y NO HAY QUE HACER STATIC
class AulasTest {

	final String NOMBRE_AULA = "TEST_AULA_BORRAR";
	Aula aulaNueva;
	Aula aulaAlmacenada;
	
	@Autowired
	IAulaRepository aulaRepository;
	
	@Autowired
	AulaServiceImpl aulaService;
	Aula aula;
	
	
	/**
	 * Creamos una nueva aula en la BBDD para pruebas
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		System.out.println("------------------BEFORE ALL---------------------");
		aulaNueva = new Aula(0,NOMBRE_AULA, 1, 1, 16, 3, 3, 5);
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
	void testCreate() {
		aulaAlmacenada = aulaService.findById(aulaNueva.getId());
		
		//Si es null el aula no se ha creado
		assertNotNull(aulaAlmacenada, "Error. El aula no se ha guardado en la BBDD");
		
		//Comprobar si son iguales los datos almacenados y enviados
		assertEquals(aulaNueva, aulaAlmacenada, "Error. No se han almacenado correctamente los datos");
		
		
	}
	
	/**
	 * Probar findById Aula
	 */
	@Test
	void testFindById() {
		aulaAlmacenada = aulaService.findById(aulaNueva.getId());
		System.out.println("------------- AULA NUEVA: -----" + aulaNueva.getNombre() );
		System.out.println("------------- AULA ALMACENADA RECUPERADA: ------" + aulaAlmacenada.getNombre());
		assertEquals(aulaAlmacenada, aulaNueva, "Registros Iguales");
		
	}
	
	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}
	
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}
	
	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}
	
	@Test
	void testDeleteEntity() {
		fail("Not yet implemented");
	}

	

}
