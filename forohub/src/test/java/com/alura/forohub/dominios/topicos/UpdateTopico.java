package com.alura.forohub.dominios.topicos;

import jakarta.validation.constraints.NotNull;

public record UpdateTopico(@NotNull Long id,
                           String titulo,
                           String mensaje,
                           Estado estado,
                           @NotNull Long idUser,
                           String curso) {
}
