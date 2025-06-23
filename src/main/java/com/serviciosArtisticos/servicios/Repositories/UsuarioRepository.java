package com.serviciosArtisticos.servicios.Repositories;

import com.serviciosArtisticos.servicios.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "SELECT a "
            + " FROM Usuario a "
            + " WHERE a.correoElectronico = :correo")
    Usuario getUsuarioCorreo(@Param("correo") String correo);
}
