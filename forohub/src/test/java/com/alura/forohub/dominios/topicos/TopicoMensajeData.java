package com.alura.forohub.dominios.topicos;

import java.time.LocalDateTime;

public record TopicoResponseData (
        Long id, String titulo, String mensaje, Estado estado, Integer idUser, String curso,
        LocalDateTime fecha) {
public TopicoResponseData(Topico topico1) {
    this(topico1.getId(), topico1.getTitulo(), topico1.getMensaje(),topico1.getEstado(),topico1.getAutor().getId(),topico1.getCurso(),topico1.getFecha());
}
}


