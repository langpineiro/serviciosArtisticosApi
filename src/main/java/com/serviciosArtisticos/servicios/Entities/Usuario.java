package com.serviciosArtisticos.servicios.Entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USUARIO")
@Data
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", length = 100)
    private String nombre;

    @Column(name = "APELLIDO", length = 100)
    private String apellido;

    @Column(name = "CORREO_ELECTRONICO", length = 150)
    private String correoElectronico;

    @Column(name = "CLAVE", length = 255)
    private String password;

    @Column(name = "ACTIVO", length = 1)
    private String activo;

    @Column(name = "EXTERNO", length = 1)
    private String externo;

    @Column(name = "DIRECCION", length = 255)
    private String direccion;

    @Column(name = "CAMBIO_PASSWORD", length = 1)
    private String cambioPassword;

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getPassword() {
        return password;
    }

    public String getActivo() {
        return activo;
    }

    public String getExterno() {
        return externo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCambioPassword() {
        return cambioPassword;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public void setExterno(String externo) {
        this.externo = externo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCambioPassword(String cambioPassword) {
        this.cambioPassword = cambioPassword;
    }

}


