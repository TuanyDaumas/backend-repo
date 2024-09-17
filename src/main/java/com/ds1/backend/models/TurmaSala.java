package com.ds1.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TurmaSala {
    @EmbeddedId
    private TurmaSalaId id;

    @ManyToOne
    @MapsId("turmaId")
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @ManyToOne
    @MapsId("salaId")
    @JoinColumn(name = "sala_id")
    private Sala sala;

    private LocalDate dataReservado;
}
