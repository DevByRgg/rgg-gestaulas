package com.cice.gestaulas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cice.gestaulas.entities.Reserva;

public interface IReservasRepository extends JpaRepository<Reserva, Integer> {

}
