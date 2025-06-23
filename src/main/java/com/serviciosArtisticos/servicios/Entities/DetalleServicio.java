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
@Table(name = "DETALLE_SERVICIO", schema = "SERVICIOS", indexes = {
        @Index(name = "ID_SERVICIO", columnList = "ID_SERVICIO")
})
public class DetalleServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_SERVICIO", nullable = false)
    private Servicio idServicio;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @ColumnDefault("0.00")
    @Column(name = "PRECIO_ADICIONAL", precision = 10, scale = 2)
    private BigDecimal precioAdicional;

    @OneToMany(mappedBy = "idDetalleServicio")
    private Set<ReservaDetalleServicio> reservaDetalleServicios = new LinkedHashSet<>();

}