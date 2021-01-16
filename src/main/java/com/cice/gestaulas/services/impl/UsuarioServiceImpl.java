package com.cice.gestaulas.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cice.gestaulas.entities.Usuario;
import com.cice.gestaulas.repositories.IUsuarioRepository;
import com.cice.gestaulas.services.interfaces.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	IUsuarioRepository usuarioRepository;

	@Override
	public void addUsuario(Usuario u) {
		usuarioRepository.save(u);		
	}

	@Override
	public List<Usuario> findAll() {	
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = (List<Usuario>) usuarioRepository.findAll();		
		return usuarios;
	}

	@Override
	public Usuario findById(long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public void updateUsuario(Usuario u) {
		usuarioRepository.save(u);
	}
	
	@Override
	public void deleteUsuario(long numero) {
		usuarioRepository.deleteById(numero);		
	}

	
}
