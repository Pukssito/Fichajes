package com.empresa.fichajes.DaoImpl;

import com.empresa.fichajes.Dao.FichajeDao;
import com.empresa.fichajes.entity.Fichaje;
import com.empresa.fichajes.entity.Usuario;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FichajeDaoImpl implements FichajeDao  {

    @Autowired
    private EntityManager em;



    @Override
    public List<Fichaje> obtenerFichajesPorEmail(String email) {
        String jpql = "SELECT f FROM Fichaje f WHERE f.usuario.email = :email ORDER BY f.fechaHora DESC";
        return em.createQuery(jpql, Fichaje.class)
                .setParameter("email", email)
                .getResultList();
    }

    @Override
    public Usuario findByUsuarioId(Integer id) {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.id = :id", Usuario.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Fichaje save(Fichaje fichaje) {
        return null;
    }
}
