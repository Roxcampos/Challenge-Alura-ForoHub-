package com.alura.forohub.dominios.mensajes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepositorio extends JpaRepository<Mensaje, Long> {

    Page<Mensaje> findByActiveTrue(Pageable paged);
}