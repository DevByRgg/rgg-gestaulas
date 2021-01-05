package com.cice.gestaulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cice.gestaulas.entities.Reserva;
import com.cice.gestaulas.services.interfaces.IReservaService;

@Controller
public class ReservaShowController {
	
	@Autowired
	IReservaService reservaService;
	
	
	//Metodo que crea el ModelAndview para todos los metodos
	//----------------------------------------------------------------------
	private ModelAndView vistaReserva(List<Reserva> listaReservas) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("reservas", listaReservas);
		mav.setViewName("/reservas/mostrarReserva");
		
		return mav;
	}
	//----------------------------------------------------------------------
	
	@GetMapping("reservas/mostrarReserva")
	public ModelAndView findAll() {
		
		List<Reserva> listaReservas = reservaService.findAll();
		
		ModelAndView mav = vistaReserva(listaReservas);
		
		return mav;
	}
	
	@GetMapping("reservas/orderByIdDes")
	public ModelAndView findAllOrderIdDes() {
		
		List<Reserva> listaReservas = reservaService.findAllByIdDes();
		
		ModelAndView mav = vistaReserva(listaReservas);
		
		return mav;
	}
	
	@GetMapping("reservas/orderByIdAsc")
	public ModelAndView findAllOrderIdAsc() {
		
		List<Reserva> listaReservas = reservaService.findAllByIdAsc();
		
		ModelAndView mav = vistaReserva(listaReservas);
		
		return mav;
	}
	
	@GetMapping("reservas/orderByCursoDes")
	public ModelAndView findAllOrderDes() {
		
		List<Reserva> listaReservas = reservaService.findAllByCursoDes();
		
		ModelAndView mav = vistaReserva(listaReservas);
		
		return mav;
	}
	
	@GetMapping("reservas/orderByCursoAsc")
	public ModelAndView findAllOrderCursoAsc() {
		
		List<Reserva> listaReservas = reservaService.findAllByCursoAsc();
		
		ModelAndView mav = vistaReserva(listaReservas);
		
		return mav;	
	}
	
	@GetMapping("reservas/orderByAulaDes")
	public ModelAndView findAllOrderAulaDes() {
		
		List<Reserva> listaReservas = reservaService.findAllByAulaDes();
		
		ModelAndView mav = vistaReserva(listaReservas);
		
		return mav;
	}
	
	@GetMapping("reservas/orderByAulaAsc")
	public ModelAndView findAllOrderAulaAsc() {
		
		List<Reserva> listaReservas = reservaService.findAllByAulaAsc();
		
		ModelAndView mav = vistaReserva(listaReservas);
		
		return mav;
	}
	
	@GetMapping("reservas/orderByFechaDes")
	public ModelAndView findAllOrderFechaDes() {
		
		List<Reserva> listaReservas = reservaService.findAllByFechaDes();
		
		ModelAndView mav = vistaReserva(listaReservas);
		
		return mav;
	}
	
	@GetMapping("reservas/orderByFechaAsc")
	public ModelAndView findAllOrderFechaAsc() {
		
		List<Reserva> listaReservas = reservaService.findAllByFechaAsc();
		
		ModelAndView mav = vistaReserva(listaReservas);
		
		return mav;
	}

}
