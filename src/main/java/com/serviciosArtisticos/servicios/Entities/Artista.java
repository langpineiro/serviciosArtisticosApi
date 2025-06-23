package com.serviciosArtisticos.servicios.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ARTISTA", schema = "SERVICIOS")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @ColumnDefault("1")
    @Column(name = "ACTIVO")
    private Boolean activo;

    @OneToMany(mappedBy = "idArtista")
    private Set<DisponibilidadArtista> disponibilidadArtistas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idArtista")
    private Set<Servicio> servicios = new LinkedHashSet<>();

}