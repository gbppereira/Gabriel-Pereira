package com.paciencia.aulaSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paciencia.aulaSpring.entities.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{

}
