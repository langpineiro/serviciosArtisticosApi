package com.serviciosArtisticos.servicios.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RESERVA_DETALLE_SERVICIO", schema = "SERVICIOS", indexes = {
        @Index(name = "ID_RESERVA", columnList = "ID_RESERVA"),
        @Index(name = "ID_DETALLE_SERVICIO", columnList = "ID_DETALLE_SERVICIO")
})
public class ReservaDetalleServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_RESERVA", nullable = false)
    private Reserva idReserva;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_DETALLE_SERVICIO", nullable = false)
    private DetalleServicio idDetalleServicio;

}