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

import com.cice.gestaulas.entities.Ordenador;
import com.cice.gestaulas.services.interfaces.IOrdenadorService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS) // PARA QUE CREE UNA INSTANCIA POR CLASE DE TEST Y NO HAY QUE HACER STATIC
@DisplayName("Tests para Service de la entidad Ordenador")
class OrdenadoresTest{
	final String NOMBRE_TEST = "MI_PC_WINDOWS_TEST";
	final String SO_TEST = "WINDOWS_66_TEST";
	final int PULGADAS_TEST = 666;
	final String CPU_TEST = "INTEL_CORE_I99_6666K_TEST";
	final int RAM_TEST = 128;
	final String TGRAFICA_TEST = "NVIDIA_XGRTX_6666V_TEST";
	
	final String NOMBRE_TEST_UPDATE = "UPDATED_MI_PC_WINDOWS_TEST";
	final String SO_TEST_UPDATE = "UPDATED_WINDOWS_66_TEST";
	final int PULGADAS_TEST_UPDATE = 1111;
	final String CPU_TEST_UPDATE = "UPDATED_INTEL_CORE_I99_6666K_TEST";
	final int RAM_TEST_UPDATE = 1111;
	final String TGRAFICA_TEST_UPDATE = "UPDATED_NVIDIA_XGRTX_6666V_TEST";
	
	Ordenador ordenadorNuevo;
	Ordenador ordenadorAlmacenado;
	int idOrdenadorNuevo;
	
	@Autowired
	IOrdenadorService ordenadorService;
	

	/**
	 * Crear un nuevo Ordenador en la BBDD para pruebas de búsquedas
	 * @throws Exception
	 */
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		System.out.println("------------------ BEFORE ALL --------------------");
		ordenadorNuevo = new Ordenador(0,
				NOMBRE_TEST, 
				SO_TEST,
				PULGADAS_TEST, 
				CPU_TEST, 
				RAM_TEST, 
				TGRAFICA_TEST);
		ordenadorService.create(ordenadorNuevo);
		idOrdenadorNuevo = ordenadorNuevo.getId();
	}

	/**
	 * Eliminar el registro creado para test
	 * @throws Exception
	 */
	@AfterAll
	void tearDownAfterClass() throws Exception {
		System.out.println("-------------------------- AFTER ALL -----------------------");
		ordenadorService.delete(ordenadorNuevo);
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
	 * Probar guardado e integridad del Ordenador en la BBDD
	 */
	@Test
	@DisplayName("Test Create Ordenador")
	public void create() {
		System.out.println("******* CREATE *******");
		ordenadorAlmacenado = ordenadorService.findById(idOrdenadorNuevo);
		
		//Si es null el ordenador no se ha creado
		assertNotNull(ordenadorAlmacenado, ()->"Error, el ordenador no se ha guardado en la BBDD");
		
		//Comprobar si son iguales los datos almacenados y enviados
		assertEquals(ordenadorNuevo, ordenadorAlmacenado, ()->"Error, no se han almacenado correctamente los datos");	
	}

	/**
	 * 
	 */
	@Test
	@DisplayName("Test FindById Ordenador")
	public void findById() {
		System.out.println("******* FIND BY ID *******");
		ordenadorAlmacenado = ordenadorService.findById(idOrdenadorNuevo);
		assertNotNull(ordenadorAlmacenado, ()->"Error, no se ha encontrado el ordenador");
		assertEquals(ordenadorNuevo, ordenadorAlmacenado, ()->"Error, los registros no son iguales");
	}

	/**
	 * Probar FindAll Ordenador
	 */
	@Test
	@DisplayName("Test FindAll Ordenador")
	public void findAll() {
		System.out.println("******* FIND ALL *******");
		List<Ordenador> ordenadores = ordenadorService.findAll();
		assertNotNull(ordenadores, ()->"Error, no funciona FindAll");
	}

	/**
	 * Probar Update Ordenador
	 */
	@Test
	@DisplayName("Test Update Ordenador")
	public void update() {
		System.out.println("******** UPDATE ********");
		ordenadorNuevo.setNombre(NOMBRE_TEST_UPDATE);
			
		//TODO
	}

	@Test
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void delete(Ordenador o) {
		// TODO Auto-generated method stub
		
	}

}
