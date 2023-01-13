package com.filmes.api.service;

import com.filmes.api.domain.Filme;
import com.filmes.api.exceptions.EntityNotFoundException;
import com.filmes.api.repositories.FilmeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class FilmeService {


    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public Filme salvarFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Page<Filme> listarTodosOsFilmes(Pageable pageable){
        return filmeRepository.findAll(pageable);

    }

    public Filme buscarFilme(Long id) {
        Optional<Filme> optional = filmeRepository.findById(id);
        return optional.orElseThrow(() -> new EntityNotFoundException("Filme não encontrada"));

    }

    public Filme atualizarFilme(Filme filme, Long id) {

        Filme filmeOriginal = this.buscarFilme(id);
        filme.setId(filmeOriginal.getId());
        return filmeRepository.save(filme);

    }

    public void excluirFilme(Long id) {
        Filme filmeOriginal = this.buscarFilme(id);
        filmeRepository.delete(filmeOriginal);

    }

}
