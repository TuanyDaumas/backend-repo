package com.ds1.backend.repositories;

import com.ds1.backend.models.Coordenacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordenacaoRepository extends JpaRepository<Coordenacao, Long> {
}
