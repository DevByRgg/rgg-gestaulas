package com.cice.gestaulas;

import static org.junit.jupiter.api.Assertions.*;

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

import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.repositories.ISedeRepository;
import com.cice.gestaulas.services.interfaces.ISedeService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Tests para Service de la entidad Sede")
class SedesTest {
	
	public final String NOMBRE_SEDE = "TEST_SEDE";
	public final String DIRECCION_SEDE = "TEST_DIRECCION";
	public final String CODIGO_POSTAL_SEDE = "TEST_CP";
	public final String TELEFONO_SEDE = "TEST_TFN";

	public final String NOMBRE_NO_EXISTENTE = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";

	public int idSedeTest = 0;

	Sede sedeNueva;
	Sede sedeAlmacenada;
	
	@Autowired
	ISedeService sedeService;


	/**
	 * Crear una Sede nueva en la BBDD para pruebas de busquedas
	 * @throws Exception
	 */
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		System.out.println("------------------ BEFORE ALL ---------------------");
		sedeNueva = new Sede(0, NOMBRE_SEDE, DIRECCION_SEDE, CODIGO_POSTAL_SEDE, TELEFONO_SEDE);
		
		sedeService.create(sedeNueva);
		idSedeTest = sedeNueva.getId();
	}

	/**
	 * Eliminar el registro creado para test 
	 * @throws Exception
	 */
	@AfterAll
	void tearDownAfterClass() throws Exception {
		System.out.println("------------------ AFTER ALL ---------------");
		sedeService.delete(sedeNueva);
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("***************************************");
		System.out.println("///////   TEST  INICIO ////////////////");
		System.out.println("***************************************");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("***************************************");
		System.out.println("////////   TEST  FIN   ////////////////");
		System.out.println("***************************************");
	}

	
	/**
	 * Probar guardado e integridad de la Sede en BBDD
	 */
	@Test
	@DisplayName("Test Create Sede")
	void testCreate() {
		System.out.println("******* CREATE *******");
		sedeAlmacenada = sedeService.findById(idSedeTest);
		
		//Comprobar que las sede se ha creado en el @BeforeAll
		assertNotNull(sedeAlmacenada, ()->"Error, La sede no se ha creado");
		
		//Comprobar integridad de los datos
		assertEquals(sedeNueva, sedeAlmacenada, ()->"Error, no se han almacenado correctamente los datos");		
	}
	
	/**
	 * Probar findById Sede
	 */
	@Test
	@DisplayName("Test FindById Sede")
	void testFindById() {
		System.out.println("******* FIND BY ID *******");
		sedeAlmacenada = sedeService.findById(idSedeTest);
		assertNotNull(sedeAlmacenada, ()->"Error, no se ha encontrado la sede");
		assertEquals(sedeNueva, sedeAlmacenada, ()->"Error, los registros no son iguales");
	}
	
	

}
