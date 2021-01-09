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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Reserva;
import com.cice.gestaulas.entities.Sede;
import com.cice.gestaulas.entities.TipoAula;
import com.cice.gestaulas.entities.auxiliar.ObjetoPresentacion;
import com.cice.gestaulas.services.interfaces.IAulaService;
import com.cice.gestaulas.services.interfaces.IFestivoService;
import com.cice.gestaulas.services.interfaces.IReservaService;
import com.cice.gestaulas.services.interfaces.ISedeService;
import com.cice.gestaulas.services.interfaces.ITipoAulaService;


@Controller
public class ConsultaHomeController {
	
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
	
	
	//Metodo que crea el ModelAndview para todos los metodos
	//-------------------------------------------------------------------------------------------------------
	private ModelAndView consultaAulas (List<Aula> aulasDisponibles, int sedeSeleccionada, 
			int tipoSeleccionado, int mesSeleccionado, int anioSeleccionado, 
			int turnoSeleccionado) {
		
		ModelAndView mav = new ModelAndView();
		List<ObjetoPresentacion> listaAulasDisponibles = new ArrayList<ObjetoPresentacion>();
		
		List<Sede> listaSedes = sedeService.findAll();
		List<Aula> listaAulas = aulaService.findAll();
		List<TipoAula> listaTipoAulas = tipoAulaService.findAll();
		
		Map<Integer, Integer> listaAnios = new HashMap<Integer, Integer>();
		for (int i = 0; i < 5; i++) {
			listaAnios.put(i, LocalDate.now().plusYears(i).getYear());
		}
		
		Map<Integer, String> listaMeses = new HashMap<Integer, String>();
		for (int i = 1; i < 13; i++) {
			listaMeses.put(i, Month.of(i).getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
		}
		
		mav.addObject("sedes", listaSedes);
		mav.addObject("aulas", listaAulas);
		mav.addObject("tipoAulas", listaTipoAulas);
		mav.addObject("anios", listaAnios);
		mav.addObject("meses", listaMeses);
		
		mav.addObject("sedeSeleccionada", sedeSeleccionada);
		mav.addObject("tipoSeleccionado", tipoSeleccionado);
		mav.addObject("mesSeleccionado", mesSeleccionado);
		mav.addObject("anioSeleccionado", anioSeleccionado);
		mav.addObject("turnoSeleccionado", turnoSeleccionado);
		//------------------------------------------------------------------------------------------------------
		
		for (int i = 0; i < aulasDisponibles.size(); i++) {
			Aula a = aulasDisponibles.get(i);
			Sede s = sedeService.findById(a.getSede());
			TipoAula t = tipoAulaService.findById(a.getTipo());
			
			ObjetoPresentacion obj = new ObjetoPresentacion(a.getId(), a.getNombre(), s.getId(),
					s.getNombre(), t.getId(), t.getNombre());
			
			listaAulasDisponibles.add(obj);
		}
		
		mav.addObject("aulasDisponibles", listaAulasDisponibles);
		
		mav.setViewName("consultas/buscarAula");
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("consultas/consultarAulasDisponibles")
	public ModelAndView buscarAulaPage() {
		
		List<Aula> aulas = new ArrayList<Aula>();
		
		ModelAndView mav = consultaAulas(aulas, -1, -1, -1, -1, -1);
		
		return mav;
		
	}
	
	
	@GetMapping("consultas/filtrarAulasDisponibles")
	public ModelAndView elegirAulaPage(
		@RequestParam (name="sede") int sede,
		@RequestParam (name="tipo") int tipo,
		@RequestParam (name="mes") int mes,
		@RequestParam (name="anio") int anio,
		@RequestParam (name="turno") int turno) {
		
		List<Aula> listaAulas = aulaService.findAll();
		
		if (tipo != -1 && sede == -1) {
			listaAulas.clear();
			listaAulas = aulaService.findByTipo(tipo);
		}
		
		if (tipo == -1 && sede != -1) {
			listaAulas.clear();
			listaAulas = aulaService.findBySede(sede);
		}
		
		if (tipo != -1 && sede != -1){
			listaAulas.clear();
			listaAulas = aulaService.findBySedeAndTipo(sede, tipo);
		}

		ModelAndView mav = consultaAulas(listaAulas, sede, tipo, mes, anio, turno);
		
		return mav;
	}
	
	@GetMapping("consultas/verHorarioAula")
	public ModelAndView verHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		
		List<ObjetoPresentacion> listaObj= new ArrayList<ObjetoPresentacion>();
		List<LocalDate> listaFechas = new ArrayList<LocalDate>();
		List<LocalTime> listaHoras = new ArrayList<LocalTime>();
		List<LocalDateTime> listaFechasHoras = new ArrayList<LocalDateTime>();
		
		int numDiasMes = LocalDate.of(anio, mes, 1).lengthOfMonth();
		String mesTexto = Month.of(mes).getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		String aulaTexto = aulaService.findById(aula).getNombre();
		String turnoTexto;
		
		if (turno == 1) {turnoTexto = "Mañana";} 
		else if (turno == 2) {turnoTexto = "Tarde";}
		else {turnoTexto = "Ambos";}
		
		for (int i = 0; i < 6; i++) {
			listaHoras.add(LocalTime.of(9 + i, 0));
		}
		for (int i = 0; i < 6; i++) {
			listaHoras.add(LocalTime.of(17 + i, 0));
		}
		
		for (int i = 1; i <= numDiasMes; i++) {
			listaFechas.add(LocalDate.of(anio, mes, i));
		}
		
		List<Reserva> listaReservasAula = reservaService.findAllByAula(aula);
		List<LocalDateTime> listaFechasReservas = new ArrayList<LocalDateTime>();
		
		for (int i = 0; i < listaReservasAula.size(); i++) {
			int mesReserva = listaReservasAula.get(i).getFechaReserva().getMonthValue();
			int anioReserva = listaReservasAula.get(i).getFechaReserva().getYear();
			
			if (mesReserva == mes && anio == anioReserva) {
				listaFechasReservas.add(listaReservasAula.get(i).getFechaReserva());
			}	
		}
		
		for (int i = 0; i < listaFechas.size(); i++) {
			LocalDate dia = listaFechas.get(i);
			List<Integer> horasBoleano = new ArrayList<Integer>(); 
			int diaSemana = dia.getDayOfWeek().getValue();
			
			for (int j = 0; j < listaHoras.size(); j++) {
				LocalTime hora = listaHoras.get(j);
				LocalDateTime fechaHora = LocalDateTime.of(dia, hora);
				boolean festivo = festivoService.findAllFechas().contains(dia);
				
				if(diaSemana != 7 && !festivo) {
					if (listaFechasReservas.contains(fechaHora)) {
						horasBoleano.add(1);
					} else {
						horasBoleano.add(2);
					}	
				} else {
					horasBoleano.add(0);
				}
			}
			
			String diaReserva = dia.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			
			ObjetoPresentacion obj = new ObjetoPresentacion(diaReserva, horasBoleano.get(0),
					horasBoleano.get(1), horasBoleano.get(2), horasBoleano.get(3), horasBoleano.get(4),
					horasBoleano.get(5), horasBoleano.get(6), horasBoleano.get(7), horasBoleano.get(8),
					horasBoleano.get(9), horasBoleano.get(10), horasBoleano.get(11));
			
			listaObj.add(obj);
		}
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("mes", mes);
		mav.addObject("anio", anio);
		mav.addObject("turno", turno);
		mav.addObject("aula", aula);
		mav.addObject("mesTexto", mesTexto);
		mav.addObject("aulaTexto", aulaTexto);
		mav.addObject("turnoTexto", turnoTexto);
		
		mav.addObject("horasDisponibles", listaObj);
		
		mav.setViewName("consultas/verHorario");

		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("consultas/anadirMes")
	public String addMesHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
			
		int nextMes = mes + 1;
		int	nextAnio = anio;
			
		if (nextMes == 13 ) {
			nextMes = 1;
			nextAnio = anio + 1;
		}	
			
		return "redirect:/consultas/verHorarioAula?mes=" + nextMes + "&anio=" + nextAnio +
				"&turno=" + turno + "&aula=" + aula;
	}

	//-------------------------------------------------------------------------------------------------------

	@GetMapping("consultas/restarMes")
	public String restarMesHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
			
		int antMes = mes - 1;
		int	antAnio = anio;
			
		if (antMes == 0 ) {
			antMes = 12;
			antAnio = anio - 1;
				
		}
		
		return "redirect:/consultas/verHorarioAula?mes=" + antMes + "&anio=" + antAnio +
				"&turno=" + turno + "&aula=" + aula;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
	@GetMapping("consultas/anadirAnio")
	public String addAnioHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		
		int	nextAnio = anio + 1;
		
		
		return "redirect:/consultas/verHorarioAula?mes=" + mes + "&anio=" + nextAnio +
					"&turno=" + turno + "&aula=" + aula;
	}

