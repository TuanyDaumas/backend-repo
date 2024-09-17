package com.ds1.backend.dtos;

import com.ds1.backend.models.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String matricula;
    private String senha;
    private TipoUsuario tipoUsuario;
    private String email;
    private String cpf;
    private String nome;
}
