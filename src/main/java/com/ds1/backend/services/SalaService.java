package com.ds1.backend.services;

import com.ds1.backend.models.Sala;
import com.ds1.backend.repositories.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public List<Sala> listarTodas() {
        return salaRepository.findAll();
    }

    public Sala salvar(Sala sala) {
        return salaRepository.save(sala);
    }

    public Optional<Sala> buscarPorId(Long id) {
        return salaRepository.findById(id);
    }

    public void deletar(Long id) {
        salaRepository.deleteById(id);
    }
}
