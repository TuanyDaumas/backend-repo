package com.ds1.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TurmaSalaId implements Serializable {

    @Column(name = "turma_id")
    private Long turmaId;
    @Column(name = "sala_id")
    private Long salaId;
}
