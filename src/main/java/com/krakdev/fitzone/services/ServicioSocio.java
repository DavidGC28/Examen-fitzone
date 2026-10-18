package com.krakdev.fitzone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krakedev.fitzone.Socio;
import com.krakedev.fitzone.SocioRepository;

import java.util.List;

@Service
public class ServicioSocio {

    @Autowired
    private SocioRepository socioRepository;

    public Socio crear(Socio s) {
        if (s.getEdad() < 14) {
            throw new IllegalArgumentException("La edad mínima permitida es 14 años.");
        }
        return socioRepository.save(s);
    }

    public List<com.krakedev.fitzone.entidades.Socio> listar() {
        return socioRepository.findAll();
    }

    public List<com.krakedev.fitzone.entidades.Socio> buscarPorEstado(boolean activo) {
        return socioRepository.findByActivo(activo);
    }
}