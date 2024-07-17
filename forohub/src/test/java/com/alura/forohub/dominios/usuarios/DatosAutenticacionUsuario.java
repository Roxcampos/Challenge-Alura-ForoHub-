package com.alura.forohub.dominios.usuarios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosAutenticacionUsuario(
        @NotBlank(message = "Use your Email as username")
        String username,
        @NotBlank(message = "Must be  between 8 to 10 characters") @Pattern(regexp = "\\d{8,10}")
        String password)  {
}
