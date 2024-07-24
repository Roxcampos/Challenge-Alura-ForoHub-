package com.alura.forohub.dominios.mensajes;

@Entity(name="Mensaje")
@Table(name = "mensajes")
@Getter
@Setter
@NoArgsConstructor
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaCreacion;
    private String solucion;
    @OneToOne
    @JoinColumn(name="autor", referencedColumnName="id")
    private Usuario autor;
    @OneToOne
    @JoinColumn(name="topico", referencedColumnName="id")
    private Topico topico;
    private boolean activo;

    public Mensaje(Long id, String solucion, Usuario usuario, Topico topico, LocalDateTime fechaCreacion) {
        this.id=id;
        this.solucion=solucion;
        this.autor=usuario;
        this.topico=topico;
        this.fechaCreacion=LocalDateTime.now();
    }

    public Mensaje(MnesajeData dto) {
        this.solucion = dto.solucion();
        this.autor = dto.idUsuario();
    }

    public void mansajeUpdate(UpdateMensajeDetails updateMensajeDetails) {
        if (updateMensajeDetails.solucion() != null){
            this.solucion=updateMensajeDetails.solucion();
        }
    }
    public void desactivarMensajes(){
        this.activo=false;
    }
}

