package com.empresa.fichajes.Dao;

import com.empresa.fichajes.entity.Fichaje;
import com.empresa.fichajes.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FichajeDao extends JpaRepository<Fichaje, Integer> {

    List<Fichaje> obtenerFichajesPorEmail(String email);
    Usuario findByUsuarioId(Integer usuarioId);
    void deleteById(Integer id);
}
