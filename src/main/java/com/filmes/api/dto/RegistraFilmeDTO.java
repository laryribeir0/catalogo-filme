package com.filmes.api.dto;

public class RegistraFilmeDTO {

    private String nome;
    private String genero;

    public RegistraFilmeDTO() {
    }

    public RegistraFilmeDTO(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
