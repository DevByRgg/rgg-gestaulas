package com.cice.gestaulas.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Aula;
import com.cice.gestaulas.entities.Reserva;
import com.cice.gestaulas.entities.auxiliar.ObjetoPresentacion;
import com.cice.gestaulas.repositories.IReservasRepository;
import com.cice.gestaulas.services.interfaces.IAulaService;
import com.cice.gestaulas.services.interfaces.IReservaService;

@Controller
public class ReservaShowController {
	List<Reserva> listaReservas = new ArrayList<Reserva>();
	
	@Autowired
	IReservaService reservaService;
	
	@Autowired
	IAulaService aulaService;
	
	//Metodo que crea el ModelAndview para todos los metodos----------------
	//----------------------------------------------------------------------
	private ModelAndView vistaReserva(List<Reserva> listaReservas, int aula, String curso) {
		ModelAndView mav = new ModelAndView();
		List<ObjetoPresentacion> listaPresentacion = new ArrayList<ObjetoPresentacion>();
		
		List<Aula> listaAulas = aulaService.findAll();
		List<String> listaCursos = reservaService.findAllListaCursos();

		System.out.println("estamos creando la presentacion");
		
		for (int i = 0; i < listaReservas.size(); i++) {
			Reserva r = listaReservas.get(i);
			Aula a = aulaService.findById(r.getIdAula());
			
			ObjetoPresentacion o = new ObjetoPresentacion(r.getId(), r.getNombreCurso(), 
					a.getId(), a.getNombre(), r.getFechaReserva());
		
			listaPresentacion.add(o);
		}
		
		mav.addObject("aulaSeleccionada", aula);
		mav.addObject("cursoSeleccionado", curso);
		mav.addObject("aulas", listaAulas);
		mav.addObject("cursos", listaCursos);
		mav.addObject("reservas", listaPresentacion);
		mav.setViewName("/reservas/mostrarReserva");
		
		return mav;
	}
	
	//Metodo que crea las reservas para todos los metodos-------------------
	//----------------------------------------------------------------------
	private List<Reserva> generarListaReservas(int aula, String curso) {

		listaReservas = reservaService.findAll();
		
		System.out.println("estamos llenando listaReservas");
		System.out.println(aula);
		System.out.println(curso);
		
		if (aula != 0 && curso.equals("aaa")) {
			listaReservas.clear();
			listaReservas = reservaService.findAllByAula(aula);
			System.out.println("estamos llenando listaReservas aula");
		}
		
		if (aula == 0 && !curso.equals("aaa")) {
			listaReservas.clear();
			listaReservas = reservaService.findAllByCurso(curso);
			System.out.println("estamos llenando listaReservas curso");
		}
		
		if (aula != 0 && !curso.equals("aaa")) {
			listaReservas.clear();
			listaReservas = reservaService.findAllByAulaAndCurso(aula, curso);
			System.out.println("estamos llenando listaReservas aula y curso");
		}
		
		System.out.println(listaReservas);
		
		return listaReservas;
	}
	
	//FindAll---------------------------------------------------------------
	//----------------------------------------------------------------------
	
	@GetMapping("reservas/mostrarReserva")
	public ModelAndView findAll(
			@RequestParam (name = "idAula", defaultValue = "0", required = true) int idAula,
			@RequestParam (name = "nombreCurso", defaultValue = "aaa", required = true) String nombreCurso) {	
		
		System.out.println("estamos en mostarReservas");	
		
		listaReservas = generarListaReservas(idAula, nombreCurso);
		
		ModelAndView mav = vistaReserva(listaReservas, idAula, nombreCurso);
		
		return mav;
	}

	//FindAll---------------------------------------------------------------
	//----------------------------------------------------------------------
	
	@GetMapping("reservas/filtrarReserva")
	public ModelAndView ApplyFilters(
		@RequestParam (name = "idAula", defaultValue = "0", required = true) int idAula,
		@RequestParam (name = "nombreCurso", defaultValue = "aaa", required = true) String nombreCurso) {		
		
		System.out.println("estamos en filtrarReservas");
		
		listaReservas = generarListaReservas(idAula, nombreCurso);
		
		ModelAndView mav = vistaReserva(listaReservas, idAula, nombreCurso);
		
		return mav;
	}
	
	//Ordenar Id------------------------------------------------------------
	//----------------------------------------------------------------------

	@GetMapping("reservas/orderByIdDes")
	public ModelAndView findAllOrderIdDes(
			@RequestParam (name = "idAula", defaultValue = "0", required = true) int idAula,
			@RequestParam (name = "nombreCurso", defaultValue = "aaa", required = true) String nombreCurso) {
		
		System.out.println("estamos en Iddes");
		listaReservas = generarListaReservas(idAula, nombreCurso);
		
		Collections.sort(listaReservas, new Comparator<Reserva>() {
			@Override
			public int compare(Reserva o1, Reserva o2) {
				return o2.getId() - o1.getId();
			}
		});

		ModelAndView mav = vistaReserva(listaReservas, idAula, nombreCurso);
		
		return mav;
	}
	
