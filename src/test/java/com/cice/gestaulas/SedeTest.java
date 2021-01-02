package com.cice.gestaulas;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
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
@DisplayName("Tests para el Repositorio Sedes")
//@DataJpaTest //Configuracion automática NO USAR DE MOMENTO (NO FUNCIONAN LOS SERVICIOS)
//@AutoConfigureTestDatabase(replace = Replace.NONE) //Configurar BBDD no necesario sin DataJpaTest Configuration
public class SedeTest {

	public final String NOMBRE_SEDE = "TEST_SEDE";
	public final String DIRECCION_SEDE = "TEST_DIRECCION";
	public final String CODIGO_POSTAL_SEDE = "TEST_CP";
	public final String TELEFONO_SEDE = "TEST_TFN";

	public final String NOMBRE_NO_EXISTENTE = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";

	public int idSedeTest = 0;

	@Autowired
	ISedeRepository sedeRepository;

	@Autowired
	ISedeService sedeService;

	@Test
	@DisplayName("Test Create")
	@Order(1)
	// @Commit // Hace commit -->persistente en la BBDD
	public void testCreateSede() {
		System.out.println("////////////////////////// TEST CREATE //////////////////////////////////");
		Sede sede = new Sede(0, NOMBRE_SEDE, DIRECCION_SEDE, CODIGO_POSTAL_SEDE, TELEFONO_SEDE);
		Sede savedSede = sedeRepository.save(sede);
		idSedeTest = savedSede.getId(); // guardar el id para el resto de tests
		assertNotNull(savedSede, "Error, No se ha guardado en la BBDD");
		System.out.println("/////////////////////// FIN CREATE ////////////////////////////////////////");
	}

	@Test
	@DisplayName("Test FindSedeByName existente")
	@Order(2)
	public void testFindSedeByNameExist() {

		System.out.println("////////////////////////// TEST FINDBYNAME EXISTENTE //////////////////////////////////");

		Sede sede = sedeRepository.findByNombre(NOMBRE_SEDE);

		assertAll("ComprobarBusqueda", () -> assertNotNull(sede), () -> assertEquals(sede.getNombre(), NOMBRE_SEDE));

		System.out.println("////////////////////////// FIN TESTFINDBYNE EXISTENTE //////////////////////////////////");
	}

	@Test
	@DisplayName("Test FindSedeByName no existente")
	@Order(3)
	public void testFindSedeByNameNotExist() {
		Sede sede = sedeRepository.findByNombre(NOMBRE_NO_EXISTENTE);
		assertNull(sede, () -> "Error, La sede no debe existir");
	}

	@Test
	@DisplayName("Test FindAll")
	@Order(4)
	public void testFindAll() {
		List<Sede> sedes = sedeService.findAll();
		assertNotNull(sedes, () -> "No hay sedes");
	}

	@Test
	@DisplayName("Test Update")
	@Order(5)
	public void testUpdate() {

		Sede sede = new Sede(0, NOMBRE_SEDE, NOMBRE_SEDE, NOMBRE_SEDE, NOMBRE_SEDE);

		if (idSedeTest != 0) {

			System.out.println("////////////////////////// TEST UPDATE ID CORRECTO //////////////////////////////////"
					+ idSedeTest);

			Sede sedeParaActualizar = sedeService.findById(idSedeTest);

			if (sedeParaActualizar != null) {
				sede.setId(idSedeTest);
				sedeService.update(sede);
				Sede updatedSede = sedeRepository.findByNombre(NOMBRE_SEDE);

				assertAll("Comprobar update", () -> assertEquals(updatedSede.getNombre(), NOMBRE_SEDE),
						() -> assertEquals(updatedSede.getDireccion(), NOMBRE_SEDE),
						() -> assertEquals(updatedSede.getCodigoPostal(), NOMBRE_SEDE),
						() -> assertEquals(updatedSede.getTelefono(), NOMBRE_SEDE));
			} else {
				System.out.println("ERROR....... NO SE PUEDE ACTUALIZAR NO EXISTE");
			}
			

		} else {
			System.out
					.println("**************** NO COJE EL ID DEL OBJETO GUARDADO **ID == 0***************************");
		}

	}

	@Test
	@DisplayName("Test DeleteById")
	@Order(6)
	public void testDeleteById() {

		sedeRepository.deleteById(idSedeTest);

		Sede sedeBorrada = sedeRepository.findById(idSedeTest).orElse(null);

		assertNull(sedeBorrada, () -> "La sede no se ha borrado de la BBDD");
	}

}
