package com.ebiz.SoporteTecnico.entity;

import com.ebiz.SoporteTecnico.entity.enums.Estado;
import com.ebiz.SoporteTecnico.entity.enums.Prioridad;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "creador_id")
    private Usuario creador;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Usuario tecnicoAsignado;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Adjunto> adjuntos;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;
}
