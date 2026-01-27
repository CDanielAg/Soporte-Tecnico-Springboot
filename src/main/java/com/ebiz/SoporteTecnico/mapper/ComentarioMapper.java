package com.ebiz.SoporteTecnico.mapper;

import com.ebiz.SoporteTecnico.service.dto.entrada.ComentarioRequestDTO;
import com.ebiz.SoporteTecnico.service.dto.salida.ComentarioResponseDTO;
import com.ebiz.SoporteTecnico.entity.Comentario;
import com.ebiz.SoporteTecnico.entity.Ticket;
import com.ebiz.SoporteTecnico.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class ComentarioMapper {
    public ComentarioResponseDTO toDTO(Comentario comentario) {
        if (comentario == null) return null;
        ComentarioResponseDTO dto = new ComentarioResponseDTO();
        dto.setId(comentario.getId());
        dto.setContent(comentario.getContent());
        dto.setCreatedAt(comentario.getCreatedAt());
        if (comentario.getUsuario() != null) {
            dto.setNombreUsuario(comentario.getUsuario().getNombre());
        }
        return dto;
    }

    public Comentario toEntity(ComentarioRequestDTO dto, Usuario autor, Ticket ticket) {
        if (dto == null) return null;
        Comentario comentario = new Comentario();
        comentario.setContent(dto.getContent());
        comentario.setUsuario(autor);
        comentario.setTicket(ticket);
        return comentario;
    }
}
