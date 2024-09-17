package com.ds1.backend.controllers;

import com.ds1.backend.models.Coordenacao;
import com.ds1.backend.services.CoordenacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/coordenadores")
public class CoordenadorController {

    private final CoordenacaoService coordenacaoService;

    public CoordenadorController(CoordenacaoService coordenacaoService) {
        this.coordenacaoService = coordenacaoService;
    }

    @GetMapping
    public List<Coordenacao> listarTodas() {
        return coordenacaoService.listarTodas();
    }

    @PostMapping
    public Coordenacao salvar(@RequestBody Coordenacao coordenacao) {
        // Implementar lógica de salvar
        return coordenacaoService.salvar(coordenacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coordenacao> buscarPorId(@PathVariable Long id) {
        return coordenacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coordenacao> atualizar(@PathVariable Long id, @RequestBody Coordenacao coordenacao) {
        // Implementar lógica de atualização
        return ResponseEntity.ok(coordenacaoService.salvar(coordenacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        coordenacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
