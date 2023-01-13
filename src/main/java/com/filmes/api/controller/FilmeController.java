package com.filmes.api.controller;

import com.filmes.api.domain.Filme;
import com.filmes.api.dto.ConsultaFimeDTO;
import com.filmes.api.dto.FilmeMapper;
import com.filmes.api.dto.RegistraFilmeDTO;
import com.filmes.api.service.FilmeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping
    public ResponseEntity<Page<ConsultaFimeDTO>> buscarTodosOsFilmes(@PageableDefault(size = 3) Pageable pageable) {

        return ResponseEntity.ok(filmeService.listarTodosOsFilmes(pageable).map(FilmeMapper::fromEntity));
    }

    @PostMapping
    public ResponseEntity<ConsultaFimeDTO> salvarFilme(@RequestBody RegistraFilmeDTO dto) {

        Filme filme = filmeService.salvarFilme(FilmeMapper.fromDTO(dto));
        return ResponseEntity.ok(FilmeMapper.fromEntity(filme));
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsultaFimeDTO> buscarFilme(@PathVariable Long id) {

        Filme filme = filmeService.buscarFilme(id);
        return ResponseEntity.ok(FilmeMapper.fromEntity(filme));

    }

    @PutMapping("{id}")
    public ResponseEntity<ConsultaFimeDTO> alterarFilme(@RequestBody RegistraFilmeDTO dto, @PathVariable Long id) {

        try {
            Filme filme = filmeService.atualizarFilme(FilmeMapper.fromDTO(dto), id);
            return ResponseEntity.ok(FilmeMapper.fromEntity(filme));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ConsultaFimeDTO> excluirFilme(@PathVariable Long id) {

        try {
            filmeService.excluirFilme(id);

            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }

    }

}
