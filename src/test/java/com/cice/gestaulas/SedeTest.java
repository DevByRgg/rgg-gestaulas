package com.cice.gestaulas;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.repositories.ISedeRepository;
import com.cice.gestaulas.services.interfaces.ISedeService;

@DisplayName("Tests para el Repositorio Sedes")
@DataJpaTest //Configuracion automática
@AutoConfigureTestDatabase(replace = Replace.NONE) //RollBack en la BBDD no se guarda nada
public class SedeTest {

	@Autowired
	private ISedeRepository sedeRepository;
	
	//private ISedeService sedeService;
	
	@Test
	@DisplayName("Test Create")
	@Order(1)
	//@Commit // Hace commit -->persistente en la BBDD
	public void testCreateSede() {
		Sede sede =  new Sede(0,"testSede", "testGoya33", "28001", "911112222");
		Sede savedSede = sedeRepository.save(sede);
		
		assertNotNull(savedSede, "Error, No se ha guardado en la BBDD");		
	}
	
	@Test
	@DisplayName("Test FindSedeByName existente")
	@Order(2)
	public void testFindSedeByNameExist() {
		String nombre = "Povedilla";
		Sede sede = sedeRepository.findByNombre(nombre);
			
		assertAll("ComprobarBusqueda",
				()->assertNotNull(sede),
				()->assertEquals(sede.getNombre(), nombre)
				);			
	}
	
	@Test
	@DisplayName("Test FindSedeByName no existente")
	@Order(3)
	public void testFindSedeByNameNotExist() {
		String nombre = "zzzzzzz";
		Sede sede = sedeRepository.findByNombre(nombre);	
		assertNull(sede, ()-> "Error, La sede no debe existir");
						
	}
	
	@Test
	@DisplayName("Test DeleteById")
	@Order(4)
	public void testDeleteById() {
		Sede sede =  new Sede(0,"testSede", "testGoya33", "28001", "911112222");
		Sede sedeNueva = sedeRepository.save(sede);
		sedeRepository.deleteById(sede.getId());
		
		Sede sedeBorrada = sedeRepository.findById(sedeNueva.getId()).orElse(null);
		
		assertNull(sedeBorrada, ()-> "La sede no se ha borrado de la BBDD");
	}
	
}
