package com.ebiz.SoporteTecnico.controller.dto.salida;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ComentarioResponseDTO {
    private long id;
    private String content;
    private LocalDateTime createdAt;
    private String nombreUsuario;
}
