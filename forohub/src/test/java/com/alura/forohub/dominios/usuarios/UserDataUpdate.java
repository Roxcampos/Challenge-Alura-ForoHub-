package com.alura.forohub.dominios.usuarios;

import jakarta.validation.constraints.NotNull;

public record UserDataUpdate(@NotNull Long id,
                             String nombre,
                             String email) {
}
