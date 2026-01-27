package com.ebiz.SoporteTecnico.controller.dto.entrada;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdjuntoRequestDTO {
    @NotBlank(message = "El nombre del archivo es obligatorio")
    private String fileName;

    @NotBlank(message = "El tipo de archivo es obligatorio")
    private String fileType;

    @NotBlank(message = "El contenido del archivo no puede estar vacío")
    private String data;

    @NotNull(message = "El ID del ticket es obligatorio")
    private Long ticketId;
}
