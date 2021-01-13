package com.cice.gestaulas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cice.gestaulas.entities.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);

}
