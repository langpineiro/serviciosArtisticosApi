package com.serviciosArtisticos.servicios.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "SERVICIO", schema = "SERVICIOS", indexes = {
        @Index(name = "ID_ARTISTA", columnList = "ID_ARTISTA")
})
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ARTISTA")
    private Artista idArtista;

    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO_BASE", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioBase;

    @ColumnDefault("1")
    @Column(name = "ACTIVO")
    private Boolean activo;

    @OneToMany(mappedBy = "idServicio")
    private Set<DetalleServicio> detalleServicios = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idServicio")
    private Set<Reserva> reservas = new LinkedHashSet<>();

}