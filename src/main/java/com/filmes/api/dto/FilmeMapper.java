package com.filmes.api.dto;

import com.filmes.api.domain.Filme;

public class FilmeMapper {

    public static Filme fromDTO(RegistraFilmeDTO dto){
        return new Filme(null,dto.getNome(),dto.getGenero());
    }

    public static ConsultaFimeDTO fromEntity(Filme filme) {
        return new ConsultaFimeDTO(filme.getId(), filme.getNome(), filme.getGenero());
    }
}
