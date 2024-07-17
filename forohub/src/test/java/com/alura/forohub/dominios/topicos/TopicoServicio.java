package com.alura.forohub.dominios.topicos;

import com.alura.forohub.dominios.usuarios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoServicio {
    @Autowired
    private TopicoRepositorio topicoRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public TopicoResponseData crearTopico(TopicoDatos topicoDatos){


        if (!usuarioRepositorio.findById(topicoDatos.idUser()).isPresent()){
            throw new IntegrityValidation("Usuario no registrado en la base de datos. ");
        }

        var titulo= topicoDatos.titulo();
        if (titulo != null && topicoRepositorio.existsByTitleIgnoreCase(titulo)){
            throw new IntegrityValidation("Este título ya existe en la base de datos. Por favor ingrese uno nuevo");

        }

        String mensaje = topicoDatos.mensaje();
        if (mensaje != null && topicoRepositorio.existsByMessageIgnoreCase(mensaje)){
            throw new IntegrityValidation("Este mensaje ya existe en la base de datos. Por favor ingresa nuevamente el tema.");
        }

        var usuario = usuarioRepositorio.findById(topicoDatos.idUser()).get();


        var topico1= new Topico(null,titulo,mensaje,topicoDatos.fecha(),topicoDatos.estado(),usuario,topicoDatos.curso());

        topicoRepositorio.save(topico1);

        return new TopicoResponseData(topico1);
    }
}
