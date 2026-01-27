package com.ebiz.SoporteTecnico.mapper;

import com.ebiz.SoporteTecnico.service.dto.entrada.UsuarioRegistroDTO;
import com.ebiz.SoporteTecnico.service.dto.salida.UsuarioDTO;
import com.ebiz.SoporteTecnico.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setUsuario(usuario.getUsuario());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setRol(usuario.getRol());
        return dto;
    }

    public Usuario toEntity(UsuarioRegistroDTO dto) {
        if (dto == null) return null;
        Usuario usuario = new Usuario();
        usuario.setUsuario(dto.getUsuario());
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setRol(dto.getRol());
        usuario.setPassword(dto.getPassword());
        return usuario;
    }
}
