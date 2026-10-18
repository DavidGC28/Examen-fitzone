package com.krakedev.fitzone.controllers;

import com.krakedev.fitzone.entidades.Socio;
import com.krakedev.fitzone.services.ServicioSocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socios")
public class SocioController {

    @Autowired
    private ServicioSocio servicioSocio;

    @PostMapping
    public ResponseEntity<Socio> crearSocio(@RequestBody Socio socio) {
        try {
            Socio nuevoSocio = servicioSocio.crear(socio);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoSocio);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Socio>> listarSocios() {
        List<Socio> socios = servicioSocio.listar();
        return ResponseEntity.ok(socios);
    }

    @GetMapping("/estado")
    public ResponseEntity<List<Socio>> buscarPorEstado(@RequestParam boolean activo) {
        List<Socio> socios = servicioSocio.buscarPorEstado(activo);
        return ResponseEntity.ok(socios);
    }
}