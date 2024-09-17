package com.ds1.backend.controllers;

import com.ds1.backend.models.Sala;
import com.ds1.backend.services.SalaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public List<Sala> listarTodas() {
        return salaService.listarTodas();
    }

    @PostMapping
    public Sala salvar(@RequestBody Sala sala) {
        // Implementar lógica de salvar
        return salaService.salvar(sala);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscarPorId(@PathVariable Long id) {
        return salaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> atualizar(@PathVariable Long id, @RequestBody Sala sala) {
        // Implementar lógica de atualização
        return ResponseEntity.ok(salaService.salvar(sala));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        salaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
