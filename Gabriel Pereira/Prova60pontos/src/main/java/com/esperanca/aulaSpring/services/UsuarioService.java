package com.paciencia.aulaSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paciencia.aulaSpring.entities.Usuario;

import com.paciencia.aulaSpring.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> procurarTodos() {
		repository.findAll();
		return repository.findAll();
	}
	
	public Usuario procurarPorId(Integer id) {
		return repository.findById(id)
				.orElseThrow();
		
	}
	
	public String adicionaUsuario(Usuario usuario) {
		repository.save(usuario);
		return "Usuario inserido com sucesso!!";
	}
	
	public String editaUsuario(Integer id, Usuario usuario) {
		Usuario response = repository.findById(id).get();
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setSenha(usuario.getSenha());
		repository.save(response);
		return "Usuaruio editado som sucesso!!";
	}
	
	public void excluirUsuario(Integer id) {
		Usuario response = repository.findById(id).get();
	}

}
