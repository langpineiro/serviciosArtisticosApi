package com.serviciosArtisticos.servicios.Repositories;

import com.serviciosArtisticos.servicios.Entities.Artista;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    @Query(value = """
    SELECT * 
    FROM SERVICIOS.ARTISTA 
    WHERE (:nombre IS NULL OR NOMBRE LIKE CONCAT('%',:nombre,'%')) 
    ORDER BY NOMBRE ASC 
    LIMIT :limit OFFSET :offset
    """, nativeQuery = true)
    List<Artista> getArtistasFiltradosNative(
            @Param("nombre") String nombre,
            @Param("limit") int limit,
            @Param("offset") int offset
    );

    @Query(value = """
    SELECT COUNT(*) 
    FROM SERVICIOS.ARTISTA a 
    WHERE (:nombre IS NULL OR a.NOMBRE LIKE CONCAT('%',:nombre,'%'))
    """,
            nativeQuery = true)
    long countArtistasFiltrados(@Param("nombre") String nombre);

}
