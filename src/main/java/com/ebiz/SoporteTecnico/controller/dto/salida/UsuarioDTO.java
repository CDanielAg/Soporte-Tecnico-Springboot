package com.ebiz.SoporteTecnico.controller.dto.salida;
import com.ebiz.SoporteTecnico.entity.enums.Rol;

import lombok.Data;

@Data
public class UsuarioDTO {
    private long id;
    private String usuario;
    private String email;
    private String nombre;
    private Rol rol;
}
