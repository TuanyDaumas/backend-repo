package com.ds1.backend.models;

public enum TipoUsuario {
    COORDENADOR("coordenador"),
    PROFESSOR("professor"),
    ALUNO("aluno");

    private String funcao;
    TipoUsuario(String funcao){
        this.funcao = funcao;
    }

    public String getFuncao(){
        return funcao;
    }
}
