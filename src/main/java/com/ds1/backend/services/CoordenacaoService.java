package com.ds1.backend.services;

import com.ds1.backend.models.Coordenacao;
import com.ds1.backend.repositories.CoordenacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordenacaoService {

    private final CoordenacaoRepository coordenacaoRepository;

    public CoordenacaoService(CoordenacaoRepository coordenacaoRepository) {
        this.coordenacaoRepository = coordenacaoRepository;
    }

    public List<Coordenacao> listarTodas() {
        return coordenacaoRepository.findAll();
    }

    public Coordenacao salvar(Coordenacao coordenacao) {
        return coordenacaoRepository.save(coordenacao);
    }

    public Optional<Coordenacao> buscarPorId(Long id) {
        return coordenacaoRepository.findById(id);
    }

    public void deletar(Long id) {
        coordenacaoRepository.deleteById(id);
    }
}
