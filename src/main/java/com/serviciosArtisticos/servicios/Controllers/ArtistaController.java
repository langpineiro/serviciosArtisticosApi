package com.serviciosArtisticos.servicios.Controllers;


import com.serviciosArtisticos.servicios.DTOS.RequestsDTO.ArtistaRequestDTO;
import com.serviciosArtisticos.servicios.DTOS.ResponseDTO;
import com.serviciosArtisticos.servicios.Entities.Artista;
import com.serviciosArtisticos.servicios.Entities.Usuario;
import com.serviciosArtisticos.servicios.Services.ArtistaService;
import com.serviciosArtisticos.servicios.Utils.CommonParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/artista")
@CrossOrigin(origins = "*")
public class ArtistaController {

    private ArtistaService artistaService;

    Logger logger = LogManager.getLogger(ArtistaController.class);

    private ArtistaController(ArtistaService artistaService){
        this.artistaService = artistaService;
    }

    @GetMapping("obtener")
    public ResponseEntity<ResponseDTO> getGuiasMaster(@RequestParam(required = false) String nombre,
                                                      CommonParams commonParams){
        return ResponseEntity.ok(artistaService.getArtistas(nombre, commonParams));
    }

    @PostMapping( "/registrar")
    public ResponseEntity<ResponseDTO> registrarUsuario(@RequestBody ArtistaRequestDTO nuevoArtista) {
        return ResponseEntity.ok(artistaService.crearArtista(nuevoArtista));
    }

}
