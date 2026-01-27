package com.ebiz.SoporteTecnico.mapper;

import com.ebiz.SoporteTecnico.controller.dto.entrada.AdjuntoRequestDTO;
import com.ebiz.SoporteTecnico.controller.dto.salida.AdjuntoResponseDTO;
import com.ebiz.SoporteTecnico.entity.Adjunto;
import com.ebiz.SoporteTecnico.entity.Ticket;
import org.springframework.stereotype.Component;

@Component
public class AdjuntoMapper {
    public AdjuntoResponseDTO toDTO(Adjunto adjunto) {
        if (adjunto == null) return null;
        AdjuntoResponseDTO dto = new AdjuntoResponseDTO();
        dto.setId(adjunto.getId());
        dto.setFileName(adjunto.getFileName());
        dto.setFileType(adjunto.getFileType());
        dto.setData(adjunto.getData());
        return dto;
    }

    public Adjunto toEntity(AdjuntoRequestDTO dto, Ticket ticket) {
        if (dto == null) return null;
        Adjunto adjunto = new Adjunto();
        adjunto.setFileName(dto.getFileName());
        adjunto.setFileType(dto.getFileType());
        adjunto.setData(dto.getData());
        adjunto.setTicket(ticket);
        return adjunto;
    }
}
