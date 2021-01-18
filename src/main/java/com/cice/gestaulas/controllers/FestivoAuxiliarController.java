package com.cice.gestaulas.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.cice.gestaulas.entities.Reserva;
import com.cice.gestaulas.exceptions.FestivoExisteException;
import com.cice.gestaulas.services.interfaces.IReservaService;


public class FestivoAuxiliarController{
	
	@Autowired
	IReservaService reservaService;
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------

	protected void validarReservas(LocalDate fecha) throws FestivoExisteException{
		List<Reserva> listaReservas = reservaService.findAll();
		List<LocalDate> listaFechas = new ArrayList<LocalDate>();
		
		for (int i = 0; i < listaReservas.size(); i++) {
			listaFechas.add(listaReservas.get(i).getFechaReserva().toLocalDate());
		}
		System.out.println("antes " + listaFechas.size());
		
		List<LocalDate> lista= listaFechas.stream().distinct().collect(Collectors.toList());

		System.out.println("despues" + lista.size());
		
		boolean existe = listaFechas.contains(fecha);
			
		if (existe) {
			throw new FestivoExisteException("No se puede crear el festivo, tienes reservas en esa fecha");
		}
		
	}
		
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	
}
