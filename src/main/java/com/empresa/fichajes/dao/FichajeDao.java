package com.empresa.fichajes.dao;

import com.empresa.fichajes.entity.Fichaje;
import com.empresa.fichajes.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FichajeDao {

    List<Fichaje> obtenerFichajesPorEmail(String email);
    Usuario findByUsuarioId(Integer usuarioId);
    Fichaje save(Fichaje fichaje);
}
