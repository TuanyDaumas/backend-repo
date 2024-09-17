package com.ds1.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalaDTO {
    private Long id;
    private String bloco;
    private Integer numero;
    private Integer capacidade;
    private Boolean arCondicionado;
    private Boolean quadroInterativo;
    private Boolean laboratorio;
    private Boolean disponibilidade;
}
