package com.cice.gestaulas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Aula;

@Controller
public class ConsultaHomeController extends ConsultaAuxiliarController{
	
	@GetMapping("consultas/consultarAulasDisponibles")
	public ModelAndView buscarAulaPage() {
		int zone = 0;
		List<Aula> aulas = new ArrayList<Aula>();
		
		ModelAndView mav = consultaAulas(aulas, -1, -1, -1, -1, 0, zone);
		
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("consultas/filtrarAulasDisponibles")
	public ModelAndView elegirAulaPage(
		@RequestParam (name="sede") int sede,
		@RequestParam (name="tipo") int tipo,
		@RequestParam (name="mes") int mes,
		@RequestParam (name="anio") int anio,
		@RequestParam (name="turno") int turno) {
		int zone = 0;
		List<Aula> listaAulas = elegirAula(sede, tipo, mes, anio, turno);

		ModelAndView mav = consultaAulas(listaAulas, sede, tipo, mes, anio, turno, zone);
		
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("consultas/verHorarioAula")
	public ModelAndView verHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		int zone = 0;
		
		ModelAndView mav = verHorario(aula, mes, anio, turno, zone);
		return mav;
	}

	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("consultas/anadirMes")
	public String addMesHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
			
		String zone = "consultas/";
		
		String retorno = sumarMes(aula, mes, anio, turno, zone);
		
		return retorno;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("consultas/restarMes")
	public String restarMesHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
			
		String zone = "consultas/";
		
		String retorno = restarMes(aula, mes, anio, turno, zone);
		
		return retorno;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------

	@GetMapping("consultas/anadirAnio")
	public String addAnioHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		String zone = "consultas/";
		
		String retorno = sumarAnio(aula, mes, anio, turno, zone);
		return retorno;
	}

	//-------------------------------------------------------------------------------------------------------

	@GetMapping("consultas/restarAnio")
	public String restarAnioHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		String zone = "consultas/";
		
		String retorno = restarAnio(aula, mes, anio, turno, zone);
		return retorno;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("consultas/anadirAula")
	public String addAulaHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		String zone = "consultas/";
		
		String retorno = sumarAula(aula, mes, anio, turno, zone);
		return retorno;
	}
	
	//-------------------------------------------------------------------------------------------------------

	@GetMapping("consultas/restarAula")
	public String restarAulaHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		String zone = "consultas/";
		
		String retorno = restarAula(aula, mes, anio, turno, zone);
		return retorno;
	}

	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("consultas/anadirTurno")
	public String addTurnoHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		String zone = "consultas/";
		
		String retorno = sumarTurno(aula, mes, anio, turno, zone);
		return retorno;
	}
	
	//-------------------------------------------------------------------------------------------------------

	@GetMapping("consultas/restarTurno")
	public String restarTurnoHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		String zone = "/consultas";
		
		String retorno = restarTurno(aula, mes, anio, turno, zone);
		return retorno;
	}
	

}