	//-------------------------------------------------------------------------------------------------------

	@GetMapping("consultas/restarAnio")
	public String restarAnioHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		
		int	antAnio = anio - 1;
		
		return "redirect:/consultas/verHorarioAula?mes=" + mes + "&anio=" + antAnio +
				"&turno=" + turno + "&aula=" + aula;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------

	@GetMapping("consultas/anadirAula")
	public String addAulaHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		
		Aula a = aulaService.findById(aula);
		
		List<Aula> listaAulas = aulaService.findAll();
		List<Integer> listaIdsAulas = new ArrayList<Integer>();
		int indiceAula = -10;
		
		for (int i = 0; i < listaAulas.size(); i++) {
			listaIdsAulas.add(listaAulas.get(i).getId());
		}
		
		for (int i = 0; i < listaIdsAulas.size(); i++) {
			indiceAula = i;
			if (a.getId() == listaIdsAulas.get(i)) {
				break;
				}
		}
		
		int nextIndice = indiceAula + 1;
		
		if (nextIndice >= listaIdsAulas.size()) {nextIndice = 0;}
		
		int nextAula = listaIdsAulas.get(nextIndice);

		return "redirect:/consultas/verHorarioAula?mes=" + mes + "&anio=" + anio +
				"&turno=" + turno + "&aula=" + nextAula;
	}
	
	//-------------------------------------------------------------------------------------------------------

	@GetMapping("consultas/restarAula")
	public String restarAulaHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		
		Aula a = aulaService.findById(aula);
		
		List<Aula> listaAulas = aulaService.findAll();
		List<Integer> listaIdsAulas = new ArrayList<Integer>();
		int indiceAula = -10;
		
		for (int i = 0; i < listaAulas.size(); i++) {
			listaIdsAulas.add(listaAulas.get(i).getId());
		}
		
		for (int i = 0; i < listaIdsAulas.size(); i++) {
			indiceAula = i;
			if (a.getId() == listaIdsAulas.get(i)) {
				break;
				}
		}
		
		System.out.println(indiceAula);

		int nextIndice = indiceAula - 1;
		
		System.out.println(nextIndice);
		
		if (nextIndice < 0) {nextIndice = listaIdsAulas.size() -1;}
		
		int antAula = listaIdsAulas.get(nextIndice);
		
		return "redirect:/consultas/verHorarioAula?mes=" + mes + "&anio=" + anio +
				"&turno=" + turno + "&aula=" + antAula;
	}

	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------

	@GetMapping("consultas/anadirTurno")
	public String addTurnoHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		
		int nextTurno = turno + 1;
		
		if (nextTurno == 3) {nextTurno = 0;}
		
		return "redirect:/consultas/verHorarioAula?mes=" + mes + "&anio=" + anio +
				"&turno=" + nextTurno + "&aula=" + aula;
	}

	//-------------------------------------------------------------------------------------------------------

	@GetMapping("consultas/restarTurno")
	public String restarTurnoHorarioPage(
			@RequestParam (name = "aula") int aula,
			@RequestParam (name = "mes") int mes,
			@RequestParam (name = "anio") int anio,
			@RequestParam (name = "turno") int turno) {
		
		int antTurno = turno - 1;
		
		if (antTurno == -1) {antTurno = 2;}
		
		return "redirect:/consultas/verHorarioAula?mes=" + mes + "&anio=" + anio +
				"&turno=" + antTurno + "&aula=" + aula;
	}
	
}
