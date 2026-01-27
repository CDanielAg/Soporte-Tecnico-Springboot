package com.ebiz.SoporteTecnico.service;

import com.ebiz.SoporteTecnico.service.dto.entrada.AdjuntoRequestDTO;
import com.ebiz.SoporteTecnico.service.dto.salida.AdjuntoResponseDTO;
import com.ebiz.SoporteTecnico.entity.Adjunto;
import com.ebiz.SoporteTecnico.entity.Ticket;
import com.ebiz.SoporteTecnico.mapper.AdjuntoMapper;
import com.ebiz.SoporteTecnico.repository.AdjuntoRepository;
import com.ebiz.SoporteTecnico.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdjuntoService {

    private final AdjuntoRepository adjuntoRepository;
    private final TicketRepository ticketRepository;
    private final AdjuntoMapper adjuntoMapper;

    public AdjuntoService(AdjuntoRepository adjuntoRepository, TicketRepository ticketRepository, AdjuntoMapper adjuntoMapper) {
        this.adjuntoRepository = adjuntoRepository;
        this.ticketRepository = ticketRepository;
        this.adjuntoMapper = adjuntoMapper;
    }

    public AdjuntoResponseDTO guardarAdjunto(AdjuntoRequestDTO request) {
        Ticket ticket = ticketRepository.findById(request.getTicketId())
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));

        Adjunto adjunto = adjuntoMapper.toEntity(request, ticket);
        Adjunto guardado = adjuntoRepository.save(adjunto);

        return adjuntoMapper.toDTO(guardado);
    }

    public List<AdjuntoResponseDTO> listarAdjuntosPorTicket(Long ticketId) {
        return adjuntoRepository.findByTicketId(ticketId).stream()
                .map(adjuntoMapper::toDTO)
                .collect(Collectors.toList());
    }
}