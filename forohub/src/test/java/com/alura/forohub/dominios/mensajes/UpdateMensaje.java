package com.alura.forohub.dominios.mensajes;

import jakarta.validation.constraints.NotNull;

public record UpdateMensaje(@NotNull Long id, String solucion,@NotNull Long idUsuario,@NotNull Long idTopico, LocalDateTime fechaCreacion) {
}}
