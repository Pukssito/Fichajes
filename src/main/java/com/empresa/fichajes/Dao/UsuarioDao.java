package com.empresa.fichajes.Dao;

import com.empresa.fichajes.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);
}
