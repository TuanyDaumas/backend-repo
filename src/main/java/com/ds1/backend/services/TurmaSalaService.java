package com.ds1.backend.services;

import com.ds1.backend.models.Sala;
import com.ds1.backend.models.Turma;
import com.ds1.backend.models.TurmaSala;
import com.ds1.backend.models.TurmaSalaId;
import com.ds1.backend.repositories.SalaRepository;
import com.ds1.backend.repositories.TurmaRepository;
import com.ds1.backend.repositories.TurmaSalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaSalaService {

    private final SalaRepository salaRepository;

    private final TurmaRepository turmaRepository;

    private final TurmaSalaRepository turmaSalaRepository;

    public TurmaSalaService(SalaRepository salaRepository, TurmaRepository turmaRepository, TurmaSalaRepository turmaSalaRepository) {
        this.salaRepository = salaRepository;
        this.turmaRepository = turmaRepository;
        this.turmaSalaRepository = turmaSalaRepository;
    }

    public List<TurmaSala> listarTodas() {
        return turmaSalaRepository.findAll();
    }

    public Optional<TurmaSala> buscarPorId(TurmaSalaId id) {
        return turmaSalaRepository.findById(id);
    }

    public TurmaSala salvar(TurmaSala turmaSala) {
        return turmaSalaRepository.save(turmaSala);
    }

    public void deletar(TurmaSalaId id) {
        turmaSalaRepository.deleteById(id);
    }

    public TurmaSala associacaoTurmaComSala(Long turmaId, Long salaId, TurmaSala turmaSala) {
        Turma turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        Sala sala = salaRepository.findById(salaId)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));

        turmaSala.setTurma(turma);
        turmaSala.setSala(sala);
        turmaSala.setId(new TurmaSalaId(turmaId, salaId));

        return turmaSalaRepository.save(turmaSala);
    }

    public List<TurmaSala> buscarTurmaPorId(Long turmaId) {
        return turmaSalaRepository.findByTurmaId(turmaId);
    }

    public List<TurmaSala> buscarSalaPorId(Long salaId) {
        return turmaSalaRepository.findBySalaId(salaId);
    }
}
