package com.ds1.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date ano;
    private String semestre;
    //entender melhor como deve ser feito a configuração de horário da turma
    private String horario;
    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private List<TurmaSala> turmaSalas = new ArrayList<>();
}
