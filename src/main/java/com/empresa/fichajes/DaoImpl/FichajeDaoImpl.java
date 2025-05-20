package com.empresa.fichajes.DaoImpl;

import com.empresa.fichajes.Dao.FichajeDao;
import com.empresa.fichajes.entity.Fichaje;
import com.empresa.fichajes.entity.Usuario;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class FichajeDaoImpl implements FichajeDao  {

    @Autowired
    private EntityManager em;

    @Autowired
    private FichajeDao fichajeDao;

    @Override
    public List<Fichaje> obtenerFichajesPorEmail(String email) {
        String jpql = "SELECT f FROM Fichaje f WHERE f.usuario.email = :email ORDER BY f.fechaHora DESC";
        return em.createQuery(jpql, Fichaje.class)
                .setParameter("email", email)
                .getResultList();
    }

    @Override
    public Usuario findByUsuarioId(Integer id) {
        return fichajeDao.findByUsuarioId(id);

    }
    @Override
    public void deleteById(Integer id) {
        fichajeDao.deleteById(id);
    }
}
