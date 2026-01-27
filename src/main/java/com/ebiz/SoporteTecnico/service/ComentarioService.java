package com.ebiz.SoporteTecnico.service;

import com.ebiz.SoporteTecnico.service.dto.entrada.ComentarioRequestDTO;
import com.ebiz.SoporteTecnico.service.dto.salida.ComentarioResponseDTO;
import com.ebiz.SoporteTecnico.entity.Comentario;
import com.ebiz.SoporteTecnico.entity.Ticket;
import com.ebiz.SoporteTecnico.entity.Usuario;
import com.ebiz.SoporteTecnico.mapper.ComentarioMapper;
import com.ebiz.SoporteTecnico.repository.ComentarioRepository;
import com.ebiz.SoporteTecnico.repository.TicketRepository;
import com.ebiz.SoporteTecnico.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final TicketRepository ticketRepository;
    private final UsuarioRepository usuarioRepository;
    private final ComentarioMapper comentarioMapper;

    public ComentarioService(ComentarioRepository comentarioRepository, TicketRepository ticketRepository, UsuarioRepository usuarioRepository, ComentarioMapper comentarioMapper) {
        this.comentarioRepository = comentarioRepository;
        this.ticketRepository = ticketRepository;
        this.usuarioRepository = usuarioRepository;
        this.comentarioMapper = comentarioMapper;
    }

    public ComentarioResponseDTO agregarComentario(ComentarioRequestDTO request) {
        Ticket ticket = ticketRepository.findById(request.getTicketId())
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Comentario comentario = comentarioMapper.toEntity(request, usuario, ticket);
        Comentario guardado = comentarioRepository.save(comentario);

        return comentarioMapper.toDTO(guardado);
    }

    public List<ComentarioResponseDTO> listarComentariosPorTicket(Long ticketId) {
        return comentarioRepository.findByTicketIdOrderByCreatedAtAsc(ticketId).stream()
                .map(comentarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}