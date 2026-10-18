package com.krakdev.fitzone.controllers;

import com.krakdev.fitzone.services.ServicioSocio;
import com.krakedev.fitzone.Socio;

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
    public ResponseEntity<List<com.krakedev.fitzone.entidades.Socio>> listarSocios() {
        List<com.krakedev.fitzone.entidades.Socio> socios = servicioSocio.listar();
        return ResponseEntity.ok(socios);
    }


    @GetMapping("/estado")
    public ResponseEntity<List<com.krakedev.fitzone.entidades.Socio>> buscarPorEstado(@RequestParam boolean activo) {
        List<com.krakedev.fitzone.entidades.Socio> socios = servicioSocio.buscarPorEstado(activo);
        return ResponseEntity.ok(socios);
    }
}