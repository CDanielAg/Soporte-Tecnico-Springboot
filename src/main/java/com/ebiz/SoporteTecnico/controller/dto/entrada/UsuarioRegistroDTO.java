package com.ebiz.SoporteTecnico.controller.dto.entrada;

import com.ebiz.SoporteTecnico.entity.enums.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioRegistroDTO {
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 4, max = 20)
    private String usuario;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "Mínimo 8 caracteres")
    private String password;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Formato de email inválido")
    private String email;

    @NotBlank(message = "El nombre completo es obligatorio")
    private String nombre;

    @NotNull(message = "El rol es obligatorio")
    private Rol rol;
}
