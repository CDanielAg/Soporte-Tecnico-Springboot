package com.ebiz.SoporteTecnico.entity;

import com.ebiz.SoporteTecnico.entity.enums.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String usuario;
    private String password;
    private String email;
    private String nombre;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL)
    private List<Ticket> ticketsCreados;

    @OneToMany(mappedBy = "tecnicoAsignado")
    private List<Ticket> ticketsAsignados;
}
