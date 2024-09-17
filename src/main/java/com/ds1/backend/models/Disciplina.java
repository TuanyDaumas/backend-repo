package com.ds1.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String codigo;
    @Column(nullable = false)
    private Boolean arCondicionado;
    @Column(nullable = false)
    private Boolean quadroInterativo;
    @Column(nullable = false)
    private Boolean laboratorio;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @ManyToMany(mappedBy = "disciplinas")
    @JsonIgnoreProperties("disciplinas")
    private List<Aluno> alunos = new ArrayList<>();
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL)
    private List<Turma> turmas = new ArrayList<>();
}
