package com.aluraLatam.foroHubChallenge.domain.response;

import java.time.LocalDateTime;

public record MensajeDataT(Long id, String solucion, Integer idUsuario, Long idTopico, LocalDateTime fechaCreacion) {
    public MensajeDataT(Mensaje mVerificado) {
        this(mVerificado.getId(),mVerificado.getSolucion(),mVerificado.getAutor().getId(),mVerificado.getTopico().getId(),mVerificado.getFechaCreacion());
    }
}
