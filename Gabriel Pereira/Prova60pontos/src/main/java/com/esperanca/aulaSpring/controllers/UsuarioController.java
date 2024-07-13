package com.paciencia.aulaSpring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paciencia.aulaSpring.entities.Usuario;
import com.paciencia.aulaSpring.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity< List<Usuario>> procurarTodos() {
		List<Usuario> listaDeUsuario = service.procurarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(listaDeUsuario);
	}
	
	@GetMapping(value = "/{id}")
	public Usuario procurarPorId(@PathVariable Integer id) {
		Usuario response = service.procurarPorId(id);
		return response;
	}
	
	@PostMapping
	public ResponseEntity <String> adicionaUsuario(@RequestBody Usuario usuario) {
		String response = service.adicionaUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping(value = "/{id}")
	public String editarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
		String response = service.editaUsuario(id, usuario);
		return response;
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity <Void> excluirUsuario (@PathVariable Integer id) {
		service.excluirUsuario(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	
	

}
