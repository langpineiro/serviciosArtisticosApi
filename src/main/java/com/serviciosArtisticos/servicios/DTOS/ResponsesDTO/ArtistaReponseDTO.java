package com.serviciosArtisticos.servicios.DTOS.ResponsesDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistaReponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private boolean activo;
}