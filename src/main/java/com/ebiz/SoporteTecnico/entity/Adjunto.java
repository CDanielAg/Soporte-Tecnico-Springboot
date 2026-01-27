package com.ebiz.SoporteTecnico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "adjuntos")
public class Adjunto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fileName;
    private String fileType;
    private String data;
}
