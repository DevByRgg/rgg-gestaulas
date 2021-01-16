package com.cice.gestaulas.services.interfaces;

import java.util.List;

import com.cice.gestaulas.entities.Usuario;

public interface IUsuarioService {
	
	public void addUsuario(Usuario u);
	public List<Usuario> findAll();
	public Usuario findById(long id);
	public void updateUsuario(Usuario u);
	public void deleteUsuario(long id);

}
