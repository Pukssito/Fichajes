package com.empresa.fichajes.Dao;

import com.empresa.fichajes.entity.Fichaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FichajeDao extends JpaRepository<Fichaje, Long> {
    List<Fichaje> findByUsuarioId(Long usuarioId);
}
