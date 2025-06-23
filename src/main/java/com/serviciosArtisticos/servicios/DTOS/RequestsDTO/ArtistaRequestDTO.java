package com.serviciosArtisticos.servicios.DTOS.RequestsDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistaRequestDTO {
    private String nombre;
    private String descripcion;
}