	@GetMapping("reservas/orderByIdAsc")
	public ModelAndView findAllOrderIdAsc(
			@RequestParam (name = "idAula", defaultValue = "0", required = true) int idAula,
			@RequestParam (name = "nombreCurso", defaultValue = "aaa", required = true) String nombreCurso) {
	
		System.out.println("estamos en IdAsc");
		listaReservas = generarListaReservas(idAula, nombreCurso);
	
		Collections.sort(listaReservas, new Comparator<Reserva>() {
			@Override
			public int compare(Reserva o1, Reserva o2) {
				return o1.getId() - o2.getId();
			}	
		});

		ModelAndView mav = vistaReserva(listaReservas, idAula, nombreCurso);
	
		return mav;
	}

	//Ordenar Curso---------------------------------------------------------
	//----------------------------------------------------------------------

	@GetMapping("reservas/orderByCursoDes")
	public ModelAndView findAllOrderCursoDes(
			@RequestParam (name = "idAula", defaultValue = "0", required = true) int idAula,
			@RequestParam (name = "nombreCurso", defaultValue = "aaa", required = true) String nombreCurso) {
		
		System.out.println("estamos en Cursodes");
		listaReservas = generarListaReservas(idAula, nombreCurso);
		
		Collections.sort(listaReservas, new Comparator<Reserva>() {
			@Override
			public int compare(Reserva o1, Reserva o2) {
				return o2.getNombreCurso().toLowerCase().compareTo(o1.getNombreCurso().toLowerCase());
			}
		});

		ModelAndView mav = vistaReserva(listaReservas, idAula, nombreCurso);
		
		return mav;
	}

	@GetMapping("reservas/orderByCursoAsc")
	public ModelAndView findAllOrderCursoAsc(
			@RequestParam (name = "idAula", defaultValue = "0", required = true) int idAula,
			@RequestParam (name = "nombreCurso", defaultValue = "aaa", required = true) String nombreCurso) {
		
		System.out.println("estamos en CursoAsc");
		listaReservas = generarListaReservas(idAula, nombreCurso);
		
		Collections.sort(listaReservas, new Comparator<Reserva>() {
			@Override
			public int compare(Reserva o1, Reserva o2) {
				return o1.getNombreCurso().toLowerCase().compareTo(o2.getNombreCurso().toLowerCase());
			}
		});

		ModelAndView mav = vistaReserva(listaReservas, idAula, nombreCurso);
		
		return mav;
	}

	//Ordenar Aulas---------------------------------------------------------
	//----------------------------------------------------------------------

	@GetMapping("reservas/orderByAulaDes")
	public ModelAndView findAllOrderAulaDes(
			@RequestParam (name = "idAula", defaultValue = "0", required = true) int idAula,
			@RequestParam (name = "nombreCurso", defaultValue = "aaa", required = true) String nombreCurso) {
	
		System.out.println("estamos en Aulades");
		listaReservas = generarListaReservas(idAula, nombreCurso);
	
		Collections.sort(listaReservas, new Comparator<Reserva>() {
			@Override
			public int compare(Reserva o1, Reserva o2) {
				return o2.getIdAula() - o1.getIdAula();
			}
		});
		
		ModelAndView mav = vistaReserva(listaReservas, idAula, nombreCurso);
	
		return mav;
	}
	
	@GetMapping("reservas/orderByAulaAsc")
	public ModelAndView findAllOrderAulaAsc(
			@RequestParam (name = "idAula", defaultValue = "0", required = true) int idAula,
			@RequestParam (name = "nombreCurso", defaultValue = "aaa", required = true) String nombreCurso) {
	
		System.out.println("estamos en AulaAsc");
		listaReservas = generarListaReservas(idAula, nombreCurso);
	
		Collections.sort(listaReservas, new Comparator<Reserva>() {
			@Override
			public int compare(Reserva o1, Reserva o2) {
				return o1.getIdAula() - o2.getIdAula();
			}
		});
		
		ModelAndView mav = vistaReserva(listaReservas, idAula, nombreCurso);
	
		return mav;
	}

	//Ordenar Fechas--------------------------------------------------------
	//----------------------------------------------------------------------
	
	@GetMapping("reservas/orderByFechaDes")
	public ModelAndView findAllOrderFechaDes(
			@RequestParam (name = "idAula", defaultValue = "0", required = true) int idAula,
			@RequestParam (name = "nombreCurso", defaultValue = "aaa", required = true) String nombreCurso) {
	
		System.out.println("estamos en fechades");
		listaReservas = generarListaReservas(idAula, nombreCurso);
	
		Collections.sort(listaReservas, new Comparator<Reserva>() {
		@Override
			public int compare(Reserva o1, Reserva o2) {
				return o2.getFechaReserva().compareTo(o1.getFechaReserva());
			}
		});
		
		ModelAndView mav = vistaReserva(listaReservas, idAula, nombreCurso);
	
		return mav;
	}
	
	@GetMapping("reservas/orderByFechaAsc")
	public ModelAndView findAllOrderFechaAsc(
			@RequestParam (name = "idAula", defaultValue = "0", required = true) int idAula,
			@RequestParam (name = "nombreCurso", defaultValue = "aaa", required = true) String nombreCurso) {
	
		System.out.println("estamos en fechaAsc");
		listaReservas = generarListaReservas(idAula, nombreCurso);
	
		Collections.sort(listaReservas, new Comparator<Reserva>() {
			
			@Override
			public int compare(Reserva o1, Reserva o2) {
				return o1.getFechaReserva().compareTo(o2.getFechaReserva());
			}
		});
	
		ModelAndView mav = vistaReserva(listaReservas, idAula, nombreCurso);
	
		return mav;
	}

	
}
