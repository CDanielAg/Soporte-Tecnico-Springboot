package com.ebiz.SoporteTecnico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adjuntos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Adjunto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fileName;
    private String fileType;

    @Column(columnDefinition = "TEXT")
    private String data;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;
}
