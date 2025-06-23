package com.serviciosArtisticos.servicios.Services;

import com.serviciosArtisticos.servicios.DTOS.RequestsDTO.ArtistaRequestDTO;
import com.serviciosArtisticos.servicios.DTOS.ResponseDTO;
import com.serviciosArtisticos.servicios.DTOS.ResponsesDTO.ArtistaReponseDTO;
import com.serviciosArtisticos.servicios.Entities.Artista;
import com.serviciosArtisticos.servicios.Repositories.ArtistaRepository;
import com.serviciosArtisticos.servicios.Utils.CommonParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class ArtistaService {

    Logger logger = LogManager.getLogger(ArtistaService.class);


    private final ArtistaRepository  artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository =  artistaRepository;
    }


    public ResponseDTO getArtistas(String nombre, CommonParams commonParams) {
        ResponseDTO responseDTO = new ResponseDTO(true, 0, "Éxito");

        try {
            int page = commonParams.getPage();
            int size = commonParams.getSize();
            int offset = page * size;

            // Obtener la cantidad total para paginar
            long total = artistaRepository.countArtistasFiltrados(nombre);

            // Obtener los datos paginados
            List<Artista> artistas = artistaRepository.getArtistasFiltradosNative(nombre, size, offset);

            List<ArtistaReponseDTO> artistasDTO = artistas.stream().map(artista -> new ArtistaReponseDTO(
                    artista.getId(),
                    artista.getNombre(),
                    artista.getDescripcion(),
                    artista.getActivo()
            )).toList();

            // Armar la estructura paginada manualmente
            Page<ArtistaReponseDTO> artistasPage = new PageImpl<>(artistasDTO, PageRequest.of(page, size), total);

            // Estructura final del body
            HashMap<String, Object> data = new HashMap<>();
            data.put("content", artistasPage.getContent());
            data.put("totalElements", artistasPage.getTotalElements());
            data.put("totalPages", artistasPage.getTotalPages());
            data.put("currentPage", artistasPage.getNumber());

            responseDTO.setData(data);
            return responseDTO;

        } catch (Exception e) {
            logger.error("Error al obtener artistas: {}", e.getMessage(), e);
            return new ResponseDTO(
                    false,
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error al obtener los artistas: " + e.getMessage()
            );
        }
    }



    public ResponseDTO crearArtista(ArtistaRequestDTO artista){
        ResponseDTO responseDTO = new ResponseDTO(true, 0, "Exito.");
        try {

            logger.info("creando artista {}", artista);
            Artista nuevoArtista = new Artista();
            nuevoArtista.setNombre(artista.getNombre());
            nuevoArtista.setDescripcion(artista.getDescripcion());
            nuevoArtista.setActivo(true);
            artistaRepository.save(nuevoArtista);
            responseDTO.setData(nuevoArtista);
            return responseDTO;
        } catch (Exception e) {
            logger.info("Error en el process obteniendo manifiesto . {}", e.getMessage());
            return  new ResponseDTO(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al crear el artista");
        }
    }



}
