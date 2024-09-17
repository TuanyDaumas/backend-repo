package com.ds1.backend.models;

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
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String bloco;
    @Column(nullable = false)
    private Integer numero;
    @Column(nullable = false)
    private Integer capacidade;
    @Column(nullable = false)
    private Boolean arCondicionado;
    @Column(nullable = false)
    private Boolean quadroInterativo;
    @Column(nullable = false)
    private Boolean laboratorio;
    @Column(nullable = false)
    private Boolean disponibilidade;
    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
    private List<TurmaSala> turmaSalas = new ArrayList<>();
}
