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

import com.cice.gestaulas.entities.auxiliar.TipoAula;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS) // PARA QUE CREE UNA INSTANCIA POR CLASE DE TEST Y NO HAY QUE HACER STATIC
@DisplayName("Tests para Service de la entidad TipoAula")
class TiposAulaTest {
	final String NOMBRE_TIPOAULA_TEST = "TEST_TIPO_AULA_LINUXBORRAR";
	final String NOMBRE_TIPOAULA_TEST_UPDATE = "UPDATED_TEST_TIPO_AULA_LINUX";
	
	int idTipoAulaNueva;
	
	TipoAula tipoAulaNueva;
	TipoAula tipoAulaAlmacenada;
	
	@Autowired
	ITipoAulaService tipoAulaService;
	
	/**
	 * Crear un nuevo TipoAula en la BBDD para pruebas de búsquedas
	 * @throws Exception
	 */
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		System.out.println("------------------BEFORE ALL---------------------");
		tipoAulaNueva = new TipoAula(0, NOMBRE_TIPOAULA_TEST);
		
		tipoAulaService.create(tipoAulaNueva);
		idTipoAulaNueva = tipoAulaNueva.getId();
	}

	/**
	 * Eliminar el registro creado para test
	 * @throws Exception
	 */
	@AfterAll
	void tearDownAfterClass() throws Exception {
		System.out.println("-------------------------- AFTER ALL -----------------------");
		tipoAulaService.delete(idTipoAulaNueva); //eliminar el creado al final
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
	 * Probar guardado e integridad del TipoAula en la BBDD
	 */
	@Test
	@DisplayName("Test Create TipoAula")
	public void testCreate() {
		System.out.println("******* CREATE *******");
		tipoAulaAlmacenada = tipoAulaService.findById(idTipoAulaNueva);
		
		//si es null el aula no se ha creado
		assertNotNull(tipoAulaAlmacenada, ()-> "Error, el tipoAula no se ha guardado en la BBDD");
		
		//comprobar si son iguales los datos almacenados y enviados
		assertEquals(tipoAulaNueva, tipoAulaAlmacenada, ()-> "Error, no se han almacenado correctamente los datos");
	}

	/**
	 * Probar findById TipoAula
	 */
	@Test
	@DisplayName("Test FindById TipoAula")
	public void testFindById() {
		System.out.println("******* FIND BY ID *******");
		tipoAulaAlmacenada = tipoAulaService.findById(idTipoAulaNueva);
		assertNotNull(tipoAulaAlmacenada, ()-> "Error, no se ha encontrado el tipoAula");
		assertEquals(tipoAulaNueva, tipoAulaAlmacenada, ()-> "Error, los registros no son iguales");
	}

	/**
	 * Probar findAll TipoAula
	 */
	@Test
	@DisplayName("Test FindAll TipoAula")
	public void testFindAll() {
		System.out.println("******* FIND ALL *******");
		List<TipoAula> tiposAula = tipoAulaService.findAll();
		assertNotNull(tiposAula, ()-> "Error, no funciona FindAll");
	}

	/**
	 * Probar update TipoAula
	 */
	@Test
	@DisplayName("Test Update TipoAula")
	public void testUpdate() {
		System.out.println("******** UPDATE ********");
		tipoAulaNueva.setNombre(NOMBRE_TIPOAULA_TEST_UPDATE);
		
		tipoAulaService.update(tipoAulaNueva);
		tipoAulaAlmacenada = tipoAulaService.findById(idTipoAulaNueva);
		
		assertEquals(NOMBRE_TIPOAULA_TEST_UPDATE, tipoAulaAlmacenada.getNombre(), ()-> "Error, no funciona Update");
	}

	/**
	 * Probar delete By Id
	 */
	@Test
	@DisplayName("Test DeleteById TipoAula")
	public void testDeleteById() {
		System.out.println("******** DELETE BY ID ********");
		TipoAula tipoAulaBorrar = new TipoAula(0, NOMBRE_TIPOAULA_TEST);
		
		//crear aula
		tipoAulaService.create(tipoAulaBorrar);
		//comprobar
		assertNotNull(tipoAulaBorrar, ()-> "Error, no se ha creado tipoAula en test deleteById. NULL");
		int idTipoAulaBorrar = tipoAulaBorrar.getId();
		//borrar
		tipoAulaService.delete(idTipoAulaBorrar);
		//comprobar
		assertNull(tipoAulaService.findById(idTipoAulaBorrar), ()-> "Error, no se ha podido borrar");	
	}

	/**
	 * Probar delete Entity
	 */
	@Test
	@DisplayName("Test DeleteEntity TipoAula")
	public void testDeleteEntity() {
		System.out.println("******** DELETE BY TIPOAULA ********");
		TipoAula tipoAulaBorrar = new TipoAula(0, NOMBRE_TIPOAULA_TEST);
		
		//crear aula
		tipoAulaService.create(tipoAulaBorrar);
		//comprobar
		assertNotNull(tipoAulaBorrar, ()-> "Error, no se ha creado tipoAula en test deleteById. NULL");
		int idTipoAulaBorrar = tipoAulaBorrar.getId();
		//borrar
		tipoAulaService.delete(tipoAulaBorrar);
		//comprobar
		assertNull(tipoAulaService.findById(idTipoAulaBorrar), ()-> "Error, no se ha podido borrar");	
	}

}
