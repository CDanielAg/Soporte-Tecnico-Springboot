package com.ebiz.SoporteTecnico.entity;

import com.ebiz.SoporteTecnico.entity.enums.Rol;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String usuario;
    private String password;
    private String email;
    private String nombre;
    private Rol rol;
}
