package com.empresa.fichajes.repository;

import com.empresa.fichajes.entity.Fichaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FichajeRepository extends JpaRepository<Fichaje, Long> {
    List<Fichaje> findByUsuarioId(Long usuarioId);
}
