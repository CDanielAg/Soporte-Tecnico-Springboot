package com.ebiz.SoporteTecnico.mapper;

import com.ebiz.SoporteTecnico.service.dto.entrada.TicketRequestDTO;
import com.ebiz.SoporteTecnico.service.dto.salida.TicketResponseDTO;
import com.ebiz.SoporteTecnico.entity.Ticket;
import com.ebiz.SoporteTecnico.entity.Usuario;
import com.ebiz.SoporteTecnico.entity.enums.Estado;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    private final UsuarioMapper usuarioMapper;

    public TicketMapper(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    public TicketResponseDTO toDTO(Ticket ticket) {
        if (ticket == null) return null;
        TicketResponseDTO dto = new TicketResponseDTO();
        dto.setId(ticket.getId());
        dto.setTitulo(ticket.getTitulo());
        dto.setDescripcion(ticket.getDescripcion());
        dto.setPrioridad(ticket.getPrioridad());
        dto.setEstado(ticket.getEstado());
        dto.setCreatedAt(ticket.getCreatedAt());
        dto.setUpdatedAt(ticket.getUpdatedAt());

        dto.setCreador(usuarioMapper.toDTO(ticket.getCreador()));
        dto.setTecnicoAsignado(usuarioMapper.toDTO(ticket.getTecnicoAsignado()));

        return dto;
    }

    public Ticket toEntity(TicketRequestDTO dto, Usuario creador) {
        if (dto == null) return null;
        Ticket ticket = new Ticket();
        ticket.setTitulo(dto.getTitulo());
        ticket.setDescripcion(dto.getDescripcion());
        ticket.setPrioridad(dto.getPrioridad());
        ticket.setEstado(Estado.ABIERTO);
        ticket.setCreador(creador);
        return ticket;
    }
}
