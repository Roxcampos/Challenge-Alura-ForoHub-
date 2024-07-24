package com.alura.forohub.dominios.mensajes;

import com.alura.forohub.dominios.usuarios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    @Autowired
    private TopicoRepositorio topicoRepositorio;
    @Autowired
    private MensajeRepositorio usuarioRepositorio;
    @Autowired
    private MensajeRepositorio repositorio;

    public MensajeDataT crearMensaje(MensajeData mensajeData) {


        if (!ussuarioRepositorio.findById(mensajeData.idUsuario()).isPresent()){
            throw new IntegrityValidation("Usuario no registrado en la base de datos");
        }

        if (!topicORepositorio.findById(mensajeData.idTopico()).isPresent()){
            throw new IntegrityValidation("Topico no registrado en la base de datos");
        }
        var usuario = usuarioRepositorio.findById(mensajeData.idUsuario()).get().getAutor();
        var topico =topicoRepositorio.findById(mensajeData.idTopico()).get();

        var mVerificado= new Mensaje(null,mensajeData.solucion(),usuario,topico,MensajeData.fechaCreacion());
        repositorio.save(mVerificado);
        return  new MensajeDataT(mVerificado);
    }
}
