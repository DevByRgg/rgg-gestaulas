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

/**
 * Controller auxiliar
 * Facilita los métodos necesarios para realizar las consultas en la aplicación
 *
 */

@Secured("ROLE_USER")
public class ConsultaAuxiliarController {
	
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
	protected ModelAndView consultaAulas (List<Aula> aulasDisponibles, int sedeSeleccionada, 
			int tipoSeleccionado, int mesSeleccionado, int anioSeleccionado, 
			int turnoSeleccionado, int zone) {
		
		
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
		
		mav.addObject("zone", zone);
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
	//-------------------------------------------------------------------------------------------------------
	
	protected List<Aula> elegirAula(int sede, int tipo, int mes, int anio, int turno) {
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
		
		return listaAulas;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------

	/**
	 * Generar el horario
	 * @param aula id del aula
	 * @param mes mes a generar
	 * @param anio año a generar
	 * @param turno turno a generar
	 * @param zone de tipo entero 0 si es llamado desde administración y 1 si es desde público
	 * @return ModelAndView con el horario 
	 */
	protected ModelAndView verHorario(int aula, int mes, int anio, int turno, int zone) {
		String mesTexto = Month.of(mes).getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		String aulaTexto = aulaService.findById(aula).getNombre();
		String turnoTexto;
		
		if (turno == 1) {turnoTexto = "Mañana";} 
		else if (turno == 2) {turnoTexto = "Tarde";}
		else {turnoTexto = "Todos";}
		
		List<ObjetoPresentacion> listaObj= new ArrayList<ObjetoPresentacion>();
		List<LocalDate> listaFechas = new ArrayList<LocalDate>();
		List<LocalTime> listaHoras = new ArrayList<LocalTime>();
		//List<LocalDateTime> listaFechasHoras = new ArrayList<LocalDateTime>();
		
		int numDiasMes = LocalDate.of(anio, mes, 1).lengthOfMonth();
		
		for (int i = 0; i < 6; i++) {
			listaHoras.add(LocalTime.of(9 + i, 0));
		}
		for (int i = 0; i < 6; i++) {
			listaHoras.add(LocalTime.of(17 + i, 0));
		}
		
		for (int i = 1; i <= numDiasMes; i++) {
			listaFechas.add(LocalDate.of(anio, mes, i));
		}
		
		//
		List<Reserva> listaReservasAula = reservaService.findAllByAula(aula);
		
		
		List<LocalDateTime> listaFechasReservas = new ArrayList<LocalDateTime>();
		
		List<String> nombresCurso = new ArrayList<String>();
		
		for (int i = 0; i < listaReservasAula.size(); i++) {
			
			//coger el nombre del curso
			String nombreCurso =  listaReservasAula.get(i).getNombreCurso();
			nombresCurso.add(nombreCurso);
			
			//guardarlo en el model and view ("nombreCurso")
			
			int mesReserva = listaReservasAula.get(i).getFechaReserva().getMonthValue();
			int anioReserva = listaReservasAula.get(i).getFechaReserva().getYear();
			
			if (mesReserva == mes && anio == anioReserva) {
				listaFechasReservas.add(listaReservasAula.get(i).getFechaReserva());
			}	
		}
		
		for (int i = 0; i < listaFechas.size(); i++) {
			LocalDate dia = listaFechas.get(i);
			List<Integer> horasColores = new ArrayList<Integer>(); 
			int diaSemana = dia.getDayOfWeek().getValue();
			
			for (int j = 0; j < listaHoras.size(); j++) {
				LocalTime hora = listaHoras.get(j);
				LocalDateTime fechaHora = LocalDateTime.of(dia, hora);
				boolean festivo = festivoService.findAllFechas().contains(dia);
				
				if(diaSemana != 7 && !festivo) {
					if (listaFechasReservas.contains(fechaHora)) {
						horasColores.add(1); //color rojo ocupado
						
					} else {
						horasColores.add(2); // verde libre
					}	
				} else {
					horasColores.add(0); //color gris
				}
			}
			
			String diaReserva = dia.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			
			ObjetoPresentacion obj = new ObjetoPresentacion(diaReserva, horasColores.get(0),
					horasColores.get(1), horasColores.get(2), horasColores.get(3), horasColores.get(4),
					horasColores.get(5), horasColores.get(6), horasColores.get(7), horasColores.get(8),
					horasColores.get(9), horasColores.get(10), horasColores.get(11));
			
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
		mav.addObject("zone", zone);
		
		mav.addObject("horasDisponibles", listaObj);
		
		mav.setViewName("consultas/verHorario");
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------

	protected String sumarMes(int aula, int mes, int anio, int turno, String zone) {
		int nextMes = mes + 1;
		int	nextAnio = anio;
			
		if (nextMes == 13 ) {
			nextMes = 1;
			nextAnio = anio + 1;
		}	

		String retorno = "redirect:/" + zone + "verHorarioAula?mes=" + nextMes + "&anio=" + nextAnio +
				"&turno=" + turno + "&aula=" + aula;
		
		return retorno;
	}

	//-------------------------------------------------------------------------------------------------------

	protected String restarMes(int aula, int mes, int anio, int turno, String zone) {
		int antMes = mes - 1;
		int	antAnio = anio;
			
		if (antMes == 0 ) {
			antMes = 12;
			antAnio = anio - 1;
		}
		
		String retorno = "redirect:/" + zone + "verHorarioAula?mes=" + antMes + "&anio=" + antAnio +
				"&turno=" + turno + "&aula=" + aula;
		
		return retorno;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
	protected String sumarAnio(int aula, int mes, int anio, int turno, String zone) {
		int	nextAnio = anio + 1;
		
		String retorno = "redirect:/" + zone + "verHorarioAula?mes=" + mes + "&anio=" + nextAnio +
				"&turno=" + turno + "&aula=" + aula;
		
		return retorno;
	}

	//-------------------------------------------------------------------------------------------------------

	protected String restarAnio(int aula, int mes, int anio, int turno, String zone) {
		int	antAnio = anio - 1;
		
		String retorno = "redirect:/" + zone + "verHorarioAula?mes=" + mes + "&anio=" + antAnio +
				"&turno=" + turno + "&aula=" + aula;
		
		return retorno;
	}

	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------

	protected String sumarAula(int aula, int mes, int anio, int turno, String zone) {
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

		String retorno = "redirect:/" + zone + "verHorarioAula?mes=" + mes + "&anio=" + anio +
				"&turno=" + turno + "&aula=" + nextAula;
		return retorno;
	}
	
	//-------------------------------------------------------------------------------------------------------

	protected String restarAula(int aula, int mes, int anio, int turno, String zone) {
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

		int nextIndice = indiceAula - 1;
		
		if (nextIndice < 0) {nextIndice = listaIdsAulas.size() -1;}
		
		int antAula = listaIdsAulas.get(nextIndice);
		
		String retorno = "redirect:/" + zone + "verHorarioAula?mes=" + mes + "&anio=" + anio +
				"&turno=" + turno + "&aula=" + antAula;
		return retorno;
	}

	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------

	protected String sumarTurno(int aula, int mes, int anio, int turno, String zone) {
		int nextTurno = turno + 1;
		
		if (nextTurno == 3) {nextTurno = 0;}
		
		String retorno = "redirect:/" + zone + "verHorarioAula?mes=" + mes + "&anio=" + anio +
				"&turno=" + nextTurno + "&aula=" + aula;
		return retorno;
	}

	//-------------------------------------------------------------------------------------------------------

	protected String restarTurno(int aula, int mes, int anio, int turno, String zone) {
		
		int antTurno = turno - 1;
		
		if (antTurno == -1) {antTurno = 2;}
		
		String retorno = "redirect:/" + zone + "verHorarioAula?mes=" + mes + "&anio=" + anio +
				"&turno=" + antTurno + "&aula=" + aula;
		return retorno;
	}
	
	
}
