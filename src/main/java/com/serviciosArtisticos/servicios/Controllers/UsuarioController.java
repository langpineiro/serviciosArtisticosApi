package com.serviciosArtisticos.servicios.Controllers;


import com.serviciosArtisticos.servicios.DTOS.ResponseDTO;
import com.serviciosArtisticos.servicios.Entities.Usuario;
import com.serviciosArtisticos.servicios.Services.UsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    Logger logger = LogManager.getLogger(UsuarioService.class);


    @GetMapping("/byMail/{email}")
    public ResponseEntity<?> findUserByEmail(@PathVariable String email){
        Usuario usuarioEncontrado = usuarioService.obtenerUsuario(email);
        if (usuarioEncontrado != null) {
            return ResponseEntity.ok(usuarioEncontrado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario con email " + email + " no encontrado");
        }
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<?> helloFunction(@PathVariable String name){
        return ResponseEntity.ok("hello " + name);
    }

    @PostMapping("/registrarUsuario")
    public ResponseEntity<ResponseDTO<?>> registrarUsuario(@RequestBody Usuario nuevoUsuario) {
        var resultado = usuarioService.registrarUsuario(nuevoUsuario);

        logger.info("info usuario extraida {}", resultado);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resultado);
    }
}
