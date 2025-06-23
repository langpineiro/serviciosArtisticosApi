package com.serviciosArtisticos.servicios.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "DISPONIBILIDAD_ARTISTA", schema = "SERVICIOS", indexes = {
        @Index(name = "ID_ARTISTA", columnList = "ID_ARTISTA")
})
public class DisponibilidadArtista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ARTISTA", nullable = false)
    private Artista idArtista;

    @Column(name = "DIA_SEMANA", nullable = false, length = 10)
    private String diaSemana;

    @Column(name = "HORA_INICIO", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "HORA_FIN", nullable = false)
    private LocalTime horaFin;

}