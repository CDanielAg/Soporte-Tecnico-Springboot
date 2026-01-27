package com.ebiz.SoporteTecnico.entity;

import com.ebiz.SoporteTecnico.entity.enums.Estado;
import com.ebiz.SoporteTecnico.entity.enums.Prioridad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickeds")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String descripcion;
    private Estado estado;
    private Prioridad prioridad;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @OneToOne
    private Usuario creador;

    @OneToOne
    private Usuario tecnicoAsignado;
}
