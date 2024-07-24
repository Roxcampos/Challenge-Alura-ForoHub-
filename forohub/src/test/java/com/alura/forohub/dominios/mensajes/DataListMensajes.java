package com.alura.forohub.dominios.mensajes;

import java.time.LocalDateTime;

public record DataListMensajes(Long id,
                                String solucion,
                                Integer idUsuario,
                                Long idTopico,
                                LocalDateTime fechaCreacion) {
    public DataListMensajes(Mensaje mensaje){
        this(mensaje.getId(), mensaje.getSolucion(),
                response.getAutor().getId(),
                response.getTopico().getId(),
                response.getFechaCreacion());
    }
}
