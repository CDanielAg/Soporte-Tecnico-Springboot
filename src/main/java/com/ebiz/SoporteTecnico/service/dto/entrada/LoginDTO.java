package com.ebiz.SoporteTecnico.service.dto.entrada;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {
    @NotBlank(message = "Usuario requerido")
    private String usuario;

    @NotBlank(message = "Contraseña requerida")
    private String password;
}
