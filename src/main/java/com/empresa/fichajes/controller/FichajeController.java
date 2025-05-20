package com.empresa.fichajes.controller;

import com.empresa.fichajes.entity.Fichaje;
import com.empresa.fichajes.Dao.FichajeDao;
import com.empresa.fichajes.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/fichajes")
public class FichajeController {

    @Autowired
    private FichajeDao fichajeDao;

    @PostMapping("/fichar")
    public Fichaje fichar(@RequestBody Fichaje fichaje) {
        fichaje.setFechaHora(ZonedDateTime.now(ZoneId.of("Europe/Madrid")).toLocalDateTime());
        return fichajeDao.save(fichaje);
    }

    @GetMapping("/usuario/{id}")
    public Usuario getFichajesPorUsuario(@PathVariable Integer id) {
        return fichajeDao.findByUsuarioId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFichaje(@PathVariable Integer id) {
        fichajeDao.deleteById(id);
    }

    @GetMapping("/email/{email}")
    public List<Fichaje> getFichajesPorEmail(@PathVariable String email) {
        return fichajeDao.obtenerFichajesPorEmail(email);
    }


}
