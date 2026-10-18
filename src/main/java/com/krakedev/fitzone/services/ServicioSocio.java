package com.krakedev.fitzone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krakedev.fitzone.SocioRepository;
import com.krakedev.fitzone.entidades.Socio;
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

    public List<Socio> listar() {
        return socioRepository.findAll();
    }

    public List<Socio> buscarPorEstado(boolean activo) {
        return socioRepository.findByActivo(activo);
    }
}