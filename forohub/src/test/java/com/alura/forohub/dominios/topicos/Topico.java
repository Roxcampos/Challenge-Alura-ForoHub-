package com.alura.forohub.dominios.topicos;


import com.alura.forohub.dominios.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name= "Topico")
@Table(name="topicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "autor_id")
    private Usuario autor;
    private String curso;
    private boolean activo;



    public Topico(Long id, String titulo, String mensaje, LocalDateTime fecha, Estado estado, Usuario user, String curso) {
        this.id=id;
        this.titulo=titulo;
        this.mensaje=mensaje;
        this.fecha=LocalDateTime.now();
        this.estado=estado;
        this.autor=user;
        this.curso=curso;

    }


    public void updateDatos(UpdateTopico updateTopico) {
        if (updateTopico.titulo() !=null){
            this.titulo= updateTopico.titulo();
        }
        if (updateTopico.mensaje() != null){
            this.mensaje=updateTopico.mensaje();
        }
        if (updateTopico.estado() != null){
            this.estado=updateTopico.estado();
        }
        if (updateTopico.curso() != null){
            this.curso=updateTopico.curso();
        }
    }
    public void desactivarTopico(){
        this.activo=false;
    }
}

}
