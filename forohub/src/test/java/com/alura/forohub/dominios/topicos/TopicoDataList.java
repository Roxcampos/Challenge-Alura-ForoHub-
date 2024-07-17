package com.alura.forohub.dominios.topicos;

import java.time.LocalDateTime;

public record TopicoDataList(Long id,
                             String titulo,
                             String mensaje,
                             Estado estado,
                             Integer idUser,
                             String curso,
                             LocalDateTime fecha) {

    public TopicoDataList (Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getEstado(),topico.getAutor().getId(), topico.getCurso(),topico.getFecha());

    }
}
