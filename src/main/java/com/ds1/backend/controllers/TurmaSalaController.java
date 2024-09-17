package com.ds1.backend.controllers;

import com.ds1.backend.models.TurmaSala;
import com.ds1.backend.models.TurmaSalaId;
import com.ds1.backend.services.TurmaSalaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/turma-salas")
public class TurmaSalaController {

    private final TurmaSalaService turmaSalaService;


    public TurmaSalaController(TurmaSalaService turmaSalaService) {
        this.turmaSalaService = turmaSalaService;
    }

    @GetMapping
    public List<TurmaSala> listarTodasTurmaSalas() {
        return turmaSalaService.listarTodas();
    }

    @GetMapping("/{turmaId}/{salaId}")
    public ResponseEntity<TurmaSala> listarTurmaSalaPorId(@PathVariable Long turmaId, @PathVariable Long salaId) {
        TurmaSalaId id = new TurmaSalaId(turmaId, salaId);
        return turmaSalaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{turmaId}/{salaId}")
    public TurmaSala criarTurmaSala(@PathVariable Long turmaId, @PathVariable Long salaId, @RequestBody TurmaSala turmaSala) {
        return turmaSalaService.associacaoTurmaComSala(turmaId, salaId, turmaSala);
    }

    @PutMapping("/{turmaId}/{salaId}")
    public ResponseEntity<TurmaSala> alterarTurmaSala(@PathVariable Long turmaId, @PathVariable Long salaId, @RequestBody TurmaSala turmaSalaDetails) {
        TurmaSalaId id = new TurmaSalaId(turmaId, salaId);
        return turmaSalaService.buscarPorId(id)
                .map(turmaSala -> {
                    // Atualize outros campos conforme necessário
                    return ResponseEntity.ok(turmaSalaService.salvar(turmaSala));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{turmaId}/{salaId}")
    public ResponseEntity<Void> deletarTurmaSala(@PathVariable Long turmaId, @PathVariable Long salaId) {
        TurmaSalaId id = new TurmaSalaId(turmaId, salaId);
        return turmaSalaService.buscarPorId(id)
                .map(turmaSala -> {
                    turmaSalaService.deletar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/turma/{turmaId}")
    public List<TurmaSala> listarTurmaSalasPorTurmaId(@PathVariable Long turmaId) {
        return turmaSalaService.buscarTurmaPorId(turmaId);
    }

    @GetMapping("/sala/{salaId}")
    public List<TurmaSala> listarTurmaSalasPorSalaId(@PathVariable Long salaId) {
        return turmaSalaService.buscarSalaPorId(salaId);
    }
}
