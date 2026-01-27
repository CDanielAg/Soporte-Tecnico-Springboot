package com.ebiz.SoporteTecnico.controller.dto.entrada;

import com.ebiz.SoporteTecnico.entity.enums.Estado;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TicketStatusUpdateDTO {
    @NotNull(message = "El nuevo estado es obligatorio")
    private Estado nuevoEstado;
}
