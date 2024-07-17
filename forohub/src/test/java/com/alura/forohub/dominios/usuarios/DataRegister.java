package com.alura.forohub.dominios.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public interface DataRegister (
    @NotBlank
    String nombre,
    @NotBlank
    @Email
    String email,
    @NotBlank (message = "Utilice su correo electrónico como nombre de usuario")
    String username,
    @NotBlank(message = "Debe tener entre 8 y 10 caracteres.") @Pattern(regexp = "\\d{8,10}")
    String password){
    }
