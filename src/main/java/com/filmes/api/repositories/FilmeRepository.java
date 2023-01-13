package com.filmes.api.repositories;

import com.filmes.api.domain.Filme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme,Long> {
    Page<Filme> findAll(Pageable pageable);

}
