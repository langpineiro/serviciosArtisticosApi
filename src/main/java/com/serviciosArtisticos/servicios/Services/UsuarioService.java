package com.serviciosArtisticos.servicios.Services;

import com.serviciosArtisticos.servicios.DTOS.ResponseDTO;
import com.serviciosArtisticos.servicios.Entities.Usuario;
import com.serviciosArtisticos.servicios.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


@Service
public class UsuarioService {

    Logger logger = LogManager.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario obtenerUsuario(String email){
        logger.info("buscando usuario: {}", email);
        Usuario user =  usuarioRepository.getUsuarioCorreo(email);
        return user;
    }

    public ResponseDTO<Usuario> registrarUsuario(Usuario nuevoUsuario) {
        Usuario userEncontrado = this.obtenerUsuario(nuevoUsuario.getCorreoElectronico());


        if (userEncontrado != null) {
            // Usuario ya existe
            return new ResponseDTO<>(
                    false,
                    HttpStatus.CONFLICT.value(),
                    "El usuario ya existe",
                    null
            );
        }

        //Usuario usuarioGuardado = usuarioRepository.save(nuevoUsuario);
        // 🔐 Encriptar la contraseña antes de guardar
        String passwordEncriptada = passwordEncoder.encode(nuevoUsuario.getPassword());
        nuevoUsuario.setPassword(passwordEncriptada);

        Usuario guardado = usuarioRepository.save(nuevoUsuario);

        return new ResponseDTO<>(
                true,
                HttpStatus.CREATED.value(),
                "created",
                guardado
        );
    }

}
