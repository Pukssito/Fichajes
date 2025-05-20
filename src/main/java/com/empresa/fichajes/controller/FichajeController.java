package com.empresa.fichajes.controller;

import com.empresa.fichajes.entity.Fichaje;
import com.empresa.fichajes.repository.FichajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/fichajes")
public class FichajeController {

    @Autowired
    private FichajeRepository fichajeRepository;

    @PostMapping("/fichar")
    public Fichaje fichar(@RequestBody Fichaje fichaje) {
        fichaje.setFechaHora(ZonedDateTime.now(ZoneId.of("Europe/Madrid")).toLocalDateTime());
        return fichajeRepository.save(fichaje);
    }

    @GetMapping("/usuario/{id}")
    public List<Fichaje> getFichajesPorUsuario(@PathVariable Long id) {
        return fichajeRepository.findByUsuarioId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFichaje(@PathVariable Long id) {
        fichajeRepository.deleteById(id);
    }

}
