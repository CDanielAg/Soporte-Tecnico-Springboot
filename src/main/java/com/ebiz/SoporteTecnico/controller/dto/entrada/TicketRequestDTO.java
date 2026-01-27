package com.ebiz.SoporteTecnico.controller.dto.entrada;

import com.ebiz.SoporteTecnico.entity.enums.Prioridad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TicketRequestDTO {
    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotNull(message = "La prioridad es obligatoria")
    private Prioridad prioridad;

    @NotNull(message = "El ID del creador es obligatorio")
    private Long creadorId;
}
