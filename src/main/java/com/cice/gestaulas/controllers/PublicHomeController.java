package com.cice.gestaulas.controllers;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Reserva;
import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.entities.auxiliar.ObjetoPresentacion;
import com.cice.gestaulas.entities.auxiliar.TipoAula;
import com.cice.gestaulas.services.interfaces.IAulaService;
import com.cice.gestaulas.services.interfaces.IFestivoService;
import com.cice.gestaulas.services.interfaces.IReservaService;
import com.cice.gestaulas.services.interfaces.ISedeService;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;

@Secured("ROLE_USER")
@Controller
public class PublicHomeController extends ConsultaAuxiliarController{

	@Autowired
	ISedeService sedeService;
	
	@Autowired
	IAulaService aulaService;
	
	@Autowired
	ITipoAulaService tipoAulaService;
	
	@Autowired
	IReservaService reservaService;
	
	@Autowired
	IFestivoService festivoService;
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
		
	@GetMapping("/")
	public ModelAndView mostrarHomePage() {
		int zone = 1;
		List<Aula> aulas = new ArrayList<Aula>();
		
		ModelAndView mav = consultaAulas(aulas, -1, -1, -1, -1, 0, zone);
		
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("/filtrarAulasDisponibles")
	public ModelAndView elegirAulaPage(
		@RequestParam (name="sede") int sede,
		@RequestParam (name="tipo") int tipo,
		@RequestParam (name="mes") int mes,
		@RequestParam (name="anio") int anio,
		@RequestParam (name="turno") int turno) {
		int zone = 1;
		List<Aula> listaAulas = elegirAula(sede, tipo, mes, anio, turno);


		ModelAndView mav = consultaAulas(listaAulas, sede, tipo, mes, anio, turno, zone);
		
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("/verHorarioAula")
	public ModelAndView verHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		int zone = 1;
		
		ModelAndView mav = verHorario(aula, mes, anio, turno, zone);
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("anadirMes")
	public String addMesHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		String zone = "";
		String retorno = sumarMes(aula, mes, anio, turno, zone);
		
		return retorno;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("restarMes")
	public String restarMesHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
			
		String zone = "";
		
		String retorno = restarMes(aula, mes, anio, turno, zone);
		
		return retorno;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------

	@GetMapping("anadirAnio")
	public String addAnioHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		String zone = "";
		
		String retorno = sumarAnio(aula, mes, anio, turno, zone);
		return retorno;
	}

	//-------------------------------------------------------------------------------------------------------

	@GetMapping("restarAnio")
	public String restarAnioHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		String zone = "";
		
		String retorno = restarAnio(aula, mes, anio, turno, zone);
		return retorno;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("anadirAula")
	public String addAulaHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		String zone = "";
		
		String retorno = sumarAula(aula, mes, anio, turno, zone);
		return retorno;
	}
	
	//-------------------------------------------------------------------------------------------------------

	@GetMapping("restarAula")
	public String restarAulaHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		String zone = "";
		
		String retorno = restarAula(aula, mes, anio, turno, zone);
		return retorno;
	}

	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("anadirTurno")
	public String addTurnoHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		String zone = "";
		
		String retorno = sumarTurno(aula, mes, anio, turno, zone);
		return retorno;
	}
	
	//-------------------------------------------------------------------------------------------------------

	@GetMapping("restarTurno")
	public String restarTurnoHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		String zone = "";
		
		String retorno = restarTurno(aula, mes, anio, turno, zone);
		return retorno;
	}
}
