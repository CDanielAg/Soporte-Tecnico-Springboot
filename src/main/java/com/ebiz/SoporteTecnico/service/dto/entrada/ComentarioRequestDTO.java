package com.ebiz.SoporteTecnico.service.dto.entrada;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ComentarioRequestDTO {
    @NotBlank(message = "Contenido vacío")
    private String content;
    @NotNull
    private Long ticketId;
    @NotNull
    private Long usuarioId;
}
