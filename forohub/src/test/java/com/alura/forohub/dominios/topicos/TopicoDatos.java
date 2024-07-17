package com.alura.forohub.dominios.topicos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoDatos(
        @NotNull(message = "Título en uso ")
        String titulo,
        @NotNull(message = "Longitud máxima 700 carácteres ")
        String mensaje,
        @NotNull(message = "Seleccione un estado ´ABIERTO´ o ´CERRADO´")
        Estado estado,
        @NotNull(message = "Utilice su ID de autor de usuario")
        Long idUser,
        @NotNull(message = "IMPORTANTE utilizar el curso apropiado para tu publicación")
        String curso,
        LocalDateTime fecha) {
}
