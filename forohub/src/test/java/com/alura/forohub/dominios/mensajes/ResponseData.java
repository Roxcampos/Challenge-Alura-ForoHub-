package com.alura.forohub.dominios.mensajes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record MensajeData(
        @NotBlank
        String solucion,
        @NotNull
        @Valid
        Integer idUsuario,
        @NotNull
        @Valid
        Long idTopico,
        LocalDateTime fechaCreacion) {
}
