package com.cice.gestaulas;

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
	void contextLoads() {
	}

}
