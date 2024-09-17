package com.ds1.backend.repositories;

import com.ds1.backend.models.TurmaSala;
import com.ds1.backend.models.TurmaSalaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaSalaRepository extends JpaRepository<TurmaSala, TurmaSalaId> {
    List<TurmaSala> findByTurmaId(Long turmaId);

    List<TurmaSala> findBySalaId(Long salaId);
}
