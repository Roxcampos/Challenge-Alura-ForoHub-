package com.alura.forohub.dominios.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepositorio extends JpaRepository<Topico, Long> {


    boolean existsByTitleIgnoreCase(String titulo);

    boolean existsByMessageIgnoreCase(String mensaje);

    Page<Topico> findByActiveTrue(Pageable paged);
}