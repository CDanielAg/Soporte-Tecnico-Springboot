package com.ebiz.SoporteTecnico.service.dto.salida;

import com.ebiz.SoporteTecnico.entity.enums.Estado;
import com.ebiz.SoporteTecnico.entity.enums.Prioridad;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TicketResponseDTO {
    private long id;
    private String titulo;
    private String descripcion;
    private Estado estado;
    private Prioridad prioridad;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UsuarioDTO creador;
    private UsuarioDTO tecnicoAsignado;
    private List<AdjuntoResponseDTO> adjuntos;
    private List<ComentarioResponseDTO> comentarios;
}
